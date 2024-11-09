package org.snickers.fivehundredsnickers;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.snickers.fivehundredsnickers.block.ModBlocks;
import org.snickers.fivehundredsnickers.item.ModCreativeModTabs;
import org.snickers.fivehundredsnickers.item.ModItems;

@Mod(FiveHundredSnickers.MOD_ID)
public class FiveHundredSnickers {
    public static final String MOD_ID = "fivehundredsnickers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FiveHundredSnickers() {
        LOGGER.error("FiveHundredSnickers failed to load. Please update your FORGE");
    }

    public FiveHundredSnickers(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        FiveHundredSnickers.LOGGER.info("My nigga starts!");
        ModCreativeModTabs.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

}
