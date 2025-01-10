package com.github.gpaddons.gppmcaddons.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;


public class HorseUtils
{
    private static final double SEARCH_RADIUS = 20.0;

    private static final Set<Material> FENCE_MATERIALS = Set.of(
            Material.OAK_FENCE,
            Material.ACACIA_FENCE,
            Material.BIRCH_FENCE,
            Material.DARK_OAK_FENCE,
            Material.JUNGLE_FENCE,
            Material.SPRUCE_FENCE,
            Material.BAMBOO_FENCE,
            Material.NETHER_BRICK_FENCE,
            Material.CRIMSON_FENCE,
            Material.MANGROVE_FENCE
    );

    /**
     * Check if the block is a fence
     * @param block Block to check
     * @return True if block is a fence, false otherwise
     */
    public static boolean isFenceBlock(@NotNull Block block)
    {
        return FENCE_MATERIALS.contains(block.getType());
    }


    /**
     * Get the horse entity that is leashed to the fence block or the player that interacted with the fence
     * @param fence Fence on which the player interacted
     * @param interactPlayer Player that interacted with the fence
     * @return Leashed horse entity or null if not found
     */
    public static Horse getHorseFromFence(@NotNull Block fence, @NotNull Player interactPlayer)
    {
        // Check if block is a fence
        if (!isFenceBlock(fence))
            return null;

        // Find nearby entities
        Location fenceLocation = fence.getLocation();
        List<Entity> nearbyEntities = (List<Entity>)
                fence.getWorld().getNearbyEntities(fenceLocation, SEARCH_RADIUS, SEARCH_RADIUS, SEARCH_RADIUS);

        for (Entity entity : nearbyEntities)
        {
            // Check if entity is a leashed horse
            if (!(entity instanceof Horse horse) || !horse.isLeashed())
                continue;

            // Check if horse is leashed to the fence or the player that triggered the event
            if ((horse.getLeashHolder() instanceof Player player && player == interactPlayer) ||
                    (horse.getLeashHolder() instanceof LeashHitch hitch &&
                            hitch.getLocation().getBlock().equals(fence)))
                return horse;
        }

        // No horse found
        return null;
    }

    /**
     * Get the owner of the horse
     * @param horse Horse entity
     * @return Owner of the horse or null if not found
     */
    public static Player getHorseOwner(@NotNull Horse horse)
    {
        // Check if horse is tamed
        if (horse.isTamed() && horse.getOwner() instanceof Player owner)
            return owner;
        // No owner found
        return null;
    }
}