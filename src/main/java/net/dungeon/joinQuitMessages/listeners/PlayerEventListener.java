package net.dungeon.joinQuitMessages.listeners;

import net.dungeon.joinQuitMessages.JoinQuitPlugin;
import net.dungeon.joinQuitMessages.utils.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEventListener implements Listener {

    private final JoinQuitPlugin plugin;

    public PlayerEventListener(JoinQuitPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String joinMessage = plugin.getConfig().getString("JoinMessage", "%player% joined");
        joinMessage = joinMessage.replace("%player%", event.getPlayer().getName());
        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String quitMessage = plugin.getConfig().getString("QuitMessage", "%player% left");
        quitMessage = quitMessage.replace("%player%", event.getPlayer().getName());
        event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', quitMessage));
    }
}
