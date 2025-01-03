package de.WorkWithPower.nordicLegends.item;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VikingMod.MOD_ID);

    public static  final Supplier<CreativeModeTab> NORDIC_LEGENDS_ITEMS = CREATIVE_MODE_TAB.register("nordic_legends_items",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MITHRIL.get()))
                    .title(Component.translatable("creativetab.nordic_legends_mod.items"))
                    .displayItems((itemDisplayParameters ,output) ->{
                        output.accept(ModItems.MITHRIL);
                        output.accept(ModItems.RAW_MITHRIL);
                        output.accept(ModItems.MITHRIL_NUGGET);
                        output.accept(ModItems.HORN);
                        output.accept(ModItems.MET);
                        output.accept(ModItems.FIREWOOD);
                    })
                .build());

    public static  final Supplier<CreativeModeTab> NORDIC_LEGENDS_BLOCK = CREATIVE_MODE_TAB.register("nordic_legends_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.MITHRIL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VikingMod.MOD_ID, "nordic_legends_items"))
                    .title(Component.translatable("creativetab.nordic_legends_mod.blocks"))
                    .displayItems((itemDisplayParameters ,output) ->{
                        output.accept(ModBlocks.MITHRIL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MITHRIL_BLOCK);
                        output.accept(ModBlocks.BREWING_BARREL);

                        output.accept(ModBlocks.ELDERWOOD_LOGS);
                        output.accept(ModBlocks.ELDERWOOD_PLANKS);
                        output.accept(ModBlocks.ELDERWOOD_SLAB);
                        output.accept(ModBlocks.ELDERWOOD_STAIRS);
                        output.accept(ModBlocks.ELDERWOOD_PRESSURE_PLATE);
                        output.accept(ModBlocks.ELDERWOOD_BUTTON);

                    })
                .build());

    public static void register (IEventBus eventBus){
    CREATIVE_MODE_TAB.register(eventBus);
    }
}
