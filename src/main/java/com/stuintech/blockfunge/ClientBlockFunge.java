package com.stuintech.blockfunge;

import com.stuintech.blockfunge.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;

public class ClientBlockFunge implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntities.clientRegister();
    }
}
