package com.github.luriel0228.randommobspawn.commands;

import com.github.luriel0228.randommobspawn.RandomMobSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomMobSpawnCommand implements CommandExecutor {

    private final RandomMobSpawn plugin;

    public RandomMobSpawnCommand(RandomMobSpawn plugin) {
        this.plugin = plugin;
    }

    private final List<EntityType> entityList = Arrays.asList(
            EntityType.ZOMBIE,
            EntityType.SKELETON
    );

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
            return true;
        }

        Player player = (Player) sender;
        spawnRandomMob(player);
        return true;
    }

    private void spawnRandomMob(Player player) {

        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();

        EntityType randomMobType = entityList.get(new Random().nextInt(entityList.size()));

        player.getWorld().spawnEntity(player.getLocation(), randomMobType);
    }
}