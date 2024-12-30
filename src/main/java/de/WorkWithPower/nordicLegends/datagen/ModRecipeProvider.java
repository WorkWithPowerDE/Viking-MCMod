package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.ModBlocks;
import de.WorkWithPower.nordicLegends.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL,
            ModBlocks.MITHRIL_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MITHRIL_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MITHRIL.get())
                .unlockedBy("has_mithril", has(ModItems.MITHRIL)).save(recipeOutput,"nordic_legends_mod:mithril_block_from_mithril");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MITHRIL.get(), 9)
                .requires(ModBlocks.MITHRIL_BLOCK)
                .unlockedBy("has_mithril_block", has(ModBlocks.MITHRIL_BLOCK)).save(recipeOutput, "nordic_legends_mod:mithril_from_block");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MITHRIL.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.MITHRIL.get())
                .unlockedBy("has_mithril_nugget", has(ModItems.MITHRIL_NUGGET)).save(recipeOutput,"nordic_legends_mod:mithril_block_from_nuggets");

        oreSmelting(recipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_NUGGET.get(),0.75f,600, "mithril");
        oreBlasting(recipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_NUGGET.get(),1f,450, "mithril");

    }

    protected static void oreSmelting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> vCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
        List<ItemLike> vIngredients, RecipeCategory vRecipeCategory, ItemLike vResult, float vExperience, int vCookingTime, String vGroup, String vRecipeName){

        for(ItemLike itemLike: vIngredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), vRecipeCategory, vResult, vExperience, vCookingTime, vCookingSerializer, factory).group(vGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, VikingMod.MOD_ID +":" + getItemName(vResult) + vRecipeName + "_" + getItemName(itemLike));
        }
    }
}
