package com.henrybaber.tutorialmod.items;

import com.henrybaber.tutorialmod.TutorialMod;
import com.henrybaber.tutorialmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SAPPHIRE_ITEMS_TAB = CREATIVE_MODE_TABS.register("sapphire_items_tab",
            () -> CreativeModeTab.builder().icon(
                    () -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.items_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> SAPPHIRE_BLOCKS_TAB= CREATIVE_MODE_TABS.register("sapphire_blocks_tab",
            () -> CreativeModeTab.builder().icon(
                            () -> new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get()))
                    .title(Component.translatable("creativetab.blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.MAGIC_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
