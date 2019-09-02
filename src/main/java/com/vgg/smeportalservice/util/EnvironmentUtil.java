package com.vgg.smeportalservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class EnvironmentUtil {

    @Autowired
    private Environment environment;

    public boolean isTestEnvironment() {
        return Arrays.asList(environment.getActiveProfiles()).contains("test");
    }

    public boolean isStagingEnvironment() {
        return Arrays.asList(environment.getActiveProfiles()).contains("staging");
    }

    public boolean isDevelopmentEnvironment() { return Arrays.asList(environment.getActiveProfiles()).contains("development"); }

    public boolean isProductionEnvironment() { return Arrays.asList(environment.getActiveProfiles()).contains("production"); }
}
