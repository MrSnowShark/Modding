package com.mrsnowshark.alloy.blocks.combiner.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCombinerOutput extends Slot {
	
	public SlotCombinerOutput(EntityPlayer player, IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}

	@Override
	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack())
			Math.min(amount, this.getStack().getCount());
		return super.decrStackSize(amount);
	}
}