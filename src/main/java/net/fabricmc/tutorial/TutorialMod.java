package net.fabricmc.tutorial;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.tutorial.block.ModBlocks;
import net.fabricmc.tutorial.item.ModItems;

public class TutorialMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("tutorial");

	public static final String MOD_ID = "hellish";

	@Override
	public void onInitialize() {
		ModItems.RegisterItems();
		ModBlocks.registerBlocks();
	}
}
