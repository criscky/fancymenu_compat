package com.criscky.fancymenucompat.mixin;

import com.betterinvisibility.InvisibleHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.util.FakePlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InvisibleHandler.class)
public class BetterInvis {
    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(at = @At("HEAD"), method = "Lcom/betterinvisibility/InvisibleHandler;turnMobsInvisible(Lnet/minecraftforge/client/event/RenderLivingEvent$Pre;)V",remap = false, cancellable = true)
    private void turnMobsInvisible_mixin(RenderLivingEvent.Pre event, CallbackInfo ci) {
        //LOGGER.info("Trying log spam better invi entity: "+ Minecraft.getInstance().player);
        if(Minecraft.getInstance().player == null){
            ci.cancel();
        }

    }
}
