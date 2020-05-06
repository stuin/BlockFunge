package com.stuintech.blockfunge.interpreter;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

import java.util.Stack;

public interface Pointer {
    //World access
    BlockState getBlock();
    String getIdentifier();
    Position getPos();
    Direction getDirection();
    World getWorld();
    
    //World interaction
    void setBlock(BlockState state);
    void setDirection(Direction dir);
    void setSpeed(int value);

    //Unique actions
    void jump();
    void pause();
    void stop();
    
    //Stack interaction
    Stack<Integer> getStack();
    int pop();
    void push(int value);
    BlockPos popPos();
    boolean inRange(BlockPos pos);
}
