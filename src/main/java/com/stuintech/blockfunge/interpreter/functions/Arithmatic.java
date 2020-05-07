package com.stuintech.blockfunge.interpreter.functions;

import com.stuintech.blockfunge.interpreter.Pointer;
import net.minecraft.block.RepeaterBlock;

public class Arithmatic {
    public static int operator(Pointer p) {
        int a = p.pop();
        int b = p.pop();
        switch(p.getBlock().get(RepeaterBlock.DELAY)) {
            case 1:
                return a + b;
            case 2:
                return a - b;
            case 3:
                return a * b;
            case 4:
                if(b == 0)
                    return 0;
                return a / b;
        }
        return 0;
    }
    
    public static void modulus(Pointer p) {
        int a = p.pop();
        int b = p.pop();
        p.push(a % b);
    }
}
