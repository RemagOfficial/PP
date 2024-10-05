package com.remag.pristineprogression.tab;

import com.remag.pristineprogression.PristineProgression;
import com.remag.pristineprogression.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PristineProgression.MODID);

    public static final List<Supplier<? extends ItemLike>> PP_TABS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> PP_TAB = TABS.register("pp_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.pp_tab"))
                    .icon(ModItems.MASTER_BLANK_DATA_MODEL.get().asItem()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            PP_TABS.stream()
                                    .flatMap(itemLike -> stacksForItem(itemLike.get()))
                                    .forEach(output::accept))
                    .build()
    );

    private static Stream<ItemStack> stacksForItem(ItemLike item) {
        ItemStack stack = new ItemStack(item);
        return Stream.of(stack);
    }

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        PP_TABS.add(itemLike);
        return itemLike;
    }
}
