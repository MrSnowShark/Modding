package com.mrsnowshark.alloy.blocks.combiner.slots;

import com.mrsnowshark.alloy.blocks.combiner.TileEntityCombiner;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCombinerFuel extends Slot {

	public SlotCombinerFuel(IInventory tileentity, int index, int x, int y) {
		super(tileentity, index, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityCombiner.isItemFuel(stack);
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
}
