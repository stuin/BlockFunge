package com.stuintech.blockfunge.interpreter.functions;

import com.stuintech.blockfunge.interpreter.Pointer;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.Map;

public class Movement {
    public static void lever(Pointer p) {
        Direction dir;
        boolean on = p.pop() != 0;
        
        //Get lever direction
        if(p.getBlock().get(LeverBlock.FACE) == WallMountLocation.WALL) {
            dir = on ? Direction.DOWN : Direction.UP;
        } else {
           dir = p.getBlock().get(LeverBlock.FACING);
           if(on)
               dir = dir.getOpposite();
        }
        p.setDirection(dir);

        //Set lever state
        if(p.getBlock().get(LeverBlock.POWERED) != on)
            p.setBlock(p.getBlock().with(LeverBlock.POWERED, on));
    }
    
    public static void pauseDoor(Pointer p) {

    }

    public static void pauseTrapdoor(Pointer p) {

    }
}
