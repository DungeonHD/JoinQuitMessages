package net.dungeon.joinQuitMessages.commands;

import net.dungeon.joinQuitMessages.JoinQuitPlugin;
import net.dungeon.joinQuitMessages.utils.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JQMCommand implements CommandExecutor, TabCompleter {

    private final JoinQuitPlugin plugin;
    private final ConfigManager configManager;

    public JQMCommand(JoinQuitPlugin plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check for permission
        if (!sender.hasPermission("jqm.reload")) {
            sender.sendMessage(getMessage("Messages.NoPermission", "&cYou don't have permission to execute this command."));
            return true;
        }

        // Check for arguments
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(getMessage("Messages.Reload", "&aConfiguration reloaded successfully!"));
            return true;
        }

        // Syntax error message
        sender.sendMessage(getMessage("Messages.Syntax", "&cUsage: /jqm reload"));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            if ("reload".startsWith(args[0].toLowerCase())) {
                completions.add("reload");
            }
            return completions;
        }
        return Collections.emptyList();
    }

    /**
     * Retrieves a message from the configuration or returns a default value.
     *
     * @param path         Path to the message in the configuration.
     * @param defaultValue Default value if the message is not defined or null.
     * @return Translated message.
     */
    private String getMessage(String path, String defaultValue) {
        String message = plugin.getConfig().getString(path);
        if (message == null || message.isEmpty()) {
            message = defaultValue;
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
