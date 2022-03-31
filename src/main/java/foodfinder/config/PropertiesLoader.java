package foodfinder.config;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static final String PROPERTIES_FILE_NAME = "application.properties";
    
    public static Properties load(){
        Properties properties = new Properties();
        InputStream inputStream = new PropertiesLoader()
                .getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return properties;
    }
}
