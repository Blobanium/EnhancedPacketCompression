package buzz.blobanium.enhancedpacketcompression;

import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnhancedPacketCompression{
    public static final Logger LOGGER = LogManager.getLogger("EnhancedPacketCompression");

    public static void init() {
        ConfigReader.configRegister(true);
        LOGGER.info("EnhancedPacketCompression initialized");
    }
}
