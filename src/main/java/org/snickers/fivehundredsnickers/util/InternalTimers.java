package org.snickers.fivehundredsnickers.util;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.SnickersConfig;
import org.w3c.dom.html.HTMLImageElement;

@Mod.EventBusSubscriber
public class InternalTimers {
    public static final Capability<InternalTimers> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    static private final Timer repair = new Timer();

    public static void activateRepair() {
        repair.shouldUpdate = SnickersConfig.REPAIR_RATE != -1;
    }

    public static boolean canRepair() {
        FiveHundredSnickers.LOGGER.info(String.valueOf(repair.tickCount));
        if (repair.tickCount == 0) {
            repair.tickCount = SnickersConfig.REPAIR_RATE;
            repair.shouldUpdate = false;
            FiveHundredSnickers.LOGGER.info("It can repair");
            return true;
        }
        repair.tick();
        return false;
    }

    private static class Timer {

        private int tickCount = 0;
        private boolean shouldUpdate = false;

        private void tick() {
            if (shouldUpdate) {
                if (tickCount > 0) {
                    //Ensure we don't go negative if we are set to go off every tick
                    tickCount--;
                }
                shouldUpdate = false; //probably stuck here
            }
        }
    }
}
