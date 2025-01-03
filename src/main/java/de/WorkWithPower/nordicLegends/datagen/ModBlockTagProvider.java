package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import de.WorkWithPower.nordicLegends.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VikingMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MITHRIL_BLOCK.get())
                .add(ModBlocks.MITHRIL_DEEPSLATE_ORE.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BREWING_BARREL.get());

        tag(ModTags.Blocks.BREWING_BARRELS)
                .add(ModBlocks.BREWING_BARREL.get());

        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ELDERWOOD_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ELDERWOOD_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.ELDERWOOD_WALL.get());
    }
}
