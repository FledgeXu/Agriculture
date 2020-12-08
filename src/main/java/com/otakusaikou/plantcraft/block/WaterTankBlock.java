package com.otakusaikou.plantcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;

public class WaterTankBlock extends Block {
    //We don't care about UP
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    public WaterTankBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState()
                .with(DOWN, Boolean.valueOf(false))
                .with(NORTH, Boolean.valueOf(false))
                .with(EAST, Boolean.valueOf(false))
                .with(SOUTH, Boolean.valueOf(false))
                .with(WEST, Boolean.valueOf(false)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DOWN, NORTH, EAST, WEST, SOUTH);
        super.fillStateContainer(builder);
    }
}
