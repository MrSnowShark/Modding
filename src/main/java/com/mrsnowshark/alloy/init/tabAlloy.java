package com.mrsnowshark.alloy.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class tabAlloy {

	public static final CreativeTabs tabAlloy = (new CreativeTabs("tabAlloy") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(AlloyItems.MEGAMITE);
		}

	});
}