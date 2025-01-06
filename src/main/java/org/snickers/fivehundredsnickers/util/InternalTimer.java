package org.snickers.fivehundredsnickers.util;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import org.snickers.fivehundredsnickers.SnickersConfig;

public class InternalTimer {
    public static final Capability<InternalTimer> CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    private final InternalTimer.Timer repair = new InternalTimer.Timer();


    public int getTick() {
        return repair.tickCount;
    }

    public void activateRepair() {
        repair.shouldUpdate = SnickersConfig.REPAIR_RATE != -1;
    }

    public boolean canRepair() {
        if (repair.tickCount == 0) {
            repair.tickCount = SnickersConfig.REPAIR_RATE;
            repair.shouldUpdate = false;
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
