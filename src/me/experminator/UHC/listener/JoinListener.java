package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        GameManager.addPlayer(e.getPlayer());

        if (GameManager.isReadyToStart()) {
            GameManager.startCountdown();
        }
    }
}
