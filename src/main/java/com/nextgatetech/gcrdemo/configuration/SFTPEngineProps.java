package com.nextgatetech.gcrdemo.configuration;

import lombok.Data;

@Data
public class SFTPEngineProps {

    private String hostname;

    private String user;

    private int port;

}
