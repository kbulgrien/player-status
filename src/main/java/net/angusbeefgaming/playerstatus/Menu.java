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
        if(!(sender instanceof Player)) { // Then Checks if the player is in the game
            sender.sendMessage("You Must run this command in-game!"); 
            return false;
        }
        Player player = (Player) sender; // Cast Player to Sender
        Player target = Bukkit.getServer().getPlayer(args[0]); 
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.BLUE + "WHOIS MENU");
        
        // Here I will place all the items in the inventory
        ItemStack ITEM1 = nameItem(Material.COAL_ORE, ChatColor.AQUA + "Nick: " + target.getDisplayName());
        ItemStack ITEM2 = nameItem(Material.IRON_ORE, ChatColor.AQUA + "Health: " + target.getHealth());
        ItemStack ITEM3 = nameItem(Material.GOLD_ORE, ChatColor.AQUA + "is OP: " + target.isOp());
        ItemStack ITEM4 = nameItem(Material.LAPIS_ORE, ChatColor.AQUA + "Has Fly: " + hasFly(target));
        ItemStack ITEM5 = nameItem(Material.REDSTONE_ORE, ChatColor.AQUA + "Gamemode: " + target.getGameMode());
        // Then I set them in the inv
        inv.setItem(10, ITEM1);
        inv.setItem(12, ITEM2);
        inv.setItem(14, ITEM3);
        inv.setItem(16, ITEM4);
        inv.setItem(28, ITEM5);
        // And then Finnaly, I am going to open the Inv for the player
        player.openInventory(inv);
        // And Of course, return true!
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
    
    /* Here is where I write a couple of methods to quickly grab if the player we are
    Talking about, has certain permissions
    
    Such as Essentials.fly
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
