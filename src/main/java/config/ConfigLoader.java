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
                System.out.println(
                        "config.properties not found, fallback to env variables");
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot load config.properties", e);
        }
    }

    public static String get(String key) {
        // Env vars
        String envVar = System.getenv(key.toUpperCase().replace('.', '_'));
        if (envVar != null && !envVar.isEmpty()) return envVar;

        // System properties (Jenkins -D)
        String sysProp = System.getProperty(key);
        if (sysProp != null && !sysProp.isEmpty()) return sysProp;

        // Config file
        return props.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

}
