package com.stuintech.blockfunge.entity;

import com.stuintech.blockfunge.interpreter.Pointer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnGlobalS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Stack;

public class PointerEntity extends Entity implements Pointer {
    private static final int RANGE = 32;
    private Stack<Integer> stack = new Stack<>();
    private int speed = 120;

    public PointerEntity(EntityType<Entity> entityType, World world) {
        super(entityType, world);
        noClip = true;
        glowing = true;
    }

    public PointerEntity(World world) {
        this(ModEntities.pointerEntity, world);
    }
    
    public PointerEntity(World world, BlockPos pos, Direction direction) {
        this(ModEntities.pointerEntity, world);
        setDirection(direction);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public BlockState getBlock() {
        return world.getBlockState(getBlockPos());
    }

    @Override
    public String getIdentifier() {
        return Registry.BLOCK.getId(getBlock().getBlock()).getPath();
    }

    @Override
    public BlockPos getPosition() {
        return getBlockPos();
    }

    @Override
    public Direction getDirection() {
        Vec3d v = getRotationVector();
        return Direction.fromVector((int)v.x, (int)v.y, (int)v.z);
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setBlock(BlockState state) {
        world.setBlockState(getBlockPos(), state);
    }

    @Override
    public void setDirection(Direction dir) {
        setRotation(getPitch(1.0F), getYaw(1.0F));
    }

    @Override
    public void setSpeed(int value) {
        speed = value;
    }

    @Override
    public void jump() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {
        kill();
    }

    @Override
    public void toggleVisibility() {
        glowing = !glowing;
    }

    @Override
    public Stack<Integer> getStack() {
        return stack;
    }

    @Override
    public int pop() {
        return stack.pop();
    }

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public BlockPos popPos() {
        int z = pop();
        int y = pop();
        int x = pop();
        return new BlockPos(x, y, z);
    }

    @Override
    public boolean inRange(BlockPos pos) {
        return pos.isWithinDistance(pos, RANGE);
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag tag) {
        int[] array = tag.getIntArray("stack");
        for(int i : array)
            stack.push(i);
        speed = tag.getInt("speed");
    }

    @Override
    protected void writeCustomDataToTag(CompoundTag tag) {
        tag.putIntArray("stack", stack);
        tag.putInt("speed", speed);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnGlobalS2CPacket(this);
    }
}
