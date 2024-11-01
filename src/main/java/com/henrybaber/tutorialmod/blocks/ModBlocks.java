package com.henrybaber.tutorialmod.blocks;

import com.henrybaber.tutorialmod.TutorialMod;
import com.henrybaber.tutorialmod.blocks.custom.MagicBlock;
import com.henrybaber.tutorialmod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // Sapphire Block
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    // Raw Sapphire Block
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    // Sapphire Ore
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops()));

    // Raw Sapphire Block
    public static final RegistryObject<Block> SAPPHIRE_DEEPSLATE_ORE = registerBlock("sapphire_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                    .strength(0.75f).requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new  Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
