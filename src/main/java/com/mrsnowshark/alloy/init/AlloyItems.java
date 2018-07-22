package com.mrsnowshark.alloy.init;

import java.util.ArrayList;
import java.util.List;

import com.mrsnowshark.alloy.items.ItemBase;
import com.mrsnowshark.alloy.items.armor.ArmorBase;
import com.mrsnowshark.alloy.items.tools.ToolAxe;
import com.mrsnowshark.alloy.items.tools.ToolHoe;
import com.mrsnowshark.alloy.items.tools.ToolPickaxe;
import com.mrsnowshark.alloy.items.tools.ToolSpade;
import com.mrsnowshark.alloy.items.tools.ToolSword;
import com.mrsnowshark.alloy.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class AlloyItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Materials
	public static final ToolMaterial IDT = EnumHelper.addToolMaterial("IDT", 3, 1850, 14.0F, 6, 24);
	public static ArmorMaterial IDA = EnumHelper.addArmorMaterial("IDA", Reference.MOD_ID + ":irondiamond", 48,
			new int[] { 5, 11, 14, 6 }, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial GDT = EnumHelper.addToolMaterial("GDT", 3, 1600, 20.0F, 5, 32);
	public static ArmorMaterial GDA = EnumHelper.addArmorMaterial("GDA", Reference.MOD_ID + ":golddiamond", 40,
			new int[] { 4, 9, 13, 5 }, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial OBT = EnumHelper.addToolMaterial("OBT", 3, 1400, 6.0F, 5, 9);
	public static ArmorMaterial OBA = EnumHelper.addArmorMaterial("OBA", Reference.MOD_ID + ":obsidian", 25,
			new int[] { 3, 5, 7, 5 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial IGT = EnumHelper.addToolMaterial("IGT", 2, 500, 18.0F, 3, 36);
	public static ArmorMaterial IGA = EnumHelper.addArmorMaterial("IGA", Reference.MOD_ID + ":irongold", 22,
			new int[] { 3, 8, 11, 4 }, 34, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial MMT = EnumHelper.addToolMaterial("MMT", 3, 2100, 26.0F, 8, 40);
	public static ArmorMaterial MMA = EnumHelper.addArmorMaterial("MMA", Reference.MOD_ID + ":megamite", 56,
			new int[] { 6, 14, 19, 8 }, 44, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial EMT = EnumHelper.addToolMaterial("EMT", 3, 1200, 7.0F, 3, 9);
	public static ArmorMaterial EMA = EnumHelper.addArmorMaterial("EMA", Reference.MOD_ID + ":emerald", 22,
			new int[] { 2, 6, 8, 5 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static ToolMaterial EDT = EnumHelper.addToolMaterial("EDT", 3, 2000, 15.0F, 6, 19);
	public static ArmorMaterial EDA = EnumHelper.addArmorMaterial("EDA", Reference.MOD_ID + ":emeralddiamond", 45,
			new int[] { 5, 12, 16, 7 }, 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	// Materials
	public static final Item IRONDIAMOND = new ItemBase("irondiamond");
	public static final Item GOLDDIAMOND = new ItemBase("golddiamond");
	public static final Item IRONGOLD = new ItemBase("irongold");
	public static final Item EMERALDDIAMOND = new ItemBase("emeralddiamond");
	public static final Item MEGAMITE = new ItemBase("megamite");

	// Tools
	public static final ItemSword IRONDIAMOND_SWORD = new ToolSword("irondiamondsword", IDT);
	public static final ItemSpade IRONDIAMOND_SHOVEL = new ToolSpade("irondiamondshovel", IDT);
	public static final ItemPickaxe IRONDIAMOND_PICKAXE = new ToolPickaxe("irondiamondpickaxe", IDT);
	public static final ItemAxe IRONDIAMOND_AXE = new ToolAxe("irondiamondaxe", IDT);
	public static final ItemHoe IRONDIAMOND_HOE = new ToolHoe("irondiamondhoe", IDT);

	public static final ItemSword GOLDDIAMOND_SWORD = new ToolSword("golddiamondsword", GDT);
	public static final ItemSpade GOLDDIAMOND_SHOVEL = new ToolSpade("golddiamondshovel", GDT);
	public static final ItemPickaxe GOLDDIAMOND_PICKAXE = new ToolPickaxe("golddiamondpickaxe", GDT);
	public static final ItemAxe GOLDDIAMOND_AXE = new ToolAxe("golddiamondaxe", GDT);
	public static final ItemHoe GOLDDIAMOND_HOE = new ToolHoe("golddiamondhoe", GDT);

	public static final ItemSword IRONGOLD_SWORD = new ToolSword("irongoldsword", IGT);
	public static final ItemSpade IRONGOLD_SHOVEL = new ToolSpade("irongoldshovel", IGT);
	public static final ItemPickaxe IRONGOLD_PICKAXE = new ToolPickaxe("irongoldpickaxe", IGT);
	public static final ItemAxe IRONGOLD_AXE = new ToolAxe("irongoldaxe", IGT);
	public static final ItemHoe IRONGOLD_HOE = new ToolHoe("irongoldhoe", IGT);

	public static final ItemSword EMERALDDIAMOND_SWORD = new ToolSword("emeralddiamondsword", EDT);
	public static final ItemSpade EMERALDDIAMOND_SHOVEL = new ToolSpade("emeralddiamondshovel", EDT);
	public static final ItemPickaxe EMERALDDIAMOND_PICKAXE = new ToolPickaxe("emeralddiamondpickaxe", EDT);
	public static final ItemAxe EMERALDDIAMOND_AXE = new ToolAxe("emeralddiamondaxe", EDT);
	public static final ItemHoe EMERALDDIAMOND_HOE = new ToolHoe("emeralddiamondhoe", EDT);

	public static final ItemSword MEGAMITE_SWORD = new ToolSword("megamitesword", MMT);
	public static final ItemSpade MEGAMITE_SHOVEL = new ToolSpade("megamiteshovel", MMT);
	public static final ItemPickaxe MEGAMITE_PICKAXE = new ToolPickaxe("megamitepickaxe", MMT);
	public static final ItemAxe MEGAMITE_AXE = new ToolAxe("megamiteaxe", MMT);
	public static final ItemHoe MEGAMITE_HOE = new ToolHoe("megamitehoe", MMT);

	public static final ItemSword EMERALD_SWORD = new ToolSword("emeraldsword", EMT);
	public static final ItemSpade EMERALD_SHOVEL = new ToolSpade("emeraldshovel", EMT);
	public static final ItemPickaxe EMERALD_PICKAXE = new ToolPickaxe("emeraldpickaxe", EMT);
	public static final ItemAxe EMERALD_AXE = new ToolAxe("emeraldaxe", EMT);
	public static final ItemHoe EMERALD_HOE = new ToolHoe("emeraldhoe", EMT);

	public static final ItemSword OBSIDIAN_SWORD = new ToolSword("obsidiansword", OBT);
	public static final ItemSpade OBSIDIAN_SHOVEL = new ToolSpade("obsidianshovel", OBT);
	public static final ItemPickaxe OBSIDIAN_PICKAXE = new ToolPickaxe("obsidianpickaxe", OBT);
	public static final ItemAxe OBSIDIAN_AXE = new ToolAxe("obsidianaxe", OBT);
	public static final ItemHoe OBSIDIAN_HOE = new ToolHoe("obsidianhoe", OBT);

	// Armor
	public static final Item IRONDIAMOND_HELMET = new ArmorBase("irondiamondhelmet", IDA, 1, EntityEquipmentSlot.HEAD);
	public static final Item IRONDIAMOND_CHESTPLATE = new ArmorBase("irondiamondchestplate", IDA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item IRONDIAMOND_LEGGINGS = new ArmorBase("irondiamondleggings", IDA, 2,
			EntityEquipmentSlot.LEGS);
	public static final Item IRONDIAMOND_BOOTS = new ArmorBase("irondiamondboots", IDA, 1, EntityEquipmentSlot.FEET);

	public static final Item GOLDDIAMOND_HELMET = new ArmorBase("golddiamondhelmet", GDA, 1, EntityEquipmentSlot.HEAD);
	public static final Item GOLDDIAMOND_CHESTPLATE = new ArmorBase("golddiamondchestplate", GDA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item GOLDDIAMOND_LEGGINGS = new ArmorBase("golddiamondleggings", GDA, 2,
			EntityEquipmentSlot.LEGS);
	public static final Item GOLDDIAMOND_BOOTS = new ArmorBase("golddiamondboots", GDA, 1, EntityEquipmentSlot.FEET);

	public static final Item IRONGOLD_HELMET = new ArmorBase("irongoldhelmet", IGA, 1, EntityEquipmentSlot.HEAD);
	public static final Item IRONGOLD_CHESTPLATE = new ArmorBase("irongoldchestplate", IGA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item IRONGOLD_LEGGINGS = new ArmorBase("irongoldleggings", IGA, 2, EntityEquipmentSlot.LEGS);
	public static final Item IRONGOLD_BOOTS = new ArmorBase("irongoldboots", IGA, 1, EntityEquipmentSlot.FEET);

	public static final Item EMERALDDIAMOND_HELMET = new ArmorBase("emeralddiamondhelmet", EDA, 1,
			EntityEquipmentSlot.HEAD);
	public static final Item EMERALDDIAMOND_CHESTPLATE = new ArmorBase("emeralddiamondchestplate", EDA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item EMERALDDIAMOND_LEGGINGS = new ArmorBase("emeralddiamondleggings", EDA, 2,
			EntityEquipmentSlot.LEGS);
	public static final Item EMERALDDIAMOND_BOOTS = new ArmorBase("emeralddiamondboots", EDA, 1,
			EntityEquipmentSlot.FEET);

	public static final Item MEGAMITE_HELMET = new ArmorBase("megamitehelmet", MMA, 1, EntityEquipmentSlot.HEAD);
	public static final Item MEGAMITE_CHESTPLATE = new ArmorBase("megamitechestplate", MMA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item MEGAMITE_LEGGINGS = new ArmorBase("megamiteleggings", MMA, 2, EntityEquipmentSlot.LEGS);
	public static final Item MEGAMITE_BOOTS = new ArmorBase("megamiteboots", MMA, 1, EntityEquipmentSlot.FEET);

	public static final Item EMERALD_HELMET = new ArmorBase("emeraldhelmet", EMA, 1, EntityEquipmentSlot.HEAD);
	public static final Item EMERALD_CHESTPLATE = new ArmorBase("emeraldchestplate", EMA, 1, EntityEquipmentSlot.CHEST);
	public static final Item EMERALD_LEGGINGS = new ArmorBase("emeraldleggings", EMA, 2, EntityEquipmentSlot.LEGS);
	public static final Item EMERALD_BOOTS = new ArmorBase("emeraldboots", EMA, 1, EntityEquipmentSlot.FEET);

	public static final Item OBSIDIAN_HELMET = new ArmorBase("obsidianhelmet", OBA, 1, EntityEquipmentSlot.HEAD);
	public static final Item OBSIDIAN_CHESTPLATE = new ArmorBase("obsidianchestplate", OBA, 1,
			EntityEquipmentSlot.CHEST);
	public static final Item OBSIDIAN_LEGGINGS = new ArmorBase("obsidianleggings", OBA, 2, EntityEquipmentSlot.LEGS);
	public static final Item OBSIDIAN_BOOTS = new ArmorBase("obsidianboots", OBA, 1, EntityEquipmentSlot.FEET);
}