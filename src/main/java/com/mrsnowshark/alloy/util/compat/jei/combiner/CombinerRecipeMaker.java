package com.mrsnowshark.alloy.util.compat.jei.combiner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.mrsnowshark.alloy.blocks.combiner.CombinerRecipes;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class CombinerRecipeMaker {

	public static List<CombinerRecipe> getRecipe(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		CombinerRecipes instance = CombinerRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<CombinerRecipe> jeiRecipes = Lists.newArrayList();

		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
			for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				CombinerRecipe recipe = new CombinerRecipe(inputs, output);
				jeiRecipes.add(recipe);
			}
		}
		return jeiRecipes;
	}
}
