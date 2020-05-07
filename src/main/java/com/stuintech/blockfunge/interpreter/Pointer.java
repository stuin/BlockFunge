package com.stuintech.blockfunge.interpreter;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Stack;

public interface Pointer {
    //World access
    BlockState getBlock();
    String getIdentifier();
    BlockPos getPosition();
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
    void toggleVisibility();
    
    //Stack interaction
    Stack<Integer> getStack();
    int pop();
    void push(int value);
    BlockPos popPos();
    boolean inRange(BlockPos pos);
}
