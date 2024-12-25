package net.dungeon.joinQuitMessages;

import net.dungeon.joinQuitMessages.commands.JQMCommand;
import net.dungeon.joinQuitMessages.listeners.PlayerEventListener;
import net.dungeon.joinQuitMessages.utils.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinQuitPlugin extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configManager = new ConfigManager(this);

        getServer().getPluginManager().registerEvents(new PlayerEventListener(this), this);

        JQMCommand jqmCommand = new JQMCommand(this, configManager);
        getCommand("jqm").setExecutor(jqmCommand);
        getCommand("jqm").setTabCompleter(jqmCommand);

    }

    @Override
    public void onDisable() {
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
