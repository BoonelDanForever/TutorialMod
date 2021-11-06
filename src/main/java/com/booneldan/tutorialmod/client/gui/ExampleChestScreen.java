package com.booneldan.tutorialmod.client.gui;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.container.ExampleChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(TutorialMod.MOD_ID, "textures/gui:example_chest.png");

    public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 183;
    }



    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack p_230451_1_, int p_230451_2_, int p_230451_3_) {
        super.renderLabels(p_230451_1_, p_230451_2_, p_230451_3_);
        this.font.draw(p_230451_1_, this.title.getContents(), 8.0f, 6.0f, 4210752);
        this.font.draw(p_230451_1_, this.inventory.getDisplayName().getContents(), 8.0f, 90.0f, 4210752);
    }

    @Override
    protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(p_230450_1_, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }


}
