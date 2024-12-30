package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = VikingMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        PackOutput pOut = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        //Drops
        gen.addProvider(event.includeServer(), new LootTableProvider(pOut, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookUpProvider));

        //Recipes
        gen.addProvider(event.includeServer(), new ModRecipeProvider(pOut, lookUpProvider));

        gen.addProvider(event.includeClient(), new ModItemModelProvider(pOut, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModBlockStateProvider(pOut, existingFileHelper));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(pOut, lookUpProvider, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(), new ModItemTagProvider(pOut, lookUpProvider,blockTagsProvider.contentsGetter(), existingFileHelper));

        gen.addProvider(event.includeServer(),new ModDataMapProvider(pOut, lookUpProvider));
    }
}
