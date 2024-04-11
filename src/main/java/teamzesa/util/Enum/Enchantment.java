package teamzesa.util.Enum;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Enchantment implements Keyed, net.kyori.adventure.translation.Translatable { // Paper - Adventure translations
    /**
     * Provides protection against environmental damage
     */
    public static final org.bukkit.enchantments.Enchantment PROTECTION_ENVIRONMENTAL = getEnchantment("protection");

    /**
     * Provides protection against fire damage
     */
    public static final org.bukkit.enchantments.Enchantment PROTECTION_FIRE = getEnchantment("fire_protection");

    /**
     * Provides protection against fall damage
     */
    public static final org.bukkit.enchantments.Enchantment PROTECTION_FALL = getEnchantment("feather_falling");

    /**
     * Provides protection against explosive damage
     */
    public static final org.bukkit.enchantments.Enchantment PROTECTION_EXPLOSIONS = getEnchantment("blast_protection");

    /**
     * Provides protection against projectile damage
     */
    public static final org.bukkit.enchantments.Enchantment PROTECTION_PROJECTILE = getEnchantment("projectile_protection");

    /**
     * Decreases the rate of air loss whilst underwater
     */
    public static final org.bukkit.enchantments.Enchantment OXYGEN = getEnchantment("respiration");

    /**
     * Increases the speed at which a player may mine underwater
     */
    public static final org.bukkit.enchantments.Enchantment WATER_WORKER = getEnchantment("aqua_affinity");

    /**
     * Damages the attacker
     */
    public static final org.bukkit.enchantments.Enchantment THORNS = getEnchantment("thorns");

    /**
     * Increases walking speed while in water
     */
    public static final org.bukkit.enchantments.Enchantment DEPTH_STRIDER = getEnchantment("depth_strider");

    /**
     * Freezes any still water adjacent to ice / frost which player is walking on
     */
    public static final org.bukkit.enchantments.Enchantment FROST_WALKER = getEnchantment("frost_walker");

    /**
     * Item cannot be removed
     */
    public static final org.bukkit.enchantments.Enchantment BINDING_CURSE = getEnchantment("binding_curse");

    /**
     * Increases damage against all targets
     */
    public static final org.bukkit.enchantments.Enchantment DAMAGE_ALL = getEnchantment("sharpness");

    /**
     * Increases damage against undead targets
     */
    public static final org.bukkit.enchantments.Enchantment DAMAGE_UNDEAD = getEnchantment("smite");

    /**
     * Increases damage against arthropod targets
     */
    public static final org.bukkit.enchantments.Enchantment DAMAGE_ARTHROPODS = getEnchantment("bane_of_arthropods");

    /**
     * All damage to other targets will knock them back when hit
     */
    public static final org.bukkit.enchantments.Enchantment KNOCKBACK = getEnchantment("knockback");

    /**
     * When attacking a target, has a chance to set them on fire
     */
    public static final org.bukkit.enchantments.Enchantment FIRE_ASPECT = getEnchantment("fire_aspect");

    /**
     * Provides a chance of gaining extra loot when killing monsters
     */
    public static final org.bukkit.enchantments.Enchantment LOOT_BONUS_MOBS = getEnchantment("looting");

    /**
     * Increases damage against targets when using a sweep attack
     */
    public static final org.bukkit.enchantments.Enchantment SWEEPING_EDGE = getEnchantment("sweeping");

    /**
     * Increases the rate at which you mine/dig
     */
    public static final org.bukkit.enchantments.Enchantment DIG_SPEED = getEnchantment("efficiency");

    /**
     * Allows blocks to drop themselves instead of fragments (for example,
     * stone instead of cobblestone)
     */
    public static final org.bukkit.enchantments.Enchantment SILK_TOUCH = getEnchantment("silk_touch");

    /**
     * Decreases the rate at which a tool looses durability
     */
    public static final org.bukkit.enchantments.Enchantment DURABILITY = getEnchantment("unbreaking");

    /**
     * Provides a chance of gaining extra loot when destroying blocks
     */
    public static final org.bukkit.enchantments.Enchantment LOOT_BONUS_BLOCKS = getEnchantment("fortune");

    /**
     * Provides extra damage when shooting arrows from bows
     */
    public static final org.bukkit.enchantments.Enchantment ARROW_DAMAGE = getEnchantment("power");

    /**
     * Provides a knockback when an entity is hit by an arrow from a bow
     */
    public static final org.bukkit.enchantments.Enchantment ARROW_KNOCKBACK = getEnchantment("punch");

    /**
     * Sets entities on fire when hit by arrows shot from a bow
     */
    public static final org.bukkit.enchantments.Enchantment ARROW_FIRE = getEnchantment("flame");

    /**
     * Provides infinite arrows when shooting a bow
     */
    public static final org.bukkit.enchantments.Enchantment ARROW_INFINITE = getEnchantment("infinity");

    /**
     * Decreases odds of catching worthless junk
     */
    public static final org.bukkit.enchantments.Enchantment LUCK = getEnchantment("luck_of_the_sea");

    /**
     * Increases rate of fish biting your hook
     */
    public static final org.bukkit.enchantments.Enchantment LURE = getEnchantment("lure");

    /**
     * Causes a thrown trident to return to the player who threw it
     */
    public static final org.bukkit.enchantments.Enchantment LOYALTY = getEnchantment("loyalty");

    /**
     * Deals more damage to mobs that live in the ocean
     */
    public static final org.bukkit.enchantments.Enchantment IMPALING = getEnchantment("impaling");

    /**
     * When it is rainy, launches the player in the direction their trident is thrown
     */
    public static final org.bukkit.enchantments.Enchantment RIPTIDE = getEnchantment("riptide");

    /**
     * Strikes lightning when a mob is hit with a trident if conditions are
     * stormy
     */
    public static final org.bukkit.enchantments.Enchantment CHANNELING = getEnchantment("channeling");

    /**
     * Shoot multiple arrows from crossbows
     */
    public static final org.bukkit.enchantments.Enchantment MULTISHOT = getEnchantment("multishot");

    /**
     * Charges crossbows quickly
     */
    public static final org.bukkit.enchantments.Enchantment QUICK_CHARGE = getEnchantment("quick_charge");

    /**
     * Crossbow projectiles pierce entities
     */
    public static final org.bukkit.enchantments.Enchantment PIERCING = getEnchantment("piercing");

    /**
     * Allows mending the item using experience orbs
     */
    public static final org.bukkit.enchantments.Enchantment MENDING = getEnchantment("mending");

    /**
     * Item disappears instead of dropping
     */
    public static final org.bukkit.enchantments.Enchantment VANISHING_CURSE = getEnchantment("vanishing_curse");

    /**
     * Walk quicker on soul blocks
     */
    public static final org.bukkit.enchantments.Enchantment SOUL_SPEED = getEnchantment("soul_speed");

    /**
     * Walk quicker while sneaking
     */
    public static final org.bukkit.enchantments.Enchantment SWIFT_SNEAK = getEnchantment("swift_sneak");

    @NotNull
    private static org.bukkit.enchantments.Enchantment getEnchantment(@NotNull String key) {
        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        org.bukkit.enchantments.Enchantment enchantment = Registry.ENCHANTMENT.get(namespacedKey);

        Preconditions.checkNotNull(enchantment, "No Enchantment found for %s. This is a bug.", namespacedKey);

        return enchantment;
    }

    /**
     * Gets the unique name of this enchantment
     *
     * @return Unique name
     * @deprecated enchantments are badly named, use {@link #getKey()}.
     */
    @NotNull
    @Deprecated
    public abstract String getName();

    /**
     * Gets the maximum level that this Enchantment may become.
     *
     * @return Maximum level of the Enchantment
     */
    public abstract int getMaxLevel();

    /**
     * Gets the level that this Enchantment should start at
     *
     * @return Starting level of the Enchantment
     */
    public abstract int getStartLevel();

    /**
     * Gets the type of {@link ItemStack} that may fit this Enchantment.
     *
     * @return Target type of the Enchantment
     */
    @NotNull
    public abstract EnchantmentTarget getItemTarget();

    /**
     * Checks if this enchantment is a treasure enchantment.
     * <br>
     * Treasure enchantments can only be received via looting, trading, or
     * fishing.
     *
     * @return true if the enchantment is a treasure enchantment
     */
    public abstract boolean isTreasure();

    /**
     * Checks if this enchantment is a cursed enchantment
     * <br>
     * Cursed enchantments are found the same way treasure enchantments are
     *
     * @return true if the enchantment is cursed
     */
    public abstract boolean isCursed();

    /**
     * Check if this enchantment conflicts with another enchantment.
     *
     * @param other The enchantment to check against
     * @return True if there is a conflict.
     */
    public abstract boolean conflictsWith(@NotNull org.bukkit.enchantments.Enchantment other);

    /**
     * Checks if this Enchantment may be applied to the given {@link
     * ItemStack}.
     * <p>
     * This does not check if it conflicts with any enchantments already
     * applied to the item.
     *
     * @param item Item to test
     * @return True if the enchantment may be applied, otherwise False
     */
    public abstract boolean canEnchantItem(@NotNull ItemStack item);
    // Paper start
    /**
     * Get the name of the enchantment with its applied level.
     * <p>
     * If the given {@code level} is either less than the {@link #getStartLevel()} or greater than the {@link #getMaxLevel()},
     * the level may not be shown in the numeral format one may otherwise expect.
     * </p>
     *
     * @param level the level of the enchantment to show
     * @return the name of the enchantment with {@code level} applied
     */
    public abstract net.kyori.adventure.text.@NotNull Component displayName(int level);

    /**
     * Checks if this enchantment can be found in villager trades.
     *
     * @return true if the enchantment can be found in trades
     */
    public abstract boolean isTradeable();

    /**
     * Checks if this enchantment can be found in an enchanting table
     * or use to enchant items generated by loot tables.
     *
     * @return true if the enchantment can be found in a table or by loot tables
     */
    public abstract boolean isDiscoverable();

    /**
     * Gets the minimum modified cost of this enchantment at a specific level.
     * <p>
     * Note this is not the number of experience levels needed, and does not directly translate to the levels shown in an enchanting table.
     * This value is used in combination with factors such as tool enchantability to determine a final cost.
     * See <a href="https://minecraft.wiki/w/Enchanting/Levels">https://minecraft.wiki/w/Enchanting/Levels</a> for more information.
     * </p>
     * @param level The level of the enchantment
     * @return The modified cost of this enchantment
     */
    public abstract int getMinModifiedCost(int level);

    /**
     * Gets the maximum modified cost of this enchantment at a specific level.
     * <p>
     * Note this is not the number of experience levels needed, and does not directly translate to the levels shown in an enchanting table.
     * This value is used in combination with factors such as tool enchantability to determine a final cost.
     * See <a href="https://minecraft.wiki/w/Enchanting/Levels">https://minecraft.wiki/w/Enchanting/Levels</a> for more information.
     * </p>
     * @param level The level of the enchantment
     * @return The modified cost of this enchantment
     */
    public abstract int getMaxModifiedCost(int level);

    /**
     * Gets the rarity of this enchantment.
     *
     * @return the rarity
     */
    @NotNull
    public abstract io.papermc.paper.enchantments.EnchantmentRarity getRarity();

    /**
     * Gets the damage increase as a result of the level and entity category specified
     *
     * @param level the level of enchantment
     * @param entityCategory the category of entity
     * @return the damage increase
     */
    public abstract float getDamageIncrease(int level, @NotNull org.bukkit.entity.EntityCategory entityCategory);

    /**
     * Gets the equipment slots where this enchantment is considered "active".
     *
     * @return the equipment slots
     */
    @NotNull
    public abstract java.util.Set<org.bukkit.inventory.EquipmentSlot> getActiveSlots();
    // Paper end

    /**
     * Gets the Enchantment at the specified key
     *
     * @param key key to fetch
     * @return Resulting Enchantment, or null if not found
     * @deprecated only for backwards compatibility, use {@link Registry#get(NamespacedKey)} instead
     */
    @Contract("null -> null")
    @Nullable
    @Deprecated
    public static org.bukkit.enchantments.Enchantment getByKey(@Nullable NamespacedKey key) {
        if (key == null) {
            return null;
        }
        return Registry.ENCHANTMENT.get(key);
    }

    /**
     * Gets the Enchantment at the specified name
     *
     * @param name Name to fetch
     * @return Resulting Enchantment, or null if not found
     * @deprecated enchantments are badly named, use {@link #getByKey(org.bukkit.NamespacedKey)}.
     */
    @Deprecated
    @Contract("null -> null")
    @Nullable
    public static org.bukkit.enchantments.Enchantment getByName(@Nullable String name) {
        if (name == null) {
            return null;
        }

        name = convertLegacy(name);
        return getByKey(NamespacedKey.fromString(name.toLowerCase()));
    }

    /**
     * Gets an array of all the registered {@link org.bukkit.enchantments.Enchantment}s
     *
     * @return Array of enchantments
     * @deprecated use {@link Registry#iterator()}
     */
    @NotNull
    @Deprecated
    public static org.bukkit.enchantments.Enchantment[] values() {
        return Lists.newArrayList(Registry.ENCHANTMENT).toArray(new org.bukkit.enchantments.Enchantment[0]);
    }

    private static String convertLegacy(String from) {
        if (from == null) {
            return null;
        }

        switch (from.toLowerCase()) {
            case "protection_environmental":
                return "protection";
            case "protection_fire":
                return "fire_protection";
            case "protection_fall":
                return "feather_falling";
            case "protection_explosions":
                return "blast_protection";
            case "protection_projectile":
                return "projectile_protection";
            case "oxygen":
                return "respiration";
            case "water_worker":
                return "aqua_affinity";
            case "damage_all":
                return "sharpness";
            case "damage_undead":
                return "smite";
            case "damage_arthropods":
                return "bane_of_arthropods";
            case "loot_bonus_mobs":
                return "looting";
            case "sweeping_edge":
                return "sweeping";
            case "dig_speed":
                return "efficiency";
            case "durability":
                return "unbreaking";
            case "loot_bonus_blocks":
                return "fortune";
            case "arrow_damage":
                return "power";
            case "arrow_knockback":
                return "punch";
            case "arrow_fire":
                return "flame";
            case "arrow_infinite":
                return "infinity";
            case "luck":
                return "luck_of_the_sea";
        }

        return from;
    }
}