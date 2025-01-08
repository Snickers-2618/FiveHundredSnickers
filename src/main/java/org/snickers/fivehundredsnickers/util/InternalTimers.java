package org.snickers.fivehundredsnickers.util;

import net.minecraftforge.fml.common.Mod;
import org.snickers.fivehundredsnickers.SnickersConfig;

@Mod.EventBusSubscriber
public class InternalTimers {
    static private final Timer repair = new Timer();

    public static void activateRepair() {
        repair.shouldUpdate = SnickersConfig.REPAIR_RATE != -1;
    }

    public static boolean canRepair() {
        if (repair.tickCount == 0) {
            repair.tickCount = SnickersConfig.REPAIR_RATE;
//            repair.shouldUpdate = false;
            return true;
        }
//        repair.tick();
        return false;
    }

    public static void tick() {
        repair.tick();
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
                shouldUpdate = false;
            }
        }
    }
}
