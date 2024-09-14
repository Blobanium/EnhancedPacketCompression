package buzz.blobanium.neoforge;

import buzz.blobanium.enhancedpacketcompression.EnhancedPacketCompression;
import net.neoforged.fml.common.Mod;

@Mod(EnhancedPacketCompressionNeoForge.MOD_ID)
public final class EnhancedPacketCompressionNeoForge {
    public static final String MOD_ID = "enhancedpacketcompression";

    public EnhancedPacketCompressionNeoForge() {
        // Run our common setup.
        EnhancedPacketCompression.init();
    }
}
