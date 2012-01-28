package tk.nekotech.hardcore;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

public class Hardcore extends JavaPlugin {

	public Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile = this.getDescription();
	
	@Override
	public void onDisable() {
		log.info("[Hardcore] Disabled!");
	}

	@Override
	public void onEnable() {
		log.info("[Hardcore] Enabled!");
		
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new Listen(this), this);
	}
		
	public void announceDeath(String dead, String message) {
		   for (final Player player : this.getServer().getOnlinePlayers()) {
			   player.sendMessage(ChatColor.YELLOW + "RIP, " + dead + "!");
		   }
		   log.info("[Hardcore] " + dead + " died a horrible death (" + message + ") and was banned!");
	   }

}
