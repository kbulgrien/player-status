package net.angusbeefgaming.playerstatus;
import org.bukkit.plugin.java.JavaPlugin;
public class PS extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("player").setExecutor(new Menu());
        getServer().getPluginManager().registerEvents(new onClick(), this);
    }
    @Override
    public void onDisable() {
        
    }
}
