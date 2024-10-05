package com.remag.pristineprogression.item;

import com.remag.pristineprogression.PristineProgression;
import dev.shadowsoffire.hostilenetworks.item.BlankDataModelItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.remag.pristineprogression.tab.ModCreativeModeTab.addToTab;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, PristineProgression.MODID);

    public static final RegistryObject<Item> NETHER_BLANK_DATA_MODEL = addToTab(ITEMS.register("nether_blank_data_model",
            () -> new BlankDataModelItem(new Item.Properties())));

    public static final RegistryObject<Item> END_BLANK_DATA_MODEL = addToTab(ITEMS.register("end_blank_data_model",
            () -> new BlankDataModelItem(new Item.Properties())));

    public static final RegistryObject<Item> MASTER_BLANK_DATA_MODEL = addToTab(ITEMS.register("master_blank_data_model",
            () -> new BlankDataModelItem(new Item.Properties())));

    public static final RegistryObject<Item> HOSTILE_OVERWORLD_PREDICTION = addToTab(ITEMS.register("hostile_overworld_prediction",
            () -> new Item(new Item.Properties())));

    public static final RegistryObject<Item> PASSIVE_OVERWORLD_PREDICTION = addToTab(ITEMS.register("passive_overworld_prediction",
            () -> new Item(new Item.Properties())));


}
