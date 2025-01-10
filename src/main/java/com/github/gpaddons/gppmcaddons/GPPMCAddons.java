package com.github.gpaddons.gppmcaddons;

import com.github.gpaddons.gppmcaddons.listeners.HorsePermissionListener;
import org.bukkit.plugin.java.JavaPlugin;

public class GPPMCAddons extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new HorsePermissionListener(), this);
    }
}
