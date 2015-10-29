package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import me.experminator.UHC.game.GameState;
import me.experminator.UHC.util.MessageUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class LoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        if (GameManager.getGameState() != GameState.WAITING) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, MessageUtil.toColorText("&cUHC is already started!"));
        }
    }
}
