package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.item.ItemStack;

public class ItemHelper {
    public static boolean isRepairableDamagedItem(ItemStack stack) {
        return stack.isDamageableItem() && stack.isRepairable() && stack.getDamageValue() > 0;
    }
}
