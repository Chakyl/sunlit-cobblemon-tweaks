package io.github.chakyl.sunlitcobblemon.block;


import io.github.chakyl.sunlitcobblemon.blockentity.MonBoxBlockEntity;
import io.github.chakyl.sunlitcobblemon.registry.SunlitCobblemonRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
public class MonBoxBlock extends Block implements EntityBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public MonBoxBlock(Properties props) {
        super(props);
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, Direction.UP).setValue(FACING, pContext.getNearestLookingDirection().getOpposite()).setValue(OPEN, false);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MonBoxBlockEntity(pPos, pState);
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (pHand == InteractionHand.MAIN_HAND && entity instanceof MonBoxBlockEntity) {
                MonBoxBlockEntity spawnerEntity = (MonBoxBlockEntity) entity;
                ItemStack heldItem = pPlayer.getItemInHand(pHand);
                if (pPlayer.isCreative() && heldItem.getItem() == Items.REDSTONE) {
                    pLevel.playSound(pPlayer, pPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    spawnerEntity.setPokemonCount(spawnerEntity.getPokemonCount() + 1);
                    return InteractionResult.SUCCESS;
                }
                if (pPlayer.isCreative() && heldItem.getItem() == Items.GLOWSTONE_DUST) {
                    int currentCount = spawnerEntity.getPokemonCount();
                    pLevel.playSound(pPlayer, pPos, SoundEvents.GLOW_INK_SAC_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (currentCount > 1) {
                        spawnerEntity.setPokemonCount(currentCount - 1);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
            return InteractionResult.FAIL;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, SunlitCobblemonRegistry.BlockEntityRegistry.MON_BOX.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker) {
        return (BlockEntityTicker<A>) ticker;
    }

}