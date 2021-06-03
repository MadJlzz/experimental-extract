package com.nextgatetech.gcrdemo.engine.crawler;

import com.nextgatetech.gcrdemo.engine.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;

public class CrawlerEngine implements Engine {

    private final Logger logger = LoggerFactory.getLogger(CrawlerEngine.class);

    private final String url;

    public CrawlerEngine(final String url) {
        this.url = url;
    }

    @Override
    public void extract() {
        logger.info(String.format("Extracting data from URL [%s]", this.url));
        final RestTemplate client = new RestTemplate();
        File file = client.execute(this.url, HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", "tmp");
            StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));
            return ret;
        });
        System.out.println("Next copy this data to gcs");
    }

}
