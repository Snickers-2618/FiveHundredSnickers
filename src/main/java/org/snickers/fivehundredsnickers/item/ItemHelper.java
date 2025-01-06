package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemHelper {
    public static boolean isRepairableDamagedItem(ItemStack stack) {
        return stack.isDamageableItem() && stack.isRepairable() && stack.getDamageValue() > 0;
    }

    public static int getFirstStack(Player player, Item item) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack s = player.getInventory().getItem(i);
            if (s.is(item)) {
                return i;
            }
        }
        return -1;
    }

    public static int getStackPos(Player player, ItemStack stack) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack s = player.getInventory().getItem(i);
            if (s == stack) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isFirstItem(Player player, ItemStack stack) {
        return getFirstStack(player, stack.getItem()) == getStackPos(player, stack);
    }
}
