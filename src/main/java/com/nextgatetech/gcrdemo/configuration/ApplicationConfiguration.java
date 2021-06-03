package com.nextgatetech.gcrdemo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({EngineProps.class})
public class ApplicationConfiguration {
}
