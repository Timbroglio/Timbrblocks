package net.akliz.timbrmod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;


public class LitPlateBlock extends Block {
    public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 7);
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public LitPlateBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, 0).setValue(POWERED, Boolean.FALSE));
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            int newColor = pState.cycle(COLOR).getValue(COLOR);
            pState = pState.setValue(COLOR, newColor);
            pLevel.setBlock(pPos, pState, 3);
        }
        return InteractionResult.SUCCESS;
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        boolean flag = pLevel.hasNeighborSignal(pPos);
        if (flag != pState.getValue(POWERED)) {
            if (flag) {
                int newColor = pState.cycle(COLOR).getValue(COLOR);
                pState = pState.setValue(COLOR, newColor).setValue(POWERED, true);
                pLevel.setBlock(pPos, pState, 3);
            }

            pLevel.setBlock(pPos, pState.setValue(POWERED, flag), 3);
        }

    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(COLOR).add(POWERED);
    }


}
