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

import java.util.ArrayList;
import java.util.List;

import net.cubespace.Yamler.Config.InvalidConfigurationException;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
	
	public Database dbConfig = null;
	public List<String> watched = new ArrayList<String>();
	
	public void onEnable()
	{
		 ProxyServer.getInstance().getPluginManager().registerCommand(this, new Watch(this));
		 ProxyServer.getInstance().getPluginManager().registerCommand(this, new WatchReload(this));
		 ProxyServer.getInstance().getPluginManager().registerListener(this, new Listeners(this));
		 
		 try {
			dbConfig = new Database(this);
			dbConfig.init();
		 } catch (InvalidConfigurationException e) {
			e.printStackTrace();
		 }
	}
	
}
