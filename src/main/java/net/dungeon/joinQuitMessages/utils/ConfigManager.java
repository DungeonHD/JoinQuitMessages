package net.dungeon.joinQuitMessages.utils;

import net.dungeon.joinQuitMessages.JoinQuitPlugin;

public class ConfigManager {

    private final JoinQuitPlugin plugin;

    public ConfigManager(JoinQuitPlugin plugin) {
        this.plugin = plugin;
    }

    public String getJoinMessage() {
        return plugin.getConfig().getString("JoinMessage", "%player% joined");
    }

    public String getQuitMessage() {
        return plugin.getConfig().getString("QuitMessage", "%player% left");
    }

    public void reloadConfig() {
        plugin.reloadConfig();
    }
}
