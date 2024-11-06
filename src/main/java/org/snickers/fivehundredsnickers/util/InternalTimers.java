package org.snickers.fivehundredsnickers.util;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.SnickersConfig;

@Mod.EventBusSubscriber
public class InternalTimers {
    public static final Capability<InternalTimers> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    private final Timer repair = new Timer();

    public void activateRepair() {
        repair.shouldUpdate = SnickersConfig.REPAIR_RATE != -1;
    }

    public boolean canRepair() {
        if (repair.tickCount == 0) {
            FiveHundredSnickers.LOGGER.info("It can repair");
            repair.tickCount = SnickersConfig.REPAIR_RATE;
            repair.shouldUpdate = false;
            FiveHundredSnickers.LOGGER.info("It can repair");
            return true;
        }
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
