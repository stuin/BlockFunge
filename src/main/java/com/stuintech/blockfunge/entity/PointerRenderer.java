package com.stuintech.blockfunge.entity;

import com.stuintech.blockfunge.BlockFunge;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/*
 * Created by Stuart Irwin on 5/7/2020.
 */

public class PointerRenderer extends EntityRenderer<PointerEntity> {
    ModelPart head = new ModelPart(64, 64, 0, 52);

    protected PointerRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher);
        this.head.addCuboid(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F);
        this.head.setPivot(0.0F, 12.0F, 0.0F);
    }

    @Override
    public Identifier getTexture(PointerEntity entity) {
        return new Identifier(BlockFunge.MODID + ":textures/entity/pointer.png");
    }

    @Override
    public void render(PointerEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        BlockFunge.LOGGER.debug("Rendering");
        matrixStack.push();
        matrixStack.translate(0.0D, 1.0D, 0.0D);
        matrixStack.scale(-1.0F, -1.0F, 1.0F);

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntitySolid(getTexture(entity)));
        head.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
    }
}
