package utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class Config {

    public static String jsonFilePath = "data/config.json";
    public static File jsonFile = new File(jsonFilePath);
    public static String DeviceName;
    public static String DeviceUDID;
    public static String DeviceOSVersion;
    public static String DevicePlatform;
    public static String AppiumServerURL;
    public static String BuildPath;

    static {
        Map<?, ?> configList = null;
        if (jsonFile.exists()) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader reader = new FileReader(jsonFilePath))
            {
                //Read JSON file
                Object obj = jsonParser.parse(reader);

                configList = (Map<?, ?>) obj;

            } catch (IOException | ParseException e) {
                throw new RuntimeException("Could not parse the config.json file");
            }
        } else
            throw new RuntimeException("config.json file not found under data folder");
        BuildPath = (String) configList.get("buildPath");
        DeviceUDID = (String) configList.get("deviceUDID");
        DevicePlatform = (String) configList.get("devicePlatform");
        DeviceOSVersion = (String) configList.get("deviceOSVersion");
        DeviceName = (String) configList.get("deviceName");
        AppiumServerURL = (String) configList.get("appiumServerURL");

    }

}
