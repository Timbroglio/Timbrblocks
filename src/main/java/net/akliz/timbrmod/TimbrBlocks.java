package net.akliz.timbrmod;

import com.mojang.logging.LogUtils;
import net.akliz.timbrmod.block.ModBlocks;
import net.akliz.timbrmod.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TimbrBlocks.MOD_ID)
public class TimbrBlocks {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "timbrblocks";

    public TimbrBlocks() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //Calls the register function to grab all items from the deferred list in ModItems
        ModItems.register(eventBus);
        //Calls the register fucntion to grab all items from the deferred list in ModBlocks
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM TIMBRBLOCKS");
    }
}