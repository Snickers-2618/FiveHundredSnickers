package org.snickers.fivehundredsnickers.util.capabilities;

import org.snickers.fivehundredsnickers.util.InternalTimer;

public class TimerCapability implements ITimerCapability {
    private InternalTimer timer;

    @Override
    public void setTimer(InternalTimer t) {
        this.timer = t;
    }

    @Override
    public InternalTimer getTimer() {
        return this.timer;
    }
}
