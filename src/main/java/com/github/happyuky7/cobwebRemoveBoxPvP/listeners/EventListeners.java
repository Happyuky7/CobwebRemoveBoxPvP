package com.github.happyuky7.cobwebRemoveBoxPvP.listeners;

import com.github.happyuky7.cobwebRemoveBoxPvP.CobwebRemoveBoxPvP;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;

public class EventListeners implements Listener {

    // BlockBreakEvent

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        List<String> regionList = CobwebRemoveBoxPvP.getInstance().getConfig().getStringList("regions");

        Location location = event.getBlock().getLocation();
        World world = BukkitAdapter.adapt(event.getPlayer().getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionsManager = container.get(world);
        ApplicableRegionSet regions = regionsManager.getApplicableRegions(BukkitAdapter.asBlockVector(location));

        Iterator<ProtectedRegion> iterator = regions.iterator();

        if (iterator.hasNext()) {

            ProtectedRegion region = iterator.next();
            String regionName = region.getId();

            if (regionName == null) return;

            if (regionList.contains(regionName)) {

                if (event.getBlock().getType() == Material.COBWEB) {

                    event.setCancelled(false);
                    //event.getBlock().setType(Material.AIR);
                    //event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBWEB));

                }

            }

        }

    }

    // BlockPlaceEvent

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        List<String> regionList = CobwebRemoveBoxPvP.getInstance().getConfig().getStringList("regions");

        Location location = event.getBlock().getLocation();
        World world = BukkitAdapter.adapt(event.getPlayer().getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionsManager = container.get(world);
        ApplicableRegionSet regions = regionsManager.getApplicableRegions(BukkitAdapter.asBlockVector(location));

        Iterator<ProtectedRegion> iterator = regions.iterator();

        if (iterator.hasNext()) {

            ProtectedRegion region = iterator.next();
            String regionName = region.getId();

            if (regionName == null) return;

            if (regionList.contains(regionName)) {

                if (event.getBlock().getType() == Material.COBWEB) {

                    event.setCancelled(false);
                    //event.getBlock().setType(Material.AIR);
                    //event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBWEB));

                }

            }

        }
    }


}
