package com.github.davidcalleja.hexagonal.domain.port.secondary;

public interface Log {

    void debug(String message, Object... value);

    void error( String message, Object... value);

    void warn( String message, Object... value);

    void info( String message, Object... value);

    void trace( String message, Object... value);
}
