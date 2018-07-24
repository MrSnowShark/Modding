package com.mrsnowshark.alloy.items;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.init.tabAlloy;
import com.mrsnowshark.alloy.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tabAlloy.tabAlloy);

		AlloyItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Alloy.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
