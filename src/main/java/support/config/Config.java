package support.config;

import org.aeonbits.owner.ConfigCache;

import java.util.ArrayList;
import java.util.Collection;

public class Config {

    private boolean headLess;
    private String browser;
    private String env;
    private Configuration propsEnv;

    public Config() {
        this.setPropsEnv(ConfigCache.getOrCreate(Configuration.class));
        this.setHeadLess(Boolean.parseBoolean(System.getProperty("headless")));
        this.setBrowser(System.getProperty("browser"));
        this.setEnv(System.getProperty("env"));
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public boolean getHeadLess() {
        return headLess;
    }

    public void setHeadLess(boolean headLess) {
        this.headLess = headLess;
    }

    public Configuration getPropsEnv() {
        return propsEnv;
    }

    public void setPropsEnv(Configuration propsEnv) {
        this.propsEnv = propsEnv;
    }
}
