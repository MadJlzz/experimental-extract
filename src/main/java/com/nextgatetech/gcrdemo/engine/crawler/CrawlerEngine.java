package com.nextgatetech.gcrdemo.engine.crawler;

import com.nextgatetech.gcrdemo.engine.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

public class CrawlerEngine implements Engine {

    private final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);

    private final String url;

    public CrawlerEngine(final String url) {
        this.url = url;
    }

    @Override
    public byte[] extract() {
        logger.info(String.format("Extracting data from URL [%s]", this.url));
        final RestTemplate client = new RestTemplate();
        return client.execute(this.url, HttpMethod.GET, null, clientHttpResponse -> {
            return StreamUtils.copyToByteArray(clientHttpResponse.getBody());
        });
    }

}
