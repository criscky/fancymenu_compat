package com.criscky.fancymenucompat.mixin;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.util.FakePlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yesman.epicfight.client.events.engine.RenderEngine;

@Mixin(RenderEngine.Events.class)
public class EpicFight {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(at = @At("HEAD"), method = "Lyesman/epicfight/client/events/engine/RenderEngine$Events;renderLivingEvent(Lnet/minecraftforge/client/event/RenderLivingEvent$Pre;)V",remap = false, cancellable = true)
    private static void renderLivingEvent_mixin(RenderLivingEvent.Pre<? extends LivingEntity, ? extends EntityModel<? extends LivingEntity>> event, CallbackInfo ci) {
        //LOGGER.info("Trying log spam epicfight" + Minecraft.getInstance().player);
        if(Minecraft.getInstance().player == null){
            ci.cancel();
        }
    }

}
