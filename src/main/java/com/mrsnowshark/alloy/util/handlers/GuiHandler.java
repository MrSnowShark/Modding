package com.mrsnowshark.alloy.util.handlers;

import com.mrsnowshark.alloy.blocks.combiner.ContainerCombiner;
import com.mrsnowshark.alloy.blocks.combiner.GuiCombiner;
import com.mrsnowshark.alloy.blocks.combiner.TileEntityCombiner;
import com.mrsnowshark.alloy.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_COMBINER)
			return new ContainerCombiner(player.inventory, (TileEntityCombiner) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Reference.GUI_COMBINER)
			return new GuiCombiner(player.inventory, (TileEntityCombiner) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
