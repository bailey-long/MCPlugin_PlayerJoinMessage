package mc.dnb.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

//Event listener class.
public class PluginTest extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        //Setup event listener
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        System.out.println("Player Join message plugin");
    }
}
final class MyListener implements Listener {
    @EventHandler
    //if player has not joined before, send unique join message
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if(!event.getPlayer().hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Everyone please welcome " + event.getPlayer().getName() + " to SkyScape!");
        } else {
            event.setJoinMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Welcome back, " + event.getPlayer().getName() + "!");
        }
    }
}
