package com.mrsnowshark.alloy.blocks.combiner.slots;

import com.mrsnowshark.alloy.blocks.combiner.TileEntityCombiner;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotCombinerFuel extends SlotItemHandler{

	public SlotCombinerFuel(IItemHandler inventory, int index, int x, int y) {
		super(inventory, index, x, y);
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
