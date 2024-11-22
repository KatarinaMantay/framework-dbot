package dev.kataray.discord.util;

import javax.annotation.Nullable;

public class Util {

    @Nullable
    public static String getFromEnvironment(String key) {
        String value = System.getenv(key);
        if (value == null) {
            value = System.getProperty(key);
        }
        return value;
    }
}
