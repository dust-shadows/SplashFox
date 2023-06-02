package com.lx.splashfox.screen.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SelectFoxButton extends TexturedButtonWidget {
    private final boolean selected;
    private int baseY;
    private static final int PADDING = 2;
    public SelectFoxButton(int x, int y, int width, int height, int u, int v, boolean selected, Identifier texture, int textureWidth, int textureHeight, PressAction pressAction, Text message) {
        super(x, y, width, height, u, v, 0, texture, textureWidth, textureHeight, pressAction, message);
        this.baseY = y;
        this.selected = selected;
    }

    @Override
    public void renderButton(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        if(selected) {
            // Blue highlight background
            RenderSystem.setShaderColor(0.2f, 0.6f, 0.9f, 1);
            drawContext.fill(getX() - PADDING, getY() - PADDING, getX() + width + PADDING, getY() + height + PADDING, 0xFFFFFFFF);
            RenderSystem.setShaderColor(1, 1, 1, 1);
        } else if (this.isHovered()) {
            // White highlight background
            RenderSystem.setShaderColor(1, 1, 1, 0.5f);
            drawContext.fill(getX() - PADDING, getY() - PADDING, getX() + width + PADDING, getY() + height + PADDING, 0xFFFFFFFF);
            RenderSystem.setShaderColor(1, 1, 1, 1);
        }
        super.renderButton(drawContext, mouseX, mouseY, delta);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        this.baseY = y;
    }

    public void setYOffset(int offset) {
        super.setY(baseY + offset);
    }
}