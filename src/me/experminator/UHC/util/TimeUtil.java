package me.experminator.UHC.util;

/**
 * Copyright (c) 2015, Experminator
 */
public class TimeUtil {

    public static final int SECOND = 1;
    public static final int MINUTE = SECOND * 60;
    public static final int HOUR = MINUTE * 60;

    public static final int MINECRAFT_SECOND = 20;
    public static final int MINECRAFT_MINUTE = MINECRAFT_SECOND * 60;
    public static final int MINECRAFT_HOUR = MINECRAFT_MINUTE * 60;

    public static String toFormattedTime(long time) {
        long hours = time / 60;
        long minutes = hours / 60;
        long seconds = minutes / 60;

        return hours + ":" + minutes + ":" + seconds;
    }
}
