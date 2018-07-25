package com.mrsnowshark.alloy.blocks.combiner.slots;

import com.mrsnowshark.alloy.init.AlloyItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCombinerInput extends Slot {

	public SlotCombinerInput(IInventory tileentity, int index, int x, int y) {
		super(tileentity, index, x, y);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}
}