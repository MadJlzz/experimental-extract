package com.nextgatetech.gcrdemo.controller;

import com.nextgatetech.gcrdemo.configuration.EngineProps;
import com.nextgatetech.gcrdemo.configuration.SFTPEngineProps;
import com.nextgatetech.gcrdemo.service.Engine;
import com.nextgatetech.gcrdemo.service.EngineFactory;
import com.nextgatetech.gcrdemo.service.EngineType;
import com.nextgatetech.gcrdemo.service.ExtractionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ExtractionController {

    private final Logger logger = LoggerFactory.getLogger(ExtractionController.class);

    private final ExtractionService extractionService;

    @Autowired
    public ExtractionController(final ExtractionService extractionService) {
        this.extractionService = extractionService;
    }

    @GetMapping(value = "/extract/{type}/{client}")
    public ResponseEntity<String> extract(@PathVariable final String type, @PathVariable final String client) {
        logger.info("Retrieving configuration for client [{}]", client);
        try {
            final EngineType engineType = EngineType.valueOf(type.toUpperCase());
            this.extractionService.extract(engineType, client);
        } catch (final IllegalArgumentException err) {
            logger.warn("Undefined engine type [{}].", type);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("Unknown engine type [%s].", type));
        }
        return ResponseEntity.ok("Extraction for client [" + client + "] was successful.");
    }

}
