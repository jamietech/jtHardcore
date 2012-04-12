package tk.nekotech.hardcore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listen implements Listener {
	private final Hardcore hardcore;
	
	public Listen(Hardcore hardcore) {
		this.hardcore = hardcore;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (!event.getEntity().hasPermission("jthardcore.protect")) {
				event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
				event.getEntity().getWorld().strikeLightningEffect(event.getEntity().getLocation());
				hardcore.announceDeath(event.getEntity().getName().toString(), event.getDeathMessage().toString());
				event.getEntity().kickPlayer("Banned: You died on hardcore mode.");
				event.getEntity().setBanned(true);
		}
	}

}
