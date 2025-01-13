package com.github.gpaddons.gppmcaddons;

import com.github.gpaddons.gppmcaddons.config.Configuration;
import com.github.gpaddons.gppmcaddons.listeners.HorseTetheringListener;
import org.bukkit.plugin.java.JavaPlugin;


public class GPPMCAddons extends JavaPlugin {

    private Configuration config;

    @Override
    public void onEnable() {
        // Save default configuration
        saveDefaultConfig();

        // Initialize configuration
        config = new Configuration(this);

        // Register event listeners
        getServer().getPluginManager().registerEvents(new HorseTetheringListener(config), this);
    }

    public Configuration getConfiguration() {
        return config;
    }
}
