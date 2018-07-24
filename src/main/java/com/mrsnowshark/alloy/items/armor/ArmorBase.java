package com.mrsnowshark.alloy.items.armor;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.init.tabAlloy;
import com.mrsnowshark.alloy.util.IHasModel;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
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
