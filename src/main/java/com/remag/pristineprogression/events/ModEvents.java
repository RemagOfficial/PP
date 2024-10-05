package com.remag.pristineprogression.events;

import com.mojang.logging.LogUtils;
import com.remag.pristineprogression.PristineProgression;
import com.remag.pristineprogression.item.ModItems;
import dev.shadowsoffire.hostilenetworks.Hostile;
import dev.shadowsoffire.hostilenetworks.HostileConfig;
import dev.shadowsoffire.hostilenetworks.data.DataModel;
import dev.shadowsoffire.hostilenetworks.data.DataModelRegistry;
import dev.shadowsoffire.hostilenetworks.item.DataModelItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PristineProgression.MODID)
public class ModEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void modelAttunement(PlayerInteractEvent.EntityInteractSpecific e) {
        if (!HostileConfig.rightClickToAttune) return;
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());
        if (stack.getItem() == Hostile.Items.BLANK_DATA_MODEL.get()) {
            if (!player.level().isClientSide) {
                DataModel model = DataModelRegistry.INSTANCE.getForEntity(e.getTarget().getType());
                if (model == null) {
                    Component msg = Component.translatable("hostilenetworks.msg.no_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                if (stack.is(Hostile.Items.BLANK_DATA_MODEL.get())) {
                    e.setCanceled(true);
                    e.setCancellationResult(InteractionResult.PASS);
                }

                if (model.baseDrop().getItem() == Hostile.Items.NETHER_PREDICTION.get() || model.baseDrop().getItem() == Hostile.Items.END_PREDICTION.get()) {
                    Component msg = Component.translatable("pristineprogression.msg.overworld_blank_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                Component msg = Component.translatable("hostilenetworks.msg.built", model.name()).withStyle(ChatFormatting.GOLD);
                player.sendSystemMessage(msg);

                ItemStack modelStack = new ItemStack(Hostile.Items.DATA_MODEL.get());
                DataModelItem.setStoredModel(modelStack, model);
                player.setItemInHand(e.getHand(), modelStack);
            }
            e.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void modelAttunementNether(PlayerInteractEvent.EntityInteractSpecific e) {
        if (!HostileConfig.rightClickToAttune) return;
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());
        if (stack.getItem() == ModItems.NETHER_BLANK_DATA_MODEL.get()) {
            if (!player.level().isClientSide) {
                DataModel model = DataModelRegistry.INSTANCE.getForEntity(e.getTarget().getType());
                if (model == null) {
                    Component msg = Component.translatable("hostilenetworks.msg.no_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                if (model.baseDrop().getItem() == Hostile.Items.OVERWORLD_PREDICTION.get() || model.baseDrop().getItem() == Hostile.Items.END_PREDICTION.get()) {
                    Component msg = Component.translatable("pristineprogression.msg.nether_blank_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                Component msg = Component.translatable("hostilenetworks.msg.built", model.name()).withStyle(ChatFormatting.GOLD);
                player.sendSystemMessage(msg);

                ItemStack modelStack = new ItemStack(Hostile.Items.DATA_MODEL.get());
                DataModelItem.setStoredModel(modelStack, model);
                player.setItemInHand(e.getHand(), modelStack);
            }
            e.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void modelAttunementEnd(PlayerInteractEvent.EntityInteractSpecific e) {
        if (!HostileConfig.rightClickToAttune) return;
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());
        if (stack.getItem() == ModItems.END_BLANK_DATA_MODEL.get()) {
            if (!player.level().isClientSide) {
                DataModel model = DataModelRegistry.INSTANCE.getForEntity(e.getTarget().getType());
                if (model == null) {
                    Component msg = Component.translatable("hostilenetworks.msg.no_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                if (model.baseDrop().getItem() == Hostile.Items.OVERWORLD_PREDICTION.get() || model.baseDrop().getItem() == Hostile.Items.NETHER_PREDICTION.get()) {
                    Component msg = Component.translatable("pristineprogression.msg.end_blank_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                Component msg = Component.translatable("hostilenetworks.msg.built", model.name()).withStyle(ChatFormatting.GOLD);
                player.sendSystemMessage(msg);

                ItemStack modelStack = new ItemStack(Hostile.Items.DATA_MODEL.get());
                DataModelItem.setStoredModel(modelStack, model);
                player.setItemInHand(e.getHand(), modelStack);
            }
            e.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public static void modelAttunementMaster(PlayerInteractEvent.EntityInteractSpecific e) {
        if (!HostileConfig.rightClickToAttune) return;
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());
        if (stack.getItem() == ModItems.MASTER_BLANK_DATA_MODEL.get()) {
            if (!player.level().isClientSide) {
                DataModel model = DataModelRegistry.INSTANCE.getForEntity(e.getTarget().getType());
                if (model == null) {
                    Component msg = Component.translatable("hostilenetworks.msg.no_model").withStyle(ChatFormatting.RED);
                    player.sendSystemMessage(msg);
                    return;
                }

                Component msg = Component.translatable("hostilenetworks.msg.built", model.name()).withStyle(ChatFormatting.GOLD);
                player.sendSystemMessage(msg);

                ItemStack modelStack = new ItemStack(Hostile.Items.DATA_MODEL.get());
                DataModelItem.setStoredModel(modelStack, model);
                player.setItemInHand(e.getHand(), modelStack);
            }
            e.setResult(Event.Result.DENY);
        }
    }
}
