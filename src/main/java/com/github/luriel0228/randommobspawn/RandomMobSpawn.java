package com.github.luriel0228.randommobspawn;

import com.github.luriel0228.randommobspawn.commands.RandomMobSpawnCommand;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RandomMobSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        setExecutor();
    }

    private void setExecutor() {
        PluginCommand randomMobSpawnCmd = getCommand("랜덤몹생성");
        Objects.requireNonNull(randomMobSpawnCmd).setExecutor(new RandomMobSpawnCommand(this));
    }
}