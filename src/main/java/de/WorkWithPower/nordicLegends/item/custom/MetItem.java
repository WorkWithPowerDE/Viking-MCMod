package de.WorkWithPower.nordicLegends.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import java.util.List;
import java.util.Properties;

public class MetItem extends Item{

    public MetItem(Properties properties){
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack){
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.nordic_legends_mod.met.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
