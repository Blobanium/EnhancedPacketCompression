package buzz.blobanium.enhancedpacketcompression;

import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancedPacketCompression implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("EnhancedPacketCompression");

    @Override
    public void onInitialize() {
        ConfigReader.configRegister(true);
        LOGGER.info("EnhancedPacketCompression initialized");
    }
}
