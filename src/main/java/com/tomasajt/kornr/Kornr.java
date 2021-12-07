package com.tomasajt.kornr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public class Kornr implements ModInitializer {
	public static final String MOD_ID = "kornr";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> 
        {
            BlockState state = world.getBlockState(pos);
            /* Manual spectator check is necessary because AttackBlockCallbacks
               fire before the spectator check */
            if (state.isToolRequired() && !player.isSpectator() && 
                player.getMainHandStack().isEmpty()) 
            {
                player.damage(DamageSource.GENERIC, 1.0F);
            } 
            return ActionResult.PASS;
        });
	}
}
