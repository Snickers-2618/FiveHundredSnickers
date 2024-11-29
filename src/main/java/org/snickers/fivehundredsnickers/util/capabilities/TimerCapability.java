package org.snickers.fivehundredsnickers.util.capabilities;

import org.snickers.fivehundredsnickers.util.InternalTimer;

public class TimerCapability implements ITimerCapability {
    private InternalTimer timer;

    @Override
    public TimerCapability setTimer(InternalTimer t) {
        this.timer = t;
        return null;
    }

    @Override
    public InternalTimer getTimer() {
        return this.timer;
    }
}
