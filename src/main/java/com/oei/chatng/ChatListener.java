package com.oei.chatng;

import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class ChatListener extends PlayerListener {
	private Economy economy;
	private Permission permission;
	private Logger log;
	
	public ChatListener(Permission permission, Economy economy, Logger log) {
		this.permission = permission;
		this.economy = economy;
		this.log = log;
	}
	public ChatListener(Logger log){
		this.economy = null;
		this.permission = null;
		this.log = log;
	}
	public void onPlayerChat(PlayerChatEvent ev){
		log.info(ev.getPlayer().getName()+": "+ev.getMessage());
		ev.setCancelled(true);
	}

}
