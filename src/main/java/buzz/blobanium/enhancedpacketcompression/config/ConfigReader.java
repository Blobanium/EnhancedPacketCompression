package buzz.blobanium.enhancedpacketcompression.config;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;


public class ConfigReader {
    public static final Logger LOGGER = LogManager.getLogger("EnhancedPacketCompression - Config");
    //variables
    public static boolean needsConfigRefresh = false;
    public static boolean refreshingConfig = false;

    //configs
    public static int packetCompressionLevel = 2;

    public static void configRegister(boolean initialize){
        LOGGER.debug("Registering config..");
        SimpleConfig CONFIG = SimpleConfig.of("enhancedpacketcompression").provider(ConfigReader::ltProvider).request();

        if(initialize) {
            packetCompressionLevel = CONFIG.getOrDefault("packet_compression_level", packetCompressionLevel);
        }

        LOGGER.debug("Regestering done!");
    }

    private static String ltProvider(String filename) {
        return "#Enhanced Packet Compression Config File."
                + "\npacket_compression_level=" + packetCompressionLevel;

    }

    public static void refreshConfig(){
        if(needsConfigRefresh) {
            refreshingConfig = true;
            try {
                if (!Files.deleteIfExists(FabricLoader.getInstance().getConfigDir().resolve("MineclubExpanded.properties"))) {
                    LOGGER.error("Config file not found. Please ensure the path to the config is correct.\n" + FabricLoader.getInstance().getConfigDir().resolve("LoadingTimer.properties"));
                }
            } catch (IOException e) {
                LOGGER.fatal("Config Refresh Failed due to a IOException, please report this on our issues thread.", e);
            }
            configRegister(false);
            refreshingConfig = false;
        }
    }

    public static void onConfigSave(){
        needsConfigRefresh = true;
    }
}