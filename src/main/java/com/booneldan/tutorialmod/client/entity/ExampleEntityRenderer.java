package com.booneldan.tutorialmod.client.entity;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.client.entity.model.ExampleEntityModel;
import com.booneldan.tutorialmod.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/example/example.png");

    public ExampleEntityRenderer(EntityRendererManager manager) {
        super(manager, new ExampleEntityModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity p_110775_1_) {
        return TEXTURE;
    }
}
