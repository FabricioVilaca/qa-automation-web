package config;

public class Config {

    public static final String BASE_URL = ConfigLoader.get("base.url");

    public static final int TIMEOUT = ConfigLoader.getInt("timeout");

    private Config() {}

}
