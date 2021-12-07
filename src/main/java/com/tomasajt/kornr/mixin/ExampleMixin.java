package com.tomasajt.kornr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;

@Mixin(Screen.class)
public class ExampleMixin {

	@Shadow
	protected MinecraftClient client;

	@Overwrite
	public void sendMessage(String message, boolean inHud) {
		if (inHud) {
			this.client.inGameHud.getChatHud().addToMessageHistory(message);
		}
		if (message.startsWith("#")) {
			var command = message.substring(1);
			this.client.inGameHud.getChatHud().addMessage(new LiteralText("You tried to run the following command: " + command));
		} else {
			this.client.player.sendChatMessage(message);
		}

	}
}
