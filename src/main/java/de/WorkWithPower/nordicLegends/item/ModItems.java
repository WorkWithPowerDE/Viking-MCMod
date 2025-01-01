package de.WorkWithPower.nordicLegends.item;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.item.custom.FuelItem;
import de.WorkWithPower.nordicLegends.item.custom.MetItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VikingMod.MOD_ID);

    public static  final DeferredItem<Item> MITHRIL = ITEMS.register("mithril",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.nordic_legends_mod.raw_mithril.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static  final DeferredItem<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> HORN = ITEMS.register("horn",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MET = ITEMS.register("met",
    () -> new MetItem(new Item.Properties().food(ModFoodProperties.MET)));

    public static final DeferredItem<Item> FIREWOOD = ITEMS.register("firewood",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
