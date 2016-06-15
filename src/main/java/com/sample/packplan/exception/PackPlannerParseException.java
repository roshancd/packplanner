package com.sample.packplan.exception;

/**
 * Exception to represent data parsing errors
 */
public class PackPlannerParseException extends PackPlannerException {

    public PackPlannerParseException() {
        super();
    }

    public PackPlannerParseException(String message) {
        super(message);
    }

    public PackPlannerParseException(Throwable throwable) {
        super(throwable);
    }

    public PackPlannerParseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
