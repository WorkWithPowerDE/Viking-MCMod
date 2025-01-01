package de.WorkWithPower.nordicLegends.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties MET = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 240), 0.89f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30000,5),1)
            .alwaysEdible()
    .build();
}
