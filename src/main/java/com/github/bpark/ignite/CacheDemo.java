package com.github.bpark.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

public class CacheDemo {

    public static void main(String[] args) {

        System.setProperty("IGNITE_QUIET", "false");

        try (Ignite ignite = Ignition.start("src/main/resources/ignite.xml")) {
            IgniteCache<String, String> testCache = ignite.getOrCreateCache("test");
            testCache.put("1", "Hello");
            System.out.println(testCache.get("1"));
        }
    }
}
