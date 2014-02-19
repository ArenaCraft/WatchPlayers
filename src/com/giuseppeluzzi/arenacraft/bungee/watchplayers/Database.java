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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.cubespace.Yamler.Config.Config;

public class Database extends Config{
	
	public List<String> players = new ArrayList<String>();

	public Database(Main plugin) {
		CONFIG_HEADER = new String[]{"Utenti con /watch"};
		CONFIG_FILE = new File(plugin.getDataFolder(), "users.yml");
	}
}
