package com.github.happyuky7.cobwebRemoveBoxPvP;

import com.github.happyuky7.cobwebRemoveBoxPvP.commands.CobwebRemoveBoxPvPCMD;
import com.github.happyuky7.cobwebRemoveBoxPvP.files.FileManager;
import com.github.happyuky7.cobwebRemoveBoxPvP.listeners.EventListeners;
import com.github.happyuky7.cobwebRemoveBoxPvP.managers.RemoveCobwebinCooldown;
import com.github.happyuky7.cobwebRemoveBoxPvP.utils.MessageColors;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CobwebRemoveBoxPvP extends JavaPlugin {

    private static CobwebRemoveBoxPvP instance;

    public static CobwebRemoveBoxPvP getInstance() {
        return instance;
    }

    public FileManager config;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        config = new FileManager(this, "config");

        int cooldown = getConfig().getInt("cooldown");

        getServer().getPluginManager().registerEvents(new EventListeners(), this);
        getServer().getPluginManager().registerEvents(new RemoveCobwebinCooldown(), this);
        getCommand("cobwebremoveboxpvp").setExecutor(new CobwebRemoveBoxPvPCMD());

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, RemoveCobwebinCooldown::removeCobweb, 0L, cooldown * 20L);

        if (Bukkit.getPluginManager().getPlugin("WorldGuard") == null) {
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&a CobwebRemoveBoxPvP &f- &cError"));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&cWorldGuard not found!"));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&cRequired WorldGuard plugin."));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&cPlugin disabled."));
            Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&a CobwebRemoveBoxPvP &f- &aEnabled"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aAuthor: &fHappyuky7"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aVersion: &f1.0.3"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aGitHub: &fhttps://github.com/happyuky7/CobwebRemoveBoxPvP"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&cInfo: &fCooldwon update restart required."));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("Cooldown: " + cooldown + " seconds"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&a CobwebRemoveBoxPvP &f- &cDisabled"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aAuthor: &fHappyuky7"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aVersion: &f1.0.3"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor("&aGitHub: &fhttps://github.com/happyuky7/CobwebRemoveBoxPvP"));
        Bukkit.getConsoleSender().sendMessage(MessageColors.getMsgColor(" "));


    }

    public FileManager getConfig() {
        return config;
    }

}
