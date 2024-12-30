package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VikingMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_MITHRIL.get());
        basicItem(ModItems.MITHRIL_NUGGET.get());
        basicItem(ModItems.MITHRIL.get());
    }
}
