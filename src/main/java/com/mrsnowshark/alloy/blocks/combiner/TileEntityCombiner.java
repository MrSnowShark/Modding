package com.mrsnowshark.alloy.blocks.combiner;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCombiner extends TileEntity implements ITickable, ICapabilityProvider {

	private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
	private String customName;
	private ItemStackHandler handler;

	private int burnTime;
	private int currentBurnTime;
	private int cookTime;
	private int totalCookTime;

	public TileEntityCombiner() {
		this.handler = new ItemStackHandler(4);
	}

	public String getName() {
		return this.hasCustomName() ? this.customName : "container.combiner";
	}

	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName())
				: new TextComponentTranslation(this.getName());
	}

	public int getSizeInventory() {
		return this.inventory.size();
	}

	public boolean isEmpty() {
		for (ItemStack stack : this.inventory) {
			if (!stack.isEmpty())
				return false;
		}
		return true;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	@SideOnly(Side.CLIENT)
	public static boolean isBurning(TileEntityCombiner tileentity) {
		return tileentity.getField(0) > 0;
	}

	public void update() {
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isBurning())
			--this.burnTime;

		if (!this.world.isRemote) {
			ItemStack stack = (ItemStack) this.inventory.get(2);

			if (this.isBurning() || !stack.isEmpty() && !((((ItemStack) this.inventory.get(0)).isEmpty())
					|| ((ItemStack) this.inventory.get(1)).isEmpty())) {
				if (!this.isBurning() && this.canSmelt()) {
					this.burnTime = getItemBurnTime(stack);
					this.currentBurnTime = this.burnTime;

					if (this.isBurning()) {
						flag1 = true;

						if (!stack.isEmpty()) {
							Item item = stack.getItem();
							stack.shrink(1);

							if (stack.isEmpty()) {
								ItemStack item1 = item.getContainerItem(stack);
								this.inventory.set(2, item1);
							}
						}
					}
				}
				if (this.isBurning() && this.canSmelt()) {
					++this.cookTime;

					if (this.cookTime == this.totalCookTime) {
						this.cookTime = 0;
						this.totalCookTime = this.getCookTime((ItemStack) this.inventory.get(0),
								(ItemStack) this.inventory.get(1));
						this.smeltItem();
						flag1 = true;
					}
				} else
					this.cookTime = 0;
			} else if (!this.isBurning() && this.cookTime > 0) {
				this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
			}
			if (flag != this.isBurning()) {
				flag1 = true;
				Combiner.setState(this.isBurning(), this.world, this.pos);
			}
		}
		if (flag1)
			this.markDirty();
	}

	public int getCookTime(ItemStack input1, ItemStack input2) {
		return 200;
	}

	private boolean canSmelt() {
		if (((ItemStack) this.inventory.get(0)).isEmpty() || ((ItemStack) this.inventory.get(1)).isEmpty())
			return false;
		else {
			ItemStack result = CombinerRecipes.getInstance().getCombinerResult((ItemStack) this.inventory.get(0),
					(ItemStack) this.inventory.get(1));
			if (result.isEmpty())
				return false;
			else {
				ItemStack output = (ItemStack) this.inventory.get(3);
				if (output.isEmpty())
					return true;
				if (!output.isItemEqual(result))
					return false;
				int res = output.getCount() + result.getCount();
				return res <= getInventoryStackLimit() && res <= output.getMaxStackSize();
			}
		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack input1 = (ItemStack) this.inventory.get(0);
			ItemStack input2 = (ItemStack) this.inventory.get(1);
			ItemStack result = CombinerRecipes.getInstance().getCombinerResult(input1, input2);
			ItemStack output = (ItemStack) this.inventory.get(3);

			if (output.isEmpty())
				this.inventory.set(3, result.copy());
			else if (output.getItem() == result.getItem())
				output.grow(result.getCount());

			input1.shrink(1);
			input2.shrink(1);
		}
	}

	public static int getItemBurnTime(ItemStack fuel) {
		if (fuel.isEmpty())
			return 0;
		else {
			Item item = fuel.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) {
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.WOODEN_SLAB)
					return 150;
				if (block.getDefaultState().getMaterial() == Material.WOOD)
					return 300;
				if (block == Blocks.COAL_BLOCK)
					return 16000;
			}

			if (item instanceof ItemTool && "WOOD".equals(((ItemTool) item).getToolMaterialName()))
				return 200;
			if (item instanceof ItemSword && "WOOD".equals(((ItemSword) item).getToolMaterialName()))
				return 200;
			if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe) item).getMaterialName()))
				return 200;
			if (item == Items.STICK)
				return 100;
			if (item == Items.COAL)
				return 1600;
			if (item == Items.LAVA_BUCKET)
				return 20000;
			if (item == Item.getItemFromBlock(Blocks.SAPLING))
				return 100;
			if (item == Items.BLAZE_ROD)
				return 2400;

			return GameRegistry.getFuelValue(fuel);
		}
	}

	public static boolean isItemFuel(ItemStack fuel) {
		return getItemBurnTime(fuel) > 0;
	}

	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false
				: player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
						(double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {

		if (index == 3)
			return false;
		else if (index != 2)
			return true;
		else {
			return isItemFuel(stack);
		}
	}

	public String getGuiID() {
		return "am:combiner";
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.burnTime;
		case 1:
			return this.currentBurnTime;
		case 2:
			return this.cookTime;
		case 3:
			return this.totalCookTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.burnTime = value;
			break;
		case 1:
			this.currentBurnTime = value;
			break;
		case 2:
			this.cookTime = value;
			break;
		case 3:
			this.totalCookTime = value;
		}
	}

	@Override
	public void tick() {

	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) this.handler;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.inventory);
		this.burnTime = compound.getInteger("BurnTime");
		this.cookTime = compound.getInteger("CookTime");
		this.totalCookTime = compound.getInteger("CookTimeTotal");
		this.currentBurnTime = getItemBurnTime((ItemStack) this.inventory.get(2));

		if (compound.hasKey("CustomName", 8))
			this.setCustomName(compound.getString("CustomName"));

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("ItemStackHandler", handler.serializeNBT());
		compound.setInteger("BurnTime", (short) this.burnTime);
		compound.setInteger("CookTime", (short) this.cookTime);
		compound.setInteger("CookTimeTotal", (short) this.totalCookTime);
		ItemStackHelper.saveAllItems(compound, this.inventory);

		if (this.hasCustomName())
			compound.setString("CustomName", this.customName);
		return compound;
	}
}
