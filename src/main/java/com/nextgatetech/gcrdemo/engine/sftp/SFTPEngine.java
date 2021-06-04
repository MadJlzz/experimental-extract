package com.nextgatetech.gcrdemo.engine.sftp;

import com.nextgatetech.gcrdemo.engine.Engine;
import com.nextgatetech.gcrdemo.engine.ExtractionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class SFTPEngine implements Engine {

    private final Logger logger = LoggerFactory.getLogger(SFTPEngine.class);

    private final String hostname;

    private final String user;

    private final int port;

    public SFTPEngine(final String hostname, final String user, final int port) {
        this.hostname = hostname;
        this.user = user;
        this.port = port;
    }

    @Override
    public List<ExtractionResult> extract() {
        logger.info("Running extraction from SftpServiceImpl");
        return Collections.emptyList();
    }

}
