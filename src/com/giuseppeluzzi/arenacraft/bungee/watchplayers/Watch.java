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
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class Watch extends Command {

	public Main plugin = null;;
	
	public Watch(Main main) {
		super("watch");
		this.plugin = main;
	}

	@Override
	public void execute(CommandSender arg0, String[] args) {
		//plugin.dbConfig.players.add(arg1[0]);
		if(args.length != 1)
		{
			arg0.sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.RED+"#"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+"Utilizzo: /watch [nome]!"));
		}else{
			if(plugin.dbConfig.players.contains(arg0.getName()))
			{
				if(ProxyServer.getInstance().getPlayer(args[0]) != null)
				{
					plugin.watched.add(ProxyServer.getInstance().getPlayer(args[0]).getName());
					arg0.sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.YELLOW+"!"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+ProxyServer.getInstance().getPlayer(args[0])+" aggiunto nella lista osservati!"));
				}else{
					arg0.sendMessage(TextComponent.fromLegacyText(ChatColor.DARK_AQUA+"["+ChatColor.RED+"#"+ChatColor.DARK_AQUA+"] "+ChatColor.GOLD+"Player non trovato!"));
				}
			}
		}
	}

}
