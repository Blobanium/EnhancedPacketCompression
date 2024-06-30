package buzz.blobanium.enhancedpacketcompression.mixin;

import buzz.blobanium.enhancedpacketcompression.EnhancedPacketCompression;
import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    @Inject(at = @At("HEAD"), method = "exceptionCaught")
    private void exceptionCaught(ChannelHandlerContext context, Throwable ex, CallbackInfo ci) {
        if(ConfigReader.logPacketExceptions){
            EnhancedPacketCompression.LOGGER.error("Exception caught", ex);
        }
    }
}
