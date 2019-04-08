package com.github.davidcalleja.hexagonal.infrastructure.log;

import com.github.davidcalleja.hexagonal.domain.port.secondary.Log;
import lombok.Builder;

@Builder
public class Logger implements Log {

    private org.slf4j.Logger logger;

    @Override
    public void debug(final String message, final Object... value) {
        logger.debug(message, value);
    }

    @Override
    public void error(final String message, final Object... value) {
        logger.error(message, value);
    }

    @Override
    public void warn(final String message, final Object... value) {
        logger.warn(message, value);
    }

    @Override
    public void info(final String message, final Object... value) {
        logger.info(message, value);
    }

    @Override
    public void trace(final String message, final Object... value) {
        logger.trace(message, value);
    }
}
