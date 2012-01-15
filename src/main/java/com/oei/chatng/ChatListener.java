package com.oei.chatng;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class ChatListener extends PlayerListener {
	private Economy economy;
	private Permission permission;
	private Logger log;
	private FileConfiguration config;
	
	public ChatListener(Economy economy, Permission permission, Logger log, FileConfiguration config){
		this.economy = economy;
		this.permission = permission;
		this.log = log;
		this.config = config;
	}
	public void onPlayerChat(PlayerChatEvent ev){
		log.info(ev.getPlayer().getName()+": "+ev.getMessage());
		ev.setCancelled(true);
	}

}
