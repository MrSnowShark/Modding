package com.mrsnowshark.alloy.blocks.combiner;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.mrsnowshark.alloy.init.AlloyItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CombinerRecipes {

	private static final CombinerRecipes INSTANCE = new CombinerRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

	public static CombinerRecipes getInstance() {
		return INSTANCE;
	}

	private CombinerRecipes() {
		addCombinerRecipe(new ItemStack(Items.DIAMOND), new ItemStack(Items.IRON_INGOT), new ItemStack(AlloyItems.IRONDIAMOND), 10.0F);
		addCombinerRecipe(new ItemStack(Items.DIAMOND), new ItemStack(Items.GOLD_INGOT), new ItemStack(AlloyItems.GOLDDIAMOND), 10.0F);
		addCombinerRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(AlloyItems.IRONGOLD), 10.0F);
		addCombinerRecipe(new ItemStack(Items.DIAMOND), new ItemStack(Items.IRON_INGOT), new ItemStack(AlloyItems.IRONDIAMOND), 10.0F);
		addCombinerRecipe(new ItemStack(Items.DIAMOND), new ItemStack(Items.EMERALD), new ItemStack(AlloyItems.EMERALDDIAMOND), 10.0F);
		addCombinerRecipe(new ItemStack(AlloyItems.IRONDIAMOND), new ItemStack(Items.GOLD_INGOT), new ItemStack(AlloyItems.MEGAMITE), 10.0F);
		addCombinerRecipe(new ItemStack(AlloyItems.GOLDDIAMOND), new ItemStack(Items.IRON_INGOT), new ItemStack(AlloyItems.MEGAMITE), 10.0F);
		addCombinerRecipe(new ItemStack(AlloyItems.IRONGOLD), new ItemStack(Items.DIAMOND), new ItemStack(AlloyItems.MEGAMITE), 10.0F);
	}

	public void addCombinerRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {
		if (getCombinerResult(input1, input2) != ItemStack.EMPTY)
			return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}

	public ItemStack getCombinerResult(ItemStack input1, ItemStack input2) {
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if (this.compareItemStacks(input1, entry.getKey()) || this.compareItemStacks(input2, entry.getKey())) {
				for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if (this.compareItemStacks(input2, ent.getKey()) || this.compareItemStacks(input1, ent.getKey())) {
						return ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}

	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		return this.smeltingList;
	}

	public float getCombinerExperience(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if (this.compareItemStacks(stack, (ItemStack) entry.getKey())) {
				return ((Float) entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}