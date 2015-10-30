package me.experminator.UHC.util;

import me.experminator.UHC.Main;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

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

    public static void sendFireworkEffect(Location loc, FireworkEffect... effects) {
        final Firework fw = loc.getWorld().spawn(loc, Firework.class);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.clearEffects();
        fwm.addEffects(effects);
        fwm.setPower(1);

        fw.setFireworkMeta(fwm);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                fw.detonate();
            }
        });
    }
}
