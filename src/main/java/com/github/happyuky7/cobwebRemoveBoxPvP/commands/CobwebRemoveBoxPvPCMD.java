package com.github.happyuky7.cobwebRemoveBoxPvP.commands;

import com.github.happyuky7.cobwebRemoveBoxPvP.CobwebRemoveBoxPvP;
import com.github.happyuky7.cobwebRemoveBoxPvP.utils.MessageColors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class CobwebRemoveBoxPvPCMD implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(MessageColors.getMsgColor(" "));
            sender.sendMessage(MessageColors.getMsgColor("&a CobwebRemoveBoxPvP"));
            sender.sendMessage(MessageColors.getMsgColor(" "));
            sender.sendMessage(MessageColors.getMsgColor("&aAuthor: &fHappyuky7"));
            sender.sendMessage(MessageColors.getMsgColor("&aVersion: &f1.0.1"));
            sender.sendMessage(MessageColors.getMsgColor("&aGitHub: &fhttps://github.com/happyuky7/CobwebRemoveBoxPvP"));
            sender.sendMessage(MessageColors.getMsgColor(" "));
            if (sender.hasPermission("cobwebremoveboxpvp.reload")) {
                sender.sendMessage(MessageColors.getMsgColor("&cInfo: &fCooldwon update recommened restart server."));
                sender.sendMessage(MessageColors.getMsgColor(" "));
                sender.sendMessage(MessageColors.getMsgColor("&a/cobwebremoveboxpvp reload &f- &aReload plugin"));
            }
            sender.sendMessage(MessageColors.getMsgColor(" "));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("cobwebremoveboxpvp.reload")) {
                sender.sendMessage(MessageColors.getMsgColor("&cYou do not have permission to use this command."));
                return true;
            }

            sender.sendMessage(MessageColors.getMsgColor(" "));
            sender.sendMessage(MessageColors.getMsgColor("&a CobwebRemoveBoxPvP &f- &aReloaded"));
            sender.sendMessage(MessageColors.getMsgColor(" "));

            CobwebRemoveBoxPvP.getInstance().getConfig().save();
            CobwebRemoveBoxPvP.getInstance().getConfig().reload();

            Bukkit.getPluginManager().disablePlugin(CobwebRemoveBoxPvP.getInstance());
            Bukkit.getPluginManager().enablePlugin(CobwebRemoveBoxPvP.getInstance());

            return true;

        }

        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (sender.hasPermission("cobwebremoveboxpvp.reload")) {
                return List.of("reload");
            }
        }
        return List.of();
    }
}
