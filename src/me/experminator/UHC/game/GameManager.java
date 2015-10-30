package me.experminator.UHC.game;

import me.experminator.UHC.Main;
import me.experminator.UHC.util.MessageUtil;
import me.experminator.UHC.util.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2015, Experminator
 */
public class GameManager {

    private static World gameWorld;
    private static GameState gameState;
    private static int min_players = 6;
    private static int max_players = Bukkit.getMaxPlayers();
    private static long countdownTime = 60;
    private static long gameTime = 60 * 30;
    private static List<Integer> countdownBroadcastTimes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 60));
    private static List<UHCPlayer> players = new ArrayList<>(); // TODO: Change to HashMap for team implementation.

    private GameManager() { }

    public static int getMinPlayers() {
        return min_players;
    }

    public static void setMinPlayers(int min_players) {
        GameManager.min_players = min_players;
    }

    public static int getMaxPlayers() {
        return max_players;
    }

    public static void setMaxPlayers(int max_players) {
        GameManager.max_players = max_players;
    }

    public static long getGameTime() {
        return gameTime;
    }

    public static void setGameTime(long gameTime) {
        GameManager.gameTime = gameTime;
    }

    public static long getCountdownTime() {
        return countdownTime;
    }

    public static void setCountdownTime(long time) {
        GameManager.countdownTime = time;
    }

    public static List<Integer> getCountdownBroadcastTimes() {
        return countdownBroadcastTimes;
    }

    public static void setCountdownBroadcastTimes(Integer... countdownBroadcastTimes) {
        GameManager.countdownBroadcastTimes = Arrays.asList(countdownBroadcastTimes);
    }

    public static List<UHCPlayer> getPlayers() {
        return players;
    }

    public static UHCPlayer getPlayer(Player p) {
        for (UHCPlayer uhcPlayer : players) {
            if (uhcPlayer.getBukkitPlayer().getName().equalsIgnoreCase(p.getName()) ||
                    uhcPlayer.getBukkitPlayer().getDisplayName().contains(p.getDisplayName()) ||
                    uhcPlayer.getBukkitPlayer().getUniqueId() == p.getUniqueId() ||
                    uhcPlayer.getBukkitPlayer() == p) {
                return uhcPlayer;
            }
        }

        return null;
    }

    public static int getUHCPlayers() {
        return players.size();
    }

    public static boolean hasPlayer(Player p) {
        return getPlayer(p) != null;
    }

    public static synchronized void addPlayer(Player p) {
        if (!hasPlayer(p)) {
            players.add(new UHCPlayer(p));
        }
    }

    public static synchronized void removePlayer(Player p) {
        if (hasPlayer(p)) {
            players.remove(getPlayer(p));
        }
    }

    public static World getGameWorld() {
        return gameWorld;
    }

    public static void setGameWorld(World gameWorld) {
        GameManager.gameWorld = gameWorld;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        GameManager.gameState = gameState;
    }

    public static boolean isReadyToStart() {
        return (Bukkit.getOnlinePlayers().size() >= min_players) && (gameState == GameState.WAITING);
    }

    public static synchronized void broadcast(String... msgs) {
        for (UHCPlayer on : players) {
            for (String msg : msgs) {
                on.getBukkitPlayer().sendMessage(MessageUtil.toColorText(msg));
            }
        }
    }

    public static synchronized void startCountdown() {
        setGameState(GameState.COUNTDOWN);
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new CountdownTimer(), 0L, TimeUtil.MINECRAFT_SECOND);
    }

    public static synchronized void startGame() {
        setGameState(GameState.IN_GAME);
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new GameTimer(), 0L, TimeUtil.MINECRAFT_SECOND);
    }

    public static synchronized void endGame() {
        setGameState(GameState.ENDED);
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {

            @Override
            public void run() {
                for (UHCPlayer p : players) {
                    p.getBukkitPlayer().kickPlayer(MessageUtil.toColorText("&6&lUHC is finished!"));
                }
            }

        }, TimeUtil.MINECRAFT_SECOND);
    }
}
