package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;

import java.beans.FeatureDescriptor;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FiveHundredSnickers.MOD_ID);

    public static final RegistryObject<Item> CIGARETTE = ITEMS.register("cigarette", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()
            .saturationMod(0.5F)
            .nutrition(1)
            .build())).stacksTo(16)));
    public static final RegistryObject<Item> BBC = ITEMS.register("bbc", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()
            .saturationMod(1.5F)
            .nutrition(5)
            .build())).stacksTo(1)));
    public static final RegistryObject<RepairTalisman> STOGIE = ITEMS.register("stogie", () -> new Stogie(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RED_PHOSPHOR = ITEMS.register("red_phosphor", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_PHOSPHOR_BOTTLE = ITEMS.register("blue_phosphor_bottle", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
