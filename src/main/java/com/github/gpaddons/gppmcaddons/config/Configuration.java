package com.github.gpaddons.gppmcaddons.config;

import com.github.gpaddons.gppmcaddons.GPPMCAddons;
import org.jetbrains.annotations.NotNull;


public class Configuration {

    private final BooleanSetting overrideClaimTetheringEnabled;

    public Configuration(@NotNull GPPMCAddons plugin) {

        // Initialize "enabled" parameter of "overrideClaimTethering"
        overrideClaimTetheringEnabled = new BooleanSetting(
                plugin.getConfig(),
                "gp_pmc_addons.overrideClaimTethering.enabled",
                true // default value
        );
    }

    /**
     * Check if the "overrideClaimTethering" setting is enabled.
     * @return True if the setting is enabled, false otherwise
     */
    public boolean isOverrideClaimTetheringEnabled() {
        // No override in this case
        return overrideClaimTetheringEnabled.get("");
    }
}
