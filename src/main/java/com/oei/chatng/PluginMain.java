package com.oei.chatng;

import java.util.logging.Logger;

import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin {
	private Logger log = Logger.getLogger("[ChatNG]");

	public void onDisable() {
		log.info(getDescription().getFullName() + " Disabled.");
	}

	public void onEnable() {
		log.info(getDescription().getFullName() + " Initialized.");
	}
}
