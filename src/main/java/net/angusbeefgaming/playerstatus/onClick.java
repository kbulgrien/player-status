package net.angusbeefgaming.playerstatus;

/*
 * onClick Detector
 * Written by Atticus Zambrana
 * 
 * Main file that calls code when the user clicks on the inventory
 */

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.*;

public class onClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        if(! player.getOpenInventory().getTitle().equals(ChatColor.BLUE + "WHOIS MENU")) {
            return;
        }
        if(!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        
        event.setCancelled(true);
    }
}


