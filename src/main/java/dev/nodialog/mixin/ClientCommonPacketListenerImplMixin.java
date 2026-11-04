package dev.nodialog.mixin;

import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Stops dialogs from server packets, chat click events and quick actions before a screen is even built. */
@Mixin(ClientCommonPacketListenerImpl.class)
public abstract class ClientCommonPacketListenerImplMixin {
    @Inject(method = "showDialog", at = @At("HEAD"), cancellable = true)
    private void nodialog$blockShowDialog(CallbackInfo ci) {
        ci.cancel();
    }
}
