package net.kayn.fallen_gems_affixes.loot;

import dev.shadowsoffire.apotheosis.adventure.loot.LootCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;

public class GunLootCategory {

    public static final LootCategory GUN;

    static {
        if (ModList.get().isLoaded("scguns")) {
            GUN = LootCategory.register(
                    LootCategory.SWORD,
                    "gun",
                    GunLootCategory::isGunItem,
                    new EquipmentSlot[]{EquipmentSlot.MAINHAND}
            );
        } else {
            GUN = null;
        }
    }

    private static boolean isGunItem(ItemStack stack) {
        try {
            return stack.getItem() instanceof top.ribs.scguns.item.GunItem;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean isGun(ItemStack stack) {
        return GUN != null && LootCategory.forItem(stack).equals(GUN);
    }
}
