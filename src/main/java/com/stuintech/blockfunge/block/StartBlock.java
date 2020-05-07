package com.stuintech.blockfunge.block;

import com.stuintech.blockfunge.entity.PointerEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class StartBlock extends ArrowBlock {
    public static final BooleanProperty TRIGGERED;

    public StartBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TRIGGERED, false).with(FACING, Direction.SOUTH));

    }
    
    public void start(BlockState state, World world, BlockPos pos) {
        world.spawnEntity(new PointerEntity(world, pos, state.get(FACING)));
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        start(state, world, pos);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos neighborPos, boolean moved) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.up());
        boolean bl2 = state.get(TRIGGERED);
        if (bl && !bl2) {
            world.getBlockTickScheduler().schedule(pos, this, this.getTickRate(world));
            world.setBlockState(pos, state.with(TRIGGERED, true), 4);
        } else if (!bl && bl2) {
            world.setBlockState(pos, state.with(TRIGGERED, false), 4);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TRIGGERED);
    }
    static {
        TRIGGERED = Properties.TRIGGERED;
    }

}
