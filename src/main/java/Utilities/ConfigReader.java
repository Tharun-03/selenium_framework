package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    // STATIC BLOCK — automatically runs when class loads
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/ConfigProperties/QA.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
