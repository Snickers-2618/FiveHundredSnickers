package org.snickers.fivehundredsnickers.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.util.InternalTimers;

import java.util.function.Predicate;

@Mod.EventBusSubscriber
public class RepairTalisman extends Item {

    private static final Predicate<ItemStack> CAN_REPAIR_ITEM = stack -> !stack.isEmpty() &&
        ItemHelper.isRepairableDamagedItem(stack);

    public RepairTalisman(Item.Properties prop) {
        super(prop);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level level, @NotNull Entity entity, int invSlot, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            InternalTimers.activateRepair();
            if (InternalTimers.canRepair()) {
                repairAllItems(player);
            }
        }
    }

    private static void repairAllItems(Player player) {
        Predicate<ItemStack> canRepairPlayerItem = CAN_REPAIR_ITEM.and(stack -> stack != player.getMainHandItem() || !player.swinging);
        player.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(inv -> repairAllItems(inv, canRepairPlayerItem));
    }

    private static boolean repairAllItems(IItemHandler inv, Predicate<ItemStack> canRepairStack) {
        boolean hasAction = false;
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack invStack = inv.getStackInSlot(i);
            if (canRepairStack.test(invStack)) {
                invStack.setDamageValue(invStack.getDamageValue() - 1);
                if (!hasAction) {
                    hasAction = true;
                }
            }
        }
        return hasAction;
    }
}
