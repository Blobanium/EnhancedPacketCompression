package buzz.blobanium.enhancedpacketcompression;

import buzz.blobanium.enhancedpacketcompression.config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

public class EnhancedPacketCompression{
    public static final Logger LOGGER = LogManager.getLogger("EnhancedPacketCompression");

    public static Path configDir;

    public static void init() {
        System.out.println(configDir);
        ConfigReader.configRegister(true);
        LOGGER.info("EnhancedPacketCompression initialized");
    }
}
