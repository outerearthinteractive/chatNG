package com.oei.chatng;

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
		log.info(getDescription().getFullName() + " Disabled.");
	}

	public void onEnable() {
		log.info(getDescription().getFullName() + " Initializing.");
		
		if(this.setupPermissions() && this.setupEconomy()){
			log.info("Hooked into economy and permissions plugins");
			log.info("Permissions: "+permission.getName());
			log.info("Economy: "+economy.getName());
			listener = new ChatListener(permission, economy, log);
		} else {
			log.info("Could not hook into Economy and Permissions.");
			listener = new ChatListener(log);
		}
		pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_CHAT, listener, Event.Priority.Lowest, this);
		
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
    	try{
    		config = getConfig();
    	} catch (Exception e){
    		return false;
    	}
    	return true;
    }
}
