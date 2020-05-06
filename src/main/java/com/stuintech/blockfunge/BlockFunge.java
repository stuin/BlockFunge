package com.stuintech.blockfunge;

import com.stuintech.sonicdevices.block.ModBlocks;
import com.stuintech.sonicdevices.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Created by Stuart Irwin on 4/4/2019.
 */

public class BlockFunge implements ModInitializer {
	public static final String MODID = "blockfunge";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		//Register mod resources
		ModItems.register();
		ModSounds.register();
		ModBlocks.register();
	}
}
