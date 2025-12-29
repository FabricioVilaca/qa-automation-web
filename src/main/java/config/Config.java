package config;

public class Config {

    private Config() {}

    public static String baseurl() {
        return ConfigLoader.get("base.url");
    }

    public static int timeout() {
        String val = ConfigLoader.get("timeout");
        return Integer.parseInt(val);
    }

    public static String stadardUser() {
        return ConfigLoader.get("user.name");
    }

    public static String standardPassword() {
        return ConfigLoader.get("user.password");
    }

}
