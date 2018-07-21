package com.mrsnowshark.alloy.util.handlers;

import com.mrsnowshark.alloy.blocks.combiner.TileEntityCombiner;
import com.mrsnowshark.alloy.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityCombiner.class, new ResourceLocation(Reference.MOD_ID, "combiner"));
	}
}
