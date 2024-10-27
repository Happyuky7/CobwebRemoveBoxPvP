package com.github.happyuky7.cobwebRemoveBoxPvP.managers;

import com.github.happyuky7.cobwebRemoveBoxPvP.CobwebRemoveBoxPvP;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class RemoveCobwebinCooldown {

    public static void removeCobweb(int delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getServer().getWorlds()) {
                    world.getEntities().stream()
                            .filter(entity -> entity.getType().name().equals("COBWEB"))
                            .forEach(entity -> entity.remove());
                }
            }
        }.runTaskTimer(CobwebRemoveBoxPvP.getInstance(), delay * 20L, delay * 20L);
    }

}
