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

import net.cubespace.Yamler.Config.InvalidConfigurationException;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WatchReload extends Command {
	
	public Main plugin = null;
	
	public WatchReload(Main main) {
		super("watchreload");
		this.plugin = main;
	}

	@Override
	public void execute(CommandSender arg0, String[] arg1) {
		if(!(arg0 instanceof ProxiedPlayer))
		{
			plugin.dbConfig.players.clear();
			 try {
				plugin.dbConfig.load();
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			
		}
	};
	
}
