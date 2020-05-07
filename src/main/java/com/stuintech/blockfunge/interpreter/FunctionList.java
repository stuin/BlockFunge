package com.stuintech.blockfunge.interpreter;

import com.stuintech.blockfunge.block.NumberBlock;
import com.stuintech.blockfunge.interpreter.functions.Arithmatic;
import com.stuintech.blockfunge.interpreter.functions.Movement;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.RedstoneWireBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/*
 * Created by Stuart Irwin on 5/6/2020.
 */

public class FunctionList {
    public static Map<String, Consumer<Pointer>> functionMap = new HashMap<String, Consumer<Pointer>>() {{
        //Movement
        put("block.minecraft.stone_button", (p) -> p.setDirection(p.getBlock().get(FacingBlock.FACING)));
        put("block.minecraft.lever", Movement::lever);
        put("block.minecraft.slime_block", Pointer::jump);
        put("block.minecraft.iron_door", Movement::pauseDoor);
        put("block.minecraft.iron_trapdoor", Movement::pauseTrapdoor);
        put("block.minecraft.cobweb", Pointer::pause);
        put("block.minecraft.glass", Pointer::toggleVisibility);

        //Speed control
        put("block.minecraft.soul_sand", (p) -> p.setSpeed(240));
        put("block.minecraft.grass_path", (p) -> p.setSpeed(120));
        put("block.minecraft.ice", (p) -> p.setSpeed(60));
        put("block.minecraft.packed_ice", (p) -> p.setSpeed(20));
        put("block.minecraft.blue_ice", (p) -> p.setSpeed(1));
        
        //Math
        put("block.minecraft.redstone_wire", (p) -> p.push(p.getBlock().get(RedstoneWireBlock.POWER)));
        put("block.minecraft.redstone_repeater", (p) -> p.push(Arithmatic.operator(p)));
        put("block.minecraft.redstone_torch", Arithmatic::modulus);
        
        //Stack management
        put("block.minecraft.netherack", Pointer::pop);
        put("block.minecraft.nether_brick", (p) -> p.getStack().clear());
        put("block.minecraft.end_stone", Pointer::stop);
        
        //Custom Blocks
        put("block.blockfunge.arrow", (p) -> p.setDirection(p.getBlock().get(FacingBlock.FACING)));
        put("block.blockfunge.number", (p) -> p.push(p.getBlock().get(NumberBlock.POWER)));
        put("block.blockfunge.end", Pointer::stop);
    }};
}
