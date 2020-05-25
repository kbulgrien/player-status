package net.angusbeefgaming.playerstatus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

public class Menu implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender.hasPermission("playerstatus.open") || sender.isOp())) { // checks if the player has permission
            sender.sendMessage("Missing Permission Node: playerstatus.open");
            return false;
        }
        if (! (sender instanceof Player ) ) { // Then check if the player is in the game
            sender.sendMessage("You must run this command in-game!");
            return false;
        }
        Player player = (Player) sender; // Cast Player to Sender
        Player target = Bukkit.getServer().getPlayer(args[0]); 
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.BLUE + "WHOIS MENU");
        
        // Place all the items in the inventory
        ItemStack ITEM1 = nameItem(Material.COAL_ORE, ChatColor.AQUA + "Nick: " + target.getDisplayName());
        ItemStack ITEM2 = nameItem(Material.IRON_ORE, ChatColor.AQUA + "Health: " + target.getHealth());
        ItemStack ITEM3 = nameItem(Material.GOLD_ORE, ChatColor.AQUA + "is OP: " + target.isOp());
        ItemStack ITEM4 = nameItem(Material.LAPIS_ORE, ChatColor.AQUA + "Has Fly: " + hasFly(target));
        ItemStack ITEM5 = nameItem(Material.REDSTONE_ORE, ChatColor.AQUA + "Gamemode: " + target.getGameMode());
        ItemStack ITEM6 = nameItem(Material.DIAMOND_ORE, ChatColor.AQUA + "IP Address: " + target.getAddress());
        ItemStack ITEM7 = nameItem(Material.EMERALD_ORE, ChatColor.AQUA + "Hunger: " + target.getFoodLevel());
        // Then set them in the inventory
        inv.setItem(10, ITEM1);
        inv.setItem(12, ITEM2);
        inv.setItem(14, ITEM3);
        inv.setItem(16, ITEM4);
        inv.setItem(28, ITEM5);
        inv.setItem(30, ITEM6);
        inv.setItem(32, ITEM7);
        // And then finally, open the inventory for the player
        player.openInventory(inv);
        // Always return true!
        return true;
    }
    private ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
    
    /* Write a couple of methods to quickly grab if the player we are
     * talking about, has certain permissions such as Essentials.fly
     */
    
    private boolean hasFly(Player player) {
        if(player.hasPermission("essentials.fly")) {
            return true;
        }
        else {
            return false;
        }
    }
}
