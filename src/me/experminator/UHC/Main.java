package me.experminator.UHC;

import me.experminator.UHC.game.GameManager;
import me.experminator.UHC.game.GameState;
import me.experminator.UHC.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015, Experminator
 */
public class Main extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        if (plugin == null) plugin = this;

        // TODO: Register more listeners.
        getServer().getPluginManager().registerEvents(new LoginListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new EntityExplodeListener(), this);
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        getServer().getPluginManager().registerEvents(new FoodChangeListener(), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);
        getServer().getPluginManager().registerEvents(new WeatherChangeListener(), this);
        getServer().getPluginManager().registerEvents(new WorldChangeListener(), this);

        GameManager.setGameWorld(Bukkit.getWorlds().get(0));
        GameManager.setGameState(GameState.WAITING);
    }

    @Override
    public void onDisable() {
        if (plugin != null) plugin = null;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
