package com.epam.tickerservice;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "conversion")
public class PropertyConversion {

    private Duration timeInDefaultUnit;
    private Duration timeInNano;
    private Duration timeInDays;

    public Duration getTimeInDays() {
        return timeInDays;
    }

    public void setTimeInDays(Duration timeInDays) {
        this.timeInDays = timeInDays;
    }

    public Duration getTimeInDefaultUnit() {
        return timeInDefaultUnit;
    }

    public void setTimeInDefaultUnit(Duration timeInDefaultUnit) {
        this.timeInDefaultUnit = timeInDefaultUnit;
    }

    public Duration getTimeInNano() {
        return timeInNano;
    }

    public void setTimeInNano(Duration timeInNano) {
        this.timeInNano = timeInNano;
    }
}
