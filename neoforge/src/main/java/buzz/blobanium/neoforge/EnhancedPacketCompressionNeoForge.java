package buzz.blobanium.neoforge;

import buzz.blobanium.enhancedpacketcompression.EnhancedPacketCompression;
import net.minecraft.client.MinecraftClient;
import net.neoforged.fml.common.Mod;

@Mod(EnhancedPacketCompressionNeoForge.MOD_ID)
public final class EnhancedPacketCompressionNeoForge {
    public static final String MOD_ID = "enhancedpacketcompression";

    public EnhancedPacketCompressionNeoForge() {
        // Run our common setup.
        EnhancedPacketCompression.configDir = MinecraftClient.getInstance().runDirectory.toPath().resolve("config").toAbsolutePath();
        System.out.println(EnhancedPacketCompression.configDir);
        EnhancedPacketCompression.init();
    }
}
