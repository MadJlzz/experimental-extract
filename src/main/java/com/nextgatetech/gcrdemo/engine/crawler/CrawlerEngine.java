package com.nextgatetech.gcrdemo.engine.crawler;

import com.nextgatetech.gcrdemo.engine.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrawlerEngine implements Engine {

    private final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);

    private final String url;

    public CrawlerEngine(final String url) {
        this.url = url;
    }

    @Override
    public void extract() {
        logger.info(String.format("Extracting data from URL [%s]", this.url));
    }

}
