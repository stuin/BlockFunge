package com.stuintech.blockfunge.block;

import com.stuintech.blockfunge.BlockFunge;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.PISTON);
    public static Item.Settings itemSettings = new Item.Settings().group(ItemGroup.REDSTONE);

    //Blocks
    public static Block starter = new StartBlock(blockSettings.build());
    public static Block arrow = new ArrowBlock(blockSettings.build());
    public static Block number = new NumberBlock(blockSettings.build());
    public static Block end = new Block(blockSettings.build());
    
    public static void register() {
        //Register blocks
        Registry.register(Registry.BLOCK, BlockFunge.MODID + ":starter", starter);
        Registry.register(Registry.BLOCK, BlockFunge.MODID + ":arrow", arrow);
        Registry.register(Registry.BLOCK, BlockFunge.MODID + ":number", number);
        Registry.register(Registry.BLOCK, BlockFunge.MODID + ":end", end);

        //Register block items
        Registry.register(Registry.ITEM, BlockFunge.MODID + ":starter", new BlockItem(starter, itemSettings));
        Registry.register(Registry.ITEM, BlockFunge.MODID + ":arrow", new BlockItem(arrow, itemSettings));
        Registry.register(Registry.ITEM, BlockFunge.MODID + ":number", new BlockItem(number, itemSettings));
        Registry.register(Registry.ITEM, BlockFunge.MODID + ":end", new BlockItem(end, itemSettings));
    }
}
