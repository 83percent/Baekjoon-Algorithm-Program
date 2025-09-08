package com.algorithm.common.component;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Properties props;

    static {
        props = new Properties();
        try {
            InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream("config/config.properties");
            props.load(inputStream);
        } catch(Exception e) {
            throw new RuntimeException("Fail to load config properties.");
        }
    }

    /**
     * <pre>Property 값 조회</pre>
     * @param property property 명
     * @return value of setting property
     */
    public static String get(String property) {
        return props.getProperty(property);
    }


}
