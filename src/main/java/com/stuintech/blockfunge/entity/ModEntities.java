package com.stuintech.blockfunge.entity;

import com.stuintech.blockfunge.BlockFunge;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/*
 * Created by Stuart Irwin on 5/6/2020.
 */

public class ModEntities {
    public static EntityType<PointerEntity> pointerEntity;
    
    public static void register() {
        Identifier id = new Identifier(BlockFunge.MODID, "pointer_entity");
        pointerEntity = Registry.register(Registry.ENTITY_TYPE,
                id,
                FabricEntityTypeBuilder.create(EntityCategory.MISC,
                        (EntityType.EntityFactory<PointerEntity>)PointerEntity::new)
                        .size(EntityDimensions.fixed(1.0F, 1.0F)).setImmuneToFire().build());
    }
    
    public static void clientRegister() {
        EntityRendererRegistry.INSTANCE.register(pointerEntity,
                (entityRenderDispatcher, context) -> new PointerRenderer(entityRenderDispatcher));
    }
}
