package com.sample.packplan.exception;

/**
 * Exception to represent data validation failures
 */
public class PackPlannerValidationException extends PackPlannerException {

    public PackPlannerValidationException() {
        super();
    }

    public PackPlannerValidationException(String message) {
        super(message);
    }

    public PackPlannerValidationException(Throwable throwable) {
        super(throwable);
    }

    public PackPlannerValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
