package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import me.experminator.UHC.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class WeatherChangeListener implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if (GameManager.getGameState() != GameState.IN_GAME) {
            e.setCancelled(true);
        }
    }
}
