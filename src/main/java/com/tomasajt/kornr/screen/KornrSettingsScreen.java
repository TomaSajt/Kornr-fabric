package com.tomasajt.kornr.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.math.Quaternion;

public class KornrSettingsScreen extends Screen {

    int ticks = 0;
    public KornrSettingsScreen() {
        super(new LiteralText("Kornr Settings"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        var mc = MinecraftClient.getInstance();
        var textRenderer = mc.textRenderer;
        matrices.push();
        var text = new LiteralText("Kornr");
        float offset = (float) (textRenderer.getWidth(text) / 2);
        matrices.translate(this.width / 2, this.height / 2, 0);
        matrices.scale(3, 3, 3);
        matrices.translate(0, 0, offset);
        matrices.multiply(new Quaternion((ticks + delta) * 9, (ticks + delta) * 5, 0, true));
        drawTextCenteredTwoSided(textRenderer, text, matrices, 0, 0, 0xff0000);
        matrices.pop();
    }
    @Override
    public void tick() {
        ticks++;
    }

    public void drawTextCenteredTwoSided(TextRenderer textRenderer, Text text, MatrixStack matrices,
            float x, float y, int color) {
        drawTextCentered(textRenderer, text, matrices, x, y, color);
        matrices.multiply(new Quaternion(0, 180, 0, true));
        drawTextCentered(textRenderer, text, matrices, x, y, color);

    }

    public void drawTextCentered(TextRenderer fontRenderer, Text text, MatrixStack matrices,
            float x, float y, int color) {
        float offset = (float) (-fontRenderer.getWidth(text) / 2);
        matrices.translate(offset, -4.5, 0);
        fontRenderer.draw(matrices, text.getString(), 0, 0, color);
        matrices.translate(-offset, 4.5, 0);
    }

}
