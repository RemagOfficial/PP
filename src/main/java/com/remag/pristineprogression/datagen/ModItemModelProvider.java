package com.remag.pristineprogression.datagen;

import com.remag.pristineprogression.PristineProgression;
import com.remag.pristineprogression.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PristineProgression.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            simpleItem(item);
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PristineProgression.MODID, "item/" + item.getId().getPath()));
    }
}
