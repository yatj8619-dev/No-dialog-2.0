package dev.nodialog.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.dialog.DialogScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Last line of defence: no dialog screen can ever be displayed, whatever opened it. */
@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    private void nodialog$blockDialogScreens(Screen screen, CallbackInfo ci) {
        if (screen instanceof DialogScreen<?>) {
            ci.cancel();
        }
    }
}
