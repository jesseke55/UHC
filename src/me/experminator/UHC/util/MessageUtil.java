package me.experminator.UHC.util;

import org.bukkit.ChatColor;

/**
 * Copyright (c) 2015, Experminator
 */
public class MessageUtil {

    public static String toColorText(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
