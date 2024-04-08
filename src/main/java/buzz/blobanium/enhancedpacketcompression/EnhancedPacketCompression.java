package buzz.blobanium.enhancedpacketcompression;

import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import net.fabricmc.api.ModInitializer;

public class EnhancedPacketCompression implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigReader.configRegister(true);
    }
}
