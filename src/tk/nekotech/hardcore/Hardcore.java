package tk.nekotech.hardcore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.*;

public class Hardcore extends JavaPlugin {
	Listen listen = new Listen(this);
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(listen, this);
	}
		
	public void announceDeath(String dead, String message) {
		   for (final Player player : this.getServer().getOnlinePlayers()) {
			   player.sendMessage(ChatColor.YELLOW + "RIP, " + dead + "!");
		   }
		   getLogger().info("[jtHardcore] " + dead + " died a horrible death (" + message + ") and was banned!");
	   }

}
