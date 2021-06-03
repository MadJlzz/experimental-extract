package com.nextgatetech.gcrdemo.engine;

public class UnknownEngineException extends RuntimeException {

    public UnknownEngineException(final EngineType type) {
        super(String.format("Engine type [%s] is not yet implemented.", type));
    }

}
