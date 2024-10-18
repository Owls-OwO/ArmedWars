package me.owls.armedwars;


import commands.ArmedWars_Command;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmedWars extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("armedwars").setExecutor(new ArmedWars_Command());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
