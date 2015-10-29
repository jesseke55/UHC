package me.experminator.UHC.game;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) 2015, Experminator
 */
public class GameTimer extends BukkitRunnable {

    @Override
    public void run() {
        if (GameManager.getGameTime() <= 0) {
            cancel();

        }
    }
}
