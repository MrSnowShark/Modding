package com.mrsnowshark.alloy.util.compat.jei.combiner;

import com.mrsnowshark.alloy.util.Reference;
import com.mrsnowshark.alloy.util.compat.jei.RecipeCategories;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;

public class CombinerRecipeCategory extends AbstractCombinerRecipeCategory<CombinerRecipe> {

	private final IDrawable background;
	private final String name;

	public CombinerRecipeCategory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 10, 150, 70);
		name = "Combiner";
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		animatedFlame.draw(minecraft, 4, 44);
		animatedArrow.draw(minecraft, 40, 25);
	}

	@Override
	public String getUid() {
		return RecipeCategories.COMBINER;
	}

	@Override
	public String getTitle() {
		return name;
	}

	@Override
	public String getModName() {
		return Reference.NAME;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, CombinerRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 21, 0);
		stacks.init(input2, true, 21, 48);
		stacks.init(output, false, 76, 25);
		stacks.set(ingredients);
	}
}
