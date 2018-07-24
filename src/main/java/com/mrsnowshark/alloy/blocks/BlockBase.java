package com.mrsnowshark.alloy.blocks;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyBlocks;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.init.tabAlloy;
import com.mrsnowshark.alloy.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tabAlloy.tabAlloy);

		AlloyBlocks.BLOCKS.add(this);
		AlloyItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Alloy.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
