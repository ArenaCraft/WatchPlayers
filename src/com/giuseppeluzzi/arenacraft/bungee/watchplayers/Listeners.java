/*  WatchPlayers
    Copyright (C) 2014  Giuseppe Luzzi aka xPeppe

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.*/
package com.giuseppeluzzi.arenacraft.bungee.watchplayers;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Listeners implements Listener{
	
private Main plugin;
	
	public Listeners(Main main)
	{
		this.plugin = main;
	}
	
	@EventHandler
	public void onNetworkQuit(PlayerDisconnectEvent e)
	{
		if(plugin.watched.contains(e.getPlayer().getName()))
		{
			for(ProxiedPlayer p: ProxyServer.getInstance().getPlayers())
			{
				if(plugin.dbConfig.players.contains(p.getName()))
				{
					p.sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.YELLOW+"!"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+" "+e.getPlayer().getName()+" è uscito dal server!"));
				}
			}
			plugin.watched.remove(e.getPlayer().getName());
		}
	}
	
	
	
	@EventHandler
	public void onServerChange(ServerDisconnectEvent e)
	{
		if(plugin.watched.contains(e.getPlayer().getName()))
		{
			if(ProxyServer.getInstance().getPlayer(e.getPlayer().getName()) != null)
			{
				for(ProxiedPlayer p: ProxyServer.getInstance().getPlayers())
				{
					if(plugin.dbConfig.players.contains(p.getName()))
					{
						p.sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.YELLOW+"!"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+""+e.getPlayer().getName()+" è andato in "+e.getPlayer().getServer().getInfo().getName()+"!"));
					}
				}
				ProxyServer.getInstance().getConsole().sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.YELLOW+"!"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+""+e.getPlayer().getName()+" è andato in "+e.getPlayer().getServer().getInfo().getName()+"!"));
			}
		}
	}
}
