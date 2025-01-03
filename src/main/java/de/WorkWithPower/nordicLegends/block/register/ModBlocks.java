package de.WorkWithPower.nordicLegends.block.register;

import de.WorkWithPower.nordicLegends.VikingMod;
import de.WorkWithPower.nordicLegends.block.custom.BrewingBarrel;
import de.WorkWithPower.nordicLegends.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VikingMod.MOD_ID);

    public static final DeferredBlock<Block> MITHRIL_DEEPSLATE_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(UniformInt.of(50,100), BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(9f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> BREWING_BARREL = registerBlock("brewing_barrel",
            () -> new BrewingBarrel(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .sound(SoundType.WOOD)));


    //Elderwood
    public static final DeferredBlock<Block> ELDERWOOD_LOGS = registerBlock("elderwood_log",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.WOOD)
                    ));

    public static final DeferredBlock<Block> ELDERWOOD_PLANKS = registerBlock("elderwood_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> ELDERWOOD_STAIRS = registerBlock("elderwood_stairs",
            () -> new StairBlock(ModBlocks.ELDERWOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f)));

    public static final DeferredBlock<Block> ELDERWOOD_SLAB = registerBlock("elderwood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> ELDERWOOD_PRESSURE_PLATE = registerBlock("elderwood_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> ELDERWOOD_BUTTON = registerBlock("elderwood_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK,10,BlockBehaviour.Properties.of().strength(2f).noCollission()));

    public static final DeferredBlock<Block> ELDERWOOD_FENCE = registerBlock("elderwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> ELDERWOOD_FENCE_GATE = registerBlock("elderwood_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> ELDERWOOD_WALL = registerBlock("elderwood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> ELDERWOOD_DOOR = registerBlock("elderwood_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final DeferredBlock<Block> ELDERWOOD_TRAPDOOR = registerBlock("elderwood_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    /** Functions*/
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }



    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
