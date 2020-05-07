package com.stuintech.blockfunge.entity;

import com.stuintech.blockfunge.BlockFunge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static EntityType<Entity> pointerEntity;
    
    public static void register() {
        pointerEntity = Registry.register(Registry.ENTITY_TYPE,
                new Identifier(BlockFunge.MODID, "pointer_entity"),
                EntityType.Builder.create(PointerEntity::new, EntityCategory.MISC)
                        .makeFireImmune().setDimensions(1.0F, 1.0F).build(null));
    }
}
