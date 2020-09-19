package com.epam.tickerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "test")
public class MapProperties {
    Map<String, String> comp;

    public Map<String, String> getComp() {
        return comp;
    }

    public void setComp(Map<String, String> comp) {
        this.comp = comp;
    }
}
