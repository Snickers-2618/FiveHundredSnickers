package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FiveHundredSnickers.MOD_ID);

    public static final RegistryObject<Item> REPAIR_TALISMAN = ITEMS.register("repair_talisman", () -> new RepairTalisman(new Item.Properties()));
    public static final RegistryObject<Item> CIGARETTE = ITEMS.register("cigarette", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()
            .saturationMod(0.5F)
            .nutrition(1)
            .build())).stacksTo(16)));
    public static final RegistryObject<Item> BBC = ITEMS.register("bbc", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()
            .saturationMod(1.5F)
            .nutrition(5)
            .build())).stacksTo(1)));
    public static final RegistryObject<RepairTalisman> STOGIE = ITEMS.register("stogie", () -> new RepairTalisman(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
