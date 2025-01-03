package de.WorkWithPower.nordicLegends.datagen;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.register.ModBlocks;
import de.WorkWithPower.nordicLegends.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VikingMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_MITHRIL.get());
        basicItem(ModItems.MITHRIL_NUGGET.get());
        basicItem(ModItems.MITHRIL.get());
        basicItem(ModItems.HORN.get());
        basicItem(ModItems.MET.get());
        basicItem(ModItems.FIREWOOD.get());

        buttonItem(ModBlocks.ELDERWOOD_BUTTON, ModBlocks.ELDERWOOD_PLANKS);
    }

    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock){
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(VikingMod.MOD_ID, "block/" + baseBlock.getId().getPath()));
    }
}
