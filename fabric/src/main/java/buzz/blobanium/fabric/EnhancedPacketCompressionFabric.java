package buzz.blobanium.fabric;

import buzz.blobanium.enhancedpacketcompression.EnhancedPacketCompression;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class EnhancedPacketCompressionFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        EnhancedPacketCompression.configDir = FabricLoader.getInstance().getConfigDir();
        EnhancedPacketCompression.init();
    }
}
