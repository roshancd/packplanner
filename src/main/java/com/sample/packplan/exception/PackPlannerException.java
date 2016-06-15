package com.sample.packplan.exception;

/**
 * Top level exception of pack planner
 */
public class PackPlannerException extends Exception {

    public PackPlannerException() {
        super();
    }

    public PackPlannerException(String message) {
        super(message);
    }

    public PackPlannerException(Throwable throwable) {
        super(throwable);
    }

    public PackPlannerException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
