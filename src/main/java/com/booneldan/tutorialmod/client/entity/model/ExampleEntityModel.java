package com.booneldan.tutorialmod.client.entity.model;

import com.booneldan.tutorialmod.entity.ExampleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class ExampleEntityModel<T extends ExampleEntity> extends EntityModel<T> {
    private final ModelRenderer bb_main;

    public ExampleEntityModel() {
        texWidth = 64;
        texHeight = 64;

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);
        bb_main.texOffs(0, 0).addBox(-7.0F, -15.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(ExampleEntity entity, float limbSwing, float limgSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}