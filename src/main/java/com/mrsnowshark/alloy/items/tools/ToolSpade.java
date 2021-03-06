package com.mrsnowshark.alloy.items.tools;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.init.tabAlloy;
import com.mrsnowshark.alloy.util.IHasModel;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {

	public ToolSpade(String name, ToolMaterial material) {
		super(material);
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
