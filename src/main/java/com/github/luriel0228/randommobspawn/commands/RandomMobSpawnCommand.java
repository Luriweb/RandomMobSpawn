package com.github.luriel0228.randommobspawn.commands;

import com.github.luriel0228.randommobspawn.RandomMobSpawn;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMobSpawnCommand implements CommandExecutor {

    private final RandomMobSpawn plugin;

    public RandomMobSpawnCommand(RandomMobSpawn plugin) {
        this.plugin = plugin;
    }

    private final List<MobSpawnData> mobSpawnDataList = createSpawnList();

    private List<MobSpawnData> createSpawnList() {
        List<MobSpawnData> spawnList = new ArrayList<>();

        spawnList.add(new MobSpawnData(EntityType.ZOMBIE, 3));
        spawnList.add(new MobSpawnData(EntityType.SKELETON, 3));
        spawnList.add(new MobSpawnData(EntityType.PIGLIN, 3));
        spawnList.add(new MobSpawnData(EntityType.PILLAGER, 3));
        spawnList.add(new MobSpawnData(EntityType.DROWNED, 3));
        spawnList.add(new MobSpawnData(EntityType.SILVERFISH, 3));
        spawnList.add(new MobSpawnData(EntityType.ENDERMITE, 3));
        spawnList.add(new MobSpawnData(EntityType.STRAY, 3));
        spawnList.add(new MobSpawnData(EntityType.HUSK, 3));

        spawnList.add(new MobSpawnData(EntityType.SPIDER, 1));
        spawnList.add(new MobSpawnData(EntityType.CAVE_SPIDER, 1));
        spawnList.add(new MobSpawnData(EntityType.ENDERMAN, 1));
        spawnList.add(new MobSpawnData(EntityType.ZOMBIFIED_PIGLIN, 1));
        spawnList.add(new MobSpawnData(EntityType.CREEPER, 1));
        spawnList.add(new MobSpawnData(EntityType.SLIME, 1));
        spawnList.add(new MobSpawnData(EntityType.BLAZE, 1));
        spawnList.add(new MobSpawnData(EntityType.MAGMA_CUBE, 1));
        spawnList.add(new MobSpawnData(EntityType.WITCH, 1));
        spawnList.add(new MobSpawnData(EntityType.WITHER_SKELETON, 1));
        spawnList.add(new MobSpawnData(EntityType.EVOKER, 1));
        spawnList.add(new MobSpawnData(EntityType.VEX, 1));
        spawnList.add(new MobSpawnData(EntityType.VINDICATOR, 1));
        spawnList.add(new MobSpawnData(EntityType.RAVAGER, 1));

        return spawnList;
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
        MobSpawnData data = getRandomMobData(random);

        EntityType entityType = data.getEntityType();
        int count = data.getCount();

        for (int i = 0; i < count; i++) {
            player.getWorld().spawnEntity(player.getLocation(), entityType);
        }
    }

    private MobSpawnData getRandomMobData(Random random) {
        return mobSpawnDataList.get(random.nextInt(mobSpawnDataList.size()));
    }

    private static class MobSpawnData {
        private final EntityType entityType;
        private final int count;

        public MobSpawnData(EntityType entityType, int count) {
            this.entityType = entityType;
            this.count = count;
        }

        public EntityType getEntityType() {
            return entityType;
        }

        public int getCount() {
            return count;
        }
    }
}
