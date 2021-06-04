package com.nextgatetech.gcrdemo.engine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtractionResult {

    private String filename;

    private byte[] data;

}
