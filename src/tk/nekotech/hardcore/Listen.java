package tk.nekotech.hardcore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Listen implements Listener {
	private final Hardcore hardcore;
	
	public Listen(Hardcore hardcore) {
		this.hardcore = hardcore;
	}
	

	@EventHandler (priority = EventPriority.HIGH)
	public void deathListener(EntityDeathEvent event) {
		if (event instanceof PlayerDeathEvent) {
			PlayerDeathEvent playerEvent = (PlayerDeathEvent)event;
			final Player player = (Player)playerEvent.getEntity();
			if (!player.hasPermission("jthardcore.protect")) {
				player.getWorld().strikeLightningEffect(player.getLocation());
				player.getWorld().strikeLightningEffect(player.getLocation());
				hardcore.announceDeath(player.getName().toString(), playerEvent.getDeathMessage().toString());
				player.kickPlayer("Banned: You died on hardcore mode.");
				player.setBanned(true);
			}
		}
	}

}
