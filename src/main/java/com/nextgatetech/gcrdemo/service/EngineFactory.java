package com.nextgatetech.gcrdemo.service;

import com.nextgatetech.gcrdemo.configuration.CrawlerEngineProps;
import com.nextgatetech.gcrdemo.configuration.EngineProps;
import com.nextgatetech.gcrdemo.configuration.SFTPEngineProps;
import com.nextgatetech.gcrdemo.service.crawler.CrawlerEngine;
import com.nextgatetech.gcrdemo.service.sftp.SFTPEngine;

import java.util.Optional;

public class EngineFactory {

    private final EngineProps engineProps;

    public EngineFactory(final EngineProps engineProps) {
        this.engineProps = engineProps;
    }

    public Engine getEngine(final EngineType type, final String client) {
        switch (type) {
            case CRAWLER:
                final CrawlerEngineProps crawlerProps = Optional.ofNullable(this.engineProps.getCrawler().get(client)).orElseThrow();
                return new CrawlerEngine(crawlerProps.getUrl());
            case SFTP:
                final SFTPEngineProps sftpProps = Optional.ofNullable(this.engineProps.getSftp().get(client)).orElseThrow();
                return new SFTPEngine(sftpProps.getHostname(), sftpProps.getUser(), sftpProps.getPort());
            default:
                throw new UnknownEngineException(type);
        }
    }

}
