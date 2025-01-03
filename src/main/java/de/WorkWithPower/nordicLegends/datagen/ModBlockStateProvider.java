package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.fml.common.Mod;
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
        // Register blocks with item
        blockWithItem(ModBlocks.MITHRIL_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BREWING_BARREL);

        // Register Elderwood blocks
        blockWithItem(ModBlocks.ELDERWOOD_LOGS);
        blockWithItem(ModBlocks.ELDERWOOD_PLANKS);

        // Register Elderwood stairs
        stairsBlock(
                (StairBlock) ModBlocks.ELDERWOOD_STAIRS.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );
        blockItem(ModBlocks.ELDERWOOD_STAIRS);

        // Register Elderwood slab
        slabBlock(
                (SlabBlock) ModBlocks.ELDERWOOD_SLAB.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get()),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );
        blockItem(ModBlocks.ELDERWOOD_SLAB);

        // Register Elderwood pressure plate
        pressurePlateBlock(
                (PressurePlateBlock) ModBlocks.ELDERWOOD_PRESSURE_PLATE.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );
        blockItem(ModBlocks.ELDERWOOD_PRESSURE_PLATE);

        // Register Elderwood button
        buttonBlock(
                (ButtonBlock) ModBlocks.ELDERWOOD_BUTTON.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );

        // Register Elderwood fence
        fenceBlock(
                (FenceBlock) ModBlocks.ELDERWOOD_FENCE.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );

        // Register Elderwood fence gate
        fenceGateBlock(
                (FenceGateBlock) ModBlocks.ELDERWOOD_FENCE_GATE.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );
        blockItem(ModBlocks.ELDERWOOD_FENCE_GATE);

        // Register Elderwood wall
        wallBlock(
                (WallBlock) ModBlocks.ELDERWOOD_WALL.get(),
                blockTexture(ModBlocks.ELDERWOOD_PLANKS.get())
        );

        //Register Elderwood Door
        doorBlockWithRenderType(((DoorBlock) ModBlocks.ELDERWOOD_DOOR.get()), modLoc("block/elderwood_door_bottom"), modLoc("block/elderwood_door_top"), "cutout");

        //Register Elderwood Trapoor
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.ELDERWOOD_TRAPDOOR.get()), modLoc("block/elderwood_trapdoor"), true, "cutout");
        blockItem(ModBlocks.ELDERWOOD_TRAPDOOR,"_bottom");
    }


    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nordic_legends_mod:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("nordic_legends_mod:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
