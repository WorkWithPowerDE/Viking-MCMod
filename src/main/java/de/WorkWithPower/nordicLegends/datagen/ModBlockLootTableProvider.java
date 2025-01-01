package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import de.WorkWithPower.nordicLegends.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MITHRIL_BLOCK.get());
        dropSelf(ModBlocks.BREWING_BARREL.get());


        add(ModBlocks.MITHRIL_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_DEEPSLATE_ORE.get(), ModItems.RAW_MITHRIL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
