package com.nextgatetech.gcrdemo.service;

import com.nextgatetech.gcrdemo.configuration.EngineProps;
import com.nextgatetech.gcrdemo.engine.Engine;
import com.nextgatetech.gcrdemo.engine.EngineFactory;
import com.nextgatetech.gcrdemo.engine.EngineType;
import com.nextgatetech.gcrdemo.engine.ExtractionResult;
import com.nextgatetech.gcrdemo.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtractionService {

    private final EngineFactory engineFactory;

    private final Storage storage;

    @Autowired
    public ExtractionService(final EngineProps engineProps, final Storage storage) {
        this.engineFactory = new EngineFactory(engineProps);
        this.storage = storage;
    }

    public void extract(final EngineType engineType, final String client) {
        final Engine engine = this.engineFactory.getEngine(engineType, client);
        final List<ExtractionResult> results = engine.extract();
        for (final ExtractionResult result : results) {
            this.storage.store(result);
        }
    }

}
