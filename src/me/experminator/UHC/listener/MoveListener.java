package me.experminator.UHC.listener;

import me.experminator.UHC.game.GameManager;
import me.experminator.UHC.game.GameState;
import me.experminator.UHC.util.EffectUtil;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Copyright (c) 2015, Experminator
 */
public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (GameManager.getGameState() != GameState.IN_GAME && e.getTo().distance(GameManager.getGameWorld().getSpawnLocation()) >= 16) {
            e.getPlayer().teleport(GameManager.getGameWorld().getSpawnLocation());
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.WITHER_HURT, 1F, 1F);
            EffectUtil.sendParticleEffect(e.getPlayer().getLocation(), EnumParticle.FLAME, e.getPlayer());
        }
    }
}
