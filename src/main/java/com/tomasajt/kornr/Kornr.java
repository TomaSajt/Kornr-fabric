package com.tomasajt.kornr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class Kornr implements ModInitializer {
	public static final String MOD_ID = "kornr";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Kornr Loaded!");
	}
}
