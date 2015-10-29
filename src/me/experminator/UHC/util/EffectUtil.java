package me.experminator.UHC.util;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2015, Experminator
 */
public class EffectUtil {

    public static void sendParticleEffect(Location loc, EnumParticle particle, Player... players) {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                particle,
                true,
                (float) loc.getX(),
                (float) loc.getY(),
                (float) loc.getZ(),
                0,
                0,
                0,
                10,
                1,
                null
        );

        for (Player p : players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }
}
