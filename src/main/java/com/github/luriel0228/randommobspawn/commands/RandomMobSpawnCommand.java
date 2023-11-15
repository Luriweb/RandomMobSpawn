package com.github.luriel0228.randommobspawn.commands;

import com.github.luriel0228.randommobspawn.RandomMobSpawn;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomMobSpawnCommand implements CommandExecutor {

    private final RandomMobSpawn plugin;

    public RandomMobSpawnCommand(RandomMobSpawn plugin) {
        this.plugin = plugin;
    }

    private final Map<EntityType, Integer> spawnCounts = new HashMap<>();

    {
        spawnCounts.put(EntityType.ZOMBIE, 3);
        spawnCounts.put(EntityType.SKELETON, 3);
        spawnCounts.put(EntityType.PIGLIN, 3);
        spawnCounts.put(EntityType.PILLAGER, 3);
        spawnCounts.put(EntityType.DROWNED, 3);
        spawnCounts.put(EntityType.SILVERFISH, 3);
        spawnCounts.put(EntityType.ENDERMITE, 3);
        spawnCounts.put(EntityType.STRAY, 3);
        spawnCounts.put(EntityType.HUSK, 3);
        spawnCounts.put(EntityType.SPIDER, 1);
        spawnCounts.put(EntityType.CAVE_SPIDER, 1);
        spawnCounts.put(EntityType.ENDERMAN, 1);
        spawnCounts.put(EntityType.CREEPER, 1);
        spawnCounts.put(EntityType.SLIME, 1);
        spawnCounts.put(EntityType.BLAZE, 1);
        spawnCounts.put(EntityType.MAGMA_CUBE, 1);
        spawnCounts.put(EntityType.WITCH, 1);
        spawnCounts.put(EntityType.WITHER_SKELETON, 1);
        spawnCounts.put(EntityType.EVOKER, 1);
        spawnCounts.put(EntityType.VEX, 1);
        spawnCounts.put(EntityType.VINDICATOR, 1);
        spawnCounts.put(EntityType.ZOMBIFIED_PIGLIN, 1);
        spawnCounts.put(EntityType.RAVAGER, 1);
        spawnCounts.put(EntityType.ENDER_DRAGON, 1);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c해당 명령어는 플레이어만 입력가능합니다"));
            return true;
        }

        Player player = (Player) sender;
        spawnRandomMob(player);
        return true;
    }

    private void spawnRandomMob(Player player) {
        Random random = new Random();

        List<EntityType> spawnList = new ArrayList<>();

        for (Map.Entry<EntityType, Integer> entry : spawnCounts.entrySet()) {
            EntityType entityType = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                spawnList.add(entityType);
            }
        }

        EntityType randomEntityType = spawnList.get(random.nextInt(spawnList.size()));
        player.getWorld().spawnEntity(player.getLocation(), randomEntityType);
    }
}
