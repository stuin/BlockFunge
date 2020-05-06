package com.stuintech.blockfunge.interpreter;

import com.stuintech.blockfunge.interpreter.functions.Movement;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.RedstoneWireBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FunctionList {
    public static Map<String, Consumer<Pointer>> functionMap = new HashMap<String, Consumer<Pointer>>() {{
        //Movement
        put("block.minecraft.stone_button", (p) -> p.setDirection(p.getBlock().get(FacingBlock.FACING)));
        put("block.minecraft.lever", Movement::lever);
        put("block.minecraft.slime_block", Pointer::jump);
        put("block.minecraft.iron_door", Movement::pauseDoor);
        put("block.minecraft.iron_trapdoor", Movement::pauseTrapdoor);

        //Speed control
        put("block.minecraft.cobweb", (p) -> p.setSpeed(1));
        put("block.minecraft.soul_sand", (p) -> p.setSpeed(2));
        put("block.minecraft.grass_path", (p) -> p.setSpeed(3));
        put("block.minecraft.ice", (p) -> p.setSpeed(4));
        put("block.minecraft.packed_ice", (p) -> p.setSpeed(5));
        put("block.minecraft.blue_ice", (p) -> p.setSpeed(6));
        
        //Math
        put("block.minecraft.redstone_wire", (p) -> p.push(p.getBlock().get(RedstoneWireBlock.POWER)));
        
        //Stack management
        put("block.minecraft.netherack", Pointer::pop);
        put("block.minecraft.nether_brick", (p) -> p.getStack().clear());
        put("block.minecraft.end_stone", Pointer::stop);
    }};
}
