package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemHelper {
    public static boolean isRepairableDamagedItem(ItemStack stack) {
        return stack.isDamageableItem() && stack.isRepairable() && stack.getDamageValue() > 0;
    }

    public int getFirstItem(Player player, Item item) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack s = player.getInventory().getItem(i);
            if (s.is(item)) {
                return i;
            }
        }
        return -1;
    }
}
