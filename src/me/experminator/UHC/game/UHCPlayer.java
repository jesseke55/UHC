package me.experminator.UHC.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Copyright (c) 2015, Experminator
 */
public class UHCPlayer {

    private Player player;

    public UHCPlayer(Player player) {
        this.player = player;
    }

    @Deprecated
    public UHCPlayer(String name) {
        this(Bukkit.getPlayer(name));
    }

    @Deprecated
    public UHCPlayer(UUID uuid) {
        this(Bukkit.getPlayer(uuid));
    }

    public Player getBukkitPlayer() {
        return player;
    }
}
