package net.dungeon.joinQuitMessages.listeners;

import net.dungeon.joinQuitMessages.utils.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEventListener implements Listener {

    private final ConfigManager configManager;

    public PlayerEventListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String joinMessage = configManager.getJoinMessage()
                .replace("%player%", event.getPlayer().getName());
        event.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String quitMessage = configManager.getQuitMessage()
                .replace("%player%", event.getPlayer().getName());
        event.setQuitMessage(quitMessage);
    }
}
