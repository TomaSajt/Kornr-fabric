package com.tomasajt.kornr;

import com.tomasajt.kornr.screen.KornrSettingsScreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class Kornr implements ModInitializer {
	public static final String MOD_ID = "kornr";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static boolean shouldOpenMenu = false;

	@Override
	public void onInitialize() {
		LOGGER.info("Kornr Loaded!");
		ClientTickEvents.START_CLIENT_TICK.register(client -> {
			if (shouldOpenMenu) {
				shouldOpenMenu = false;
				client.setScreen(new KornrSettingsScreen());
			}
		});
	}
}
