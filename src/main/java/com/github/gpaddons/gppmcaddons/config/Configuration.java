package com.github.gpaddons.gppmcaddons.config;

import com.github.gpaddons.gppmcaddons.GPPMCAddons;
import org.jetbrains.annotations.NotNull;


public class Configuration {

    private final BooleanSetting HorseTetheringEnabled;

    public Configuration(@NotNull GPPMCAddons plugin) {

        // Initialize "enabled" parameter of "HorseTetheringEnabled"
        HorseTetheringEnabled = new BooleanSetting(
                plugin.getConfig(),
                "gp_pmc_addons.HorseTetheringEnabled.enabled",
                true // default value
        );
    }

    /**
     * Check if the "HorseTethering" setting is enabled.
     * @return True if the setting is enabled, false otherwise
     */
    public boolean isHorseTetheringEnabled() {
        // No override in this case
        return HorseTetheringEnabled.get("");
    }
}
