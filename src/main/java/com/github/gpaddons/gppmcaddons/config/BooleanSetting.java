package com.github.gpaddons.gppmcaddons.config;

import com.github.jikoo.planarwrappers.config.Setting;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;



public class BooleanSetting extends Setting<Boolean> {

    /**
     * @param section      The configuration section containing the setting.
     * @param path         The path to the boolean setting within the configuration.
     * @param defaultValue The default value if the setting is not specified.
     */
    public BooleanSetting(@NotNull ConfigurationSection section, @NotNull String path, boolean defaultValue) {
        super(section, path, defaultValue);
    }

    /**
     * Retrieves the boolean value associated with the given path.
     *
     * @param path The complete path, including any overrides.
     * @return The boolean value if defined, otherwise null.
     */
    @Override
    protected @Nullable Boolean getPathSetting(@NotNull String path) {
        if (section.isBoolean(path)) {
            return section.getBoolean(path);
        }
        return null;
    }
}