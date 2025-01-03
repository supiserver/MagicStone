package net.supiserver.play.magicStone;

import net.supiserver.play.magicStone.system.MainSystem;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicStone extends JavaPlugin {
    private static JavaPlugin plugin;
    private static MainSystem system;

    public static JavaPlugin getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        this.saveDefaultConfig();
        ;
        system = new MainSystem();
    }

    @Override
    public void onDisable() {
        //system.printProbabilities();
        // Plugin shutdown logic
    }
}
