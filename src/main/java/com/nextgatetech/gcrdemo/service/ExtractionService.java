package com.nextgatetech.gcrdemo.service;

import com.nextgatetech.gcrdemo.configuration.EngineProps;
import com.nextgatetech.gcrdemo.engine.Engine;
import com.nextgatetech.gcrdemo.engine.EngineFactory;
import com.nextgatetech.gcrdemo.engine.EngineType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtractionService {

    private final EngineFactory engineFactory;

    @Autowired
    public ExtractionService(final EngineProps engineProps) {
        this.engineFactory = new EngineFactory(engineProps);
    }

    public void extract(final EngineType engineType, final String client) {
        final Engine engine = this.engineFactory.getEngine(engineType, client);
        engine.extract();
    }

}
