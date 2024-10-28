package com.github.happyuky7.cobwebRemoveBoxPvP.managers;

import com.github.happyuky7.cobwebRemoveBoxPvP.CobwebRemoveBoxPvP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveCobwebinCooldown implements Listener {

    public static HashMap<World, List<Block>> cobwebBlocks = new HashMap<>();

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        if (event.getBlock().getType() == org.bukkit.Material.COBWEB) {
            cobwebBlocks.computeIfAbsent(event.getBlock().getWorld(), k -> new ArrayList<>()).add(event.getBlock());
        }
    }

    public static void removeCobweb() {
        System.out.println("Removing cobweb");
        for (World world : Bukkit.getServer().getWorlds()) {
            System.out.println("Checking world: " + world.getName());
            if (cobwebBlocks.containsKey(world)) {
                List<Block> blocks = cobwebBlocks.get(world);
                for (Block block : blocks) {
                    block.setType(Material.AIR);
                    System.out.println("Cobweb removed at " + block.getLocation());
                }
                cobwebBlocks.remove(world, blocks);
            } else {
                System.out.println("No cobweb found in world: " + world.getName());
            }
        }
    }



    /*public static void removeCobweb(CobwebRemoveBoxPvP plugin, int delay) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getServer().getWorlds()) {
                    world.getEntities().stream()
                            .filter(entity -> entity.getType().name().equals("COBWEB"))
                            .forEach(entity -> entity.remove());
                }
            }
        }.runTaskTimer(plugin, 0, delay * 20);
    }*/

}
