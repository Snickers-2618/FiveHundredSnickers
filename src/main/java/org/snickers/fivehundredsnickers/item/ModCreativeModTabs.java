package org.snickers.fivehundredsnickers.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FiveHundredSnickers.MOD_ID);
    public static final RegistryObject<CreativeModeTab> FHS = CREATIVE_TABS.register("fivehundredsnickers_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.BBC.get()))
            .title(Component.translatable("creativetab.fivehundredsnickers"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModBlocks.LAVAWOOD.get());
                pOutput.accept(ModBlocks.PACKED_STONE.get());
                pOutput.accept(ModItems.CIGARETTE.get());
                pOutput.accept(ModItems.BBC.get());
                pOutput.accept(ModItems.REPAIR_TALISMAN.get());
            })
            .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
