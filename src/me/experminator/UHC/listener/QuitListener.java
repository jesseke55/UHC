package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        GameManager.removePlayer(e.getPlayer());
    }
}
