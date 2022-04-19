package net.akliz.timbrmod.item;

import net.akliz.timbrmod.TimbrBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Creates registry map, prepares for later Registration event
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TimbrBlocks.MOD_ID);

    //Registers new item, defines creative tab
    public static final RegistryObject<Item> PLATE = ITEMS.register("color_plate", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TIMBR_TAB)));

    //Registration event, passes eventBus to main class
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
