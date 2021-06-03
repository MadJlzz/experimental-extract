package com.nextgatetech.gcrdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "application.engines")
public class EngineProps {

    private Map<String, SFTPEngineProps> sftp;

    private Map<String, CrawlerEngineProps> crawler;

}
