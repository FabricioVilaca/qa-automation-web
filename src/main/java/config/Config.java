package config;

public class Config {

    private Config() {}

    //public static final String BASE_URL = ConfigLoader.get("base.url");
    //public static final int TIMEOUT = ConfigLoader.getInt("timeout");

    public static String getBaseurl() {
        String val = ConfigLoader.get("base.url");
        if (val == null || val.isEmpty()) {
            return "https://www.saucedemo.com"; // default
        }
        return val;
    }

    public static int getTimeout() {
        String val = ConfigLoader.get("timeout");
        if (val == null || val.isEmpty()) {
            return 10; // default
        }
        return Integer.parseInt(val);
    }

}
