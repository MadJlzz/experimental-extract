package com.nextgatetech.gcrdemo.service.sftp;

import com.nextgatetech.gcrdemo.service.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void extract() {
        logger.info("Running extraction from SftpServiceImpl");
    }

}
