package com.henrybaber.tutorialmod.blocks.custom;

import com.henrybaber.tutorialmod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult)
    {

        pLevel.playSound(pPlayer, pPos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity)
    {
        if(pEntity instanceof ItemEntity itemEntity)
        {
            if(itemEntity.getItem().getItem() == ModItems.RAW_SAPPHIRE.get()) {
                itemEntity.setItem(new ItemStack(ModItems.SAPPHIRE.get()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
