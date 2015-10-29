package me.experminator.UHC.game;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) 2015, Experminator
 */
public class CountdownTimer extends BukkitRunnable {

    @Override
    public void run() {
        if (GameManager.getTime() <= 0) {
            cancel();
            GameManager.startGame();
        } else {
            for (int broadcastTime : GameManager.getCountdownBroadcastTimes()) {
                GameManager.broadcast("&6&lUHC begins in&a&l{time}&6&l {unit}!"
                                .replace("{time}", Integer.toString(broadcastTime))
                                .replace("{unit}", (broadcastTime > 1 ? "seconds" : "second"))
                );
            }

            GameManager.setTime(GameManager.getTime() - 1);
        }
    }
}
