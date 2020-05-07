package com.stuintech.blockfunge;

import com.stuintech.blockfunge.block.ModBlocks;
import com.stuintech.blockfunge.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Created by Stuart Irwin on 5/6/2020.
 */

public class BlockFunge implements ModInitializer, ClientModInitializer {
	public static final String MODID = "blockfunge";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		//Register mod resources
		ModEntities.register();
		ModBlocks.register();
	}

	@Override
	public void onInitializeClient() {
		LOGGER.debug("Client setup");
		ModEntities.clientRegister();
	}

}
