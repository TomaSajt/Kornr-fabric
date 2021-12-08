package com.tomasajt.kornr.mixin;

import com.tomasajt.kornr.Kornr;
import com.tomasajt.kornr.screen.KornrSettingsScreen;

import org.spongepowered.asm.mixin.Mixin;

import baritone.api.BaritoneAPI;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

@Mixin(ChatScreen.class)
public abstract class CommandMixin extends Screen {

	protected CommandMixin(Text title) {
		super(title);
	}

	@Override
	public void sendMessage(String message) {
		var baritone = BaritoneAPI.getProvider().getPrimaryBaritone();
		this.client.inGameHud.getChatHud().addToMessageHistory(message);
		if (message.equalsIgnoreCase("#getRich")) {
			this.client.inGameHud.getChatHud()
					.addMessage(new LiteralText("Getting rich in progress..."));
			baritone.getMineProcess().mine(Blocks.DIAMOND_ORE);

		} else if (message.equalsIgnoreCase("#menu")) {
			Kornr.shouldOpenMenu = true;
		} else {
			this.client.player.sendChatMessage(message);
		}
	}
}
