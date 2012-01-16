package com.oei.chatng;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import org.bukkit.entity.Player;

public class Channel {
	private HashMap<String, Player> members;
	private HashMap<String, Player> moderators;
	private String name;
	
	public Channel(String name){
		this.name = name;
		initMaps();
	}
	public void addPlayerToChannel(Player player){
		this.members.put(player.getName(), player);
	}
	private void initMaps(){
		this.members = new HashMap();
		this.moderators = new HashMap();
	}
	private void sendToAll(String message){
		Iterator i = members.values().iterator();
		while(i.hasNext()){
		}
	}
}
