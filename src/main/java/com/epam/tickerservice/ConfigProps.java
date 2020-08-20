package com.epam.tickerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/*@Configuration*/
@ConfigurationProperties(prefix = "mail")
public class ConfigProps {
    private String hostName;
    private String port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private Credentials credentials;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getDefaultRecipients() {
        return defaultRecipients;
    }

    public void setDefaultRecipients(List<String> defaultRecipients) {
        this.defaultRecipients = defaultRecipients;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
