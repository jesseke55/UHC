package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import me.experminator.UHC.game.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class WorldChangeListener implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        if (GameManager.getGameState() != GameState.IN_GAME) {
            // This shouldn't happen without commands or plugins.
            e.getPlayer().teleport(GameManager.getGameWorld().getSpawnLocation());
        }
    }
}
