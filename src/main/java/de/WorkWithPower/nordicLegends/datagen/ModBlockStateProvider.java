package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VikingMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MITHRIL_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BREWING_BARREL);

        blockWithItem(ModBlocks.ELDERWOOD_PLANKS);
        stairsBlock(((StairBlock) ModBlocks.ELDERWOOD_PLANKS.get()), blockTexture(ModBlocks.ELDERWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.ELDERWOOD_PLANKS.get()), blockTexture(ModBlocks.ELDERWOOD_PLANKS.get()), blockTexture(ModBlocks.ELDERWOOD_PLANKS.get()));

        blockItem(ModBlocks.ELDERWOOD_STAIRS);
        blockItem(ModBlocks.ELDERWOOD_SLAB);
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nordic_legends_mod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
