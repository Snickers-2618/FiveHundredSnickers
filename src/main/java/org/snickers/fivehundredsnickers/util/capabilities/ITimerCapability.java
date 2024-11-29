package org.snickers.fivehundredsnickers.util.capabilities;

import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import org.snickers.fivehundredsnickers.util.InternalTimer;

@AutoRegisterCapability
public interface ITimerCapability {
    TimerCapability setTimer(InternalTimer t);
    InternalTimer getTimer();
}
