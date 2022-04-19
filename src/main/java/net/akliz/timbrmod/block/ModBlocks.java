package net.akliz.timbrmod.block;

import net.akliz.timbrmod.TimbrBlocks;
import net.akliz.timbrmod.item.ModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.akliz.timbrmod.item.ModItems;

import java.util.function.Supplier;


public class ModBlocks {
    //Creates registry map, prepares for later Registration event
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TimbrBlocks.MOD_ID);

    public static final RegistryObject<Block> PLATE_BLOCK = registerBlock("plate_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(2f).sound(SoundType.METAL)), ModCreativeModeTab.TIMBR_TAB);

    public static final RegistryObject<Block> LIT_PLATE_BLOCK = registerBlock("lit_plate_block",
            () -> new LitPlateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).sound(SoundType.METAL).lightLevel((pLightLevel) -> 8)), ModCreativeModeTab.TIMBR_TAB);
    //Helper method, registers the block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Helper method, registers the block item
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    //Registration event, passes eventBus to main class
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}