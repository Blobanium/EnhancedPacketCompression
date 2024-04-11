package buzz.blobanium.enhancedpacketcompression.mixin;

import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.handler.PacketDeflater;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.zip.Deflater;

@Mixin(PacketDeflater.class)
public class PacketDeflaterMixin {
    @Shadow @Final private Deflater deflater;

    @Inject(at = @At(value = "INVOKE", target = "Ljava/util/zip/Deflater;setInput([BII)V"), method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V")
    private void beforeCompress(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2, CallbackInfo ci){
        this.deflater.setLevel(ConfigReader.packetCompressionLevel);
    }

    @Inject(at = @At(value = "INVOKE", target = "Ljava/util/zip/Deflater;reset()V"), method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V")
    private void afterCompress(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2, CallbackInfo ci){
        //This mixin is reserved for future usage.
    }
}
