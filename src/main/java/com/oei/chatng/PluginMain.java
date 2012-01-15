package com.oei.chatng;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin {
	private Logger log = Logger.getLogger("[ChatNG]");
	private Permission permission;
	private Economy economy;
	private PluginManager pm; 
	private ChatListener listener;
	private FileConfiguration config;

	public void onDisable() {
		pm = null;
		permission = null;
		economy = null;
		listener = null;
		config = null;
		log.info(getDescription().getFullName() + " Disabled.");
	}

	public void onEnable() {
		log.info(getDescription().getFullName() + " Initializing.");
		setupConfig();
		
		boolean permissionsEnabled = config.getBoolean("config.permissions");
		if(config.getBoolean("config.economy")){
			log.info("Hooking into Economy plugin");
			log.info("Economy: "+economy.getName());
		} if(config.getBoolean("config.permissions")) {
			log.info("Hooking into Permissions plugin");
			log.info("Permissions: "+permission.getName());
		}
		ChatListener listener = new ChatListener(economy, permission, log, config);
		pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_CHAT, listener, Event.Priority.Highest, this);
		
	}
    private Boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
    private Boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    private Boolean setupConfig(){
    	log.info("Initializing Config");
    	config = getConfig();
    	config.options().copyDefaults(true);
    	saveConfig();
    	return true;
    }
}
