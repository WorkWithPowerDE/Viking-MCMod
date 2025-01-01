package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
