package net.akliz.timbrmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TIMBR_TAB = new CreativeModeTab("timbrtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATE.get());
        }
    };
}
