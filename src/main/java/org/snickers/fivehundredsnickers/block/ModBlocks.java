package org.snickers.fivehundredsnickers.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import org.snickers.fivehundredsnickers.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FiveHundredSnickers.MOD_ID);

    public static final RegistryObject<Block> LAVAWOOD = registerBlock("lavawood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)
            .sound(SoundType.WOOD)
            .strength(2F, 3F)
            .requiresCorrectToolForDrops()));
//    public static final RegistryObject<Block> PACKED_STONE = registerBlock("packed_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> RED_PHOSPHOR_LANTERN = registerBlock("red_phosphor_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN)
            .strength(3.5F)));



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
}
