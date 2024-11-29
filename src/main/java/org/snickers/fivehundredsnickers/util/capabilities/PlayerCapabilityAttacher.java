package org.snickers.fivehundredsnickers.util.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.util.InternalTimer;

@Mod.EventBusSubscriber(modid = FiveHundredSnickers.MOD_ID)
public class PlayerCapabilityAttacher {
    private static final ResourceLocation REPAIR_TIMER_ID = new ResourceLocation(FiveHundredSnickers.MOD_ID, "repair_timer");

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(REPAIR_TIMER_ID, new ICapabilityProvider() {
                private final TimerCapability instance = new TimerCapability().setTimer(new InternalTimer());


                @Override
                public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
                    return cap == ModCapabilities.PLAYER_TIMER ? LazyOptional.of(() -> instance).cast() : LazyOptional.empty();
                }
            });
        }
    }

}
