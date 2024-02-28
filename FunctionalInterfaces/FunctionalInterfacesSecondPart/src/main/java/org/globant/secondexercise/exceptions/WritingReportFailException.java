package org.globant.secondexercise.exceptions;

public class WritingReportFailException extends Exception{

    /**
     * States a file writing error. <br>
     * This exception is thrown when the report generation writing fails .
     *
     * @param message the error message.
     * @param cause   the cause of the error.
     */
    public WritingReportFailException(String message, Exception cause) {
        super(message, cause);
        System.out.println("An error occurred with description: " + message + " and cause " + cause);
    }
}
