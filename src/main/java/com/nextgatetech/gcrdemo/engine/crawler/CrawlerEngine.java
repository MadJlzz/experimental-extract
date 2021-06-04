package com.nextgatetech.gcrdemo.engine.crawler;

import com.nextgatetech.gcrdemo.engine.Engine;
import com.nextgatetech.gcrdemo.engine.ExtractionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CrawlerEngine implements Engine {

    private final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);

    private final String url;

    public CrawlerEngine(final String url) {
        this.url = url;
    }

    @Override
    public List<ExtractionResult> extract() {
        logger.info(String.format("Extracting data from URL [%s]", this.url));
        final RestTemplate client = new RestTemplate();
        final byte[] data = client.execute(
                this.url,
                HttpMethod.GET,
                null,
                clientHttpResponse -> StreamUtils.copyToByteArray(clientHttpResponse.getBody())
        );
        final String filename = this.url.substring(this.url.lastIndexOf('/') + 1);
        return Collections.singletonList(new ExtractionResult(filename, data));
    }

}
