package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties props = new Properties();

    static {
        try (InputStream is =
                     ConfigLoader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (is != null) {
                props.load(is);
            } else {
                System.out.println("config.properties not found, fallback to env variables");
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot load config.properties", e);
        }
    }

    public static String get(String key) {

        // Local config.properties
        String prop = props.getProperty(key);
        if (prop != null && !prop.isEmpty()) return prop;

        // Env var (CI)
        String envVar = System.getenv(key.toUpperCase().replace('.', '_'));
        if (envVar != null && !envVar.isEmpty()) return envVar;

        // System property (-D)
        String sysProp = System.getProperty(key);
        if (sysProp != null && !sysProp.isEmpty()) return sysProp;

        throw new IllegalArgumentException("Property '" + key + "' not set in any source!");
    }

}
