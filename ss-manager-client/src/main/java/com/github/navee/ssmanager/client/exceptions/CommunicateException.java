package com.github.navee.ssmanager.client.exceptions;

/**
 * @auther navee
 */
public class CommunicateException extends RuntimeException {
    public CommunicateException() {
        super();
    }

    public CommunicateException(String message) {
        super(message);
    }

    public CommunicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunicateException(Throwable cause) {
        super(cause);
    }

    protected CommunicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
