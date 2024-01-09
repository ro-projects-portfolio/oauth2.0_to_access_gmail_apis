package utils;

import java.util.Properties;

/**
 * Singleton utility class for loading configuration properties from a configuration file.
 * @see PropertyUtil
 */
public class ConfigurationLoader {
    private final Properties properties;
    private static ConfigurationLoader configurationLoader;

    /**
     * Private constructor to enforce Singleton pattern and initialize properties from the configuration file.
     */
    private ConfigurationLoader(){
        properties = PropertyUtil.propertyLoader("src/test/resources/configuration.properties");
    }

    /**
     * Check If no instance exists and create a new one.
     *
     * @return The {@link ConfigurationLoader} instance.
     */
    public static ConfigurationLoader getInstance(){
        if(configurationLoader == null)
            configurationLoader = new ConfigurationLoader();
        return configurationLoader;
    }

    public String getGmailApiBaseUri(){
        String prop = properties.getProperty("GMAIL_API_BASE_URI");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property GMAIL_API_BASE_URI is not specified in the configuration.properties file");
    }
    public String getAccountBaseUri(){
        String prop = properties.getProperty("ACCOUNT_BASE_URI");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property ACCOUNT_BASE_URI is not specified in the configuration.properties file");
    }
    public String getUserId(){
        String prop = properties.getProperty("USER_ID");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property USER_ID is not specified in the configuration.properties file");
    }

    public String getClientId(){
        String prop = properties.getProperty("CLIENT_ID");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property CLIENT_ID is not specified in the configuration.properties file");
    }

    public String getClientSecret(){
        String prop = properties.getProperty("CLIENT_SECRET");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property CLIENT_SECRET is not specified in the configuration.properties file");
    }

    public String getGrantType(){
        String prop = properties.getProperty("GRANT_TYPE");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property GRANT_TYPE is not specified in the configuration.properties file");
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("REFRESH_TOKEN");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("property REFRESH_TOKEN is not specified in the configuration.properties file");
    }
}
