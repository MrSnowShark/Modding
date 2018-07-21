package com.mrsnowshark.alloy.items.tools;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.init.tabAlloy;
import com.mrsnowshark.alloy.util.IHasModel;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String name, ToolMaterial material) {
		super(material, 6.0F, -3.0F);
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
