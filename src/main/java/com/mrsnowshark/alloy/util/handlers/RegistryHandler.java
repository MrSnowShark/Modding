package com.mrsnowshark.alloy.util.handlers;

import com.mrsnowshark.alloy.Alloy;
import com.mrsnowshark.alloy.init.AlloyBlocks;
import com.mrsnowshark.alloy.init.AlloyItems;
import com.mrsnowshark.alloy.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {

		event.getRegistry().registerAll(AlloyItems.ITEMS.toArray(new Item[0]));

	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {

		event.getRegistry().registerAll(AlloyBlocks.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {

		for (Item item : AlloyItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}

		for (Block block : AlloyBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}
	}

	public static void preInitRegistries() {

	}

	public static void initRegistries() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Alloy.Instance, new GuiHandler());
	}

	public static void postInitRegistries() {

	}
}
