package buzz.blobanium.enhancedpacketcompression.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigReader {
    public static final Logger LOGGER = LogManager.getLogger("EnhancedPacketCompression - Config");
    //variables
    public static boolean needsConfigRefresh = false;
    public static boolean refreshingConfig = false;

    //configs
    public static boolean enabled = true;
    public static int packetCompressionLevel = 2;
    public static boolean logPacketExceptions = false;

    public static void configRegister(boolean initialize){
        LOGGER.debug("Registering config..");
        SimpleConfig CONFIG = SimpleConfig.of("enhancedpacketcompression").provider(ConfigReader::ltProvider).request();

        if(initialize) {
            enabled = CONFIG.getOrDefault("enabled", enabled);
            packetCompressionLevel = CONFIG.getOrDefault("packet_compression_level", packetCompressionLevel);
            logPacketExceptions = CONFIG.getOrDefault("log_packet_exceptions", logPacketExceptions);
        }

        LOGGER.debug("Regestering done!");
    }

    private static String ltProvider(String filename) {
        return "#Enhanced Packet Compression Config File."
                + "\nenabled=" + enabled
                + "\npacket_compression_level=" + packetCompressionLevel
                + "\nlog_packet_exceptions=" + logPacketExceptions;

    }
}