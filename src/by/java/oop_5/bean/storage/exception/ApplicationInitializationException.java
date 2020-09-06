package by.java.oop_5.bean.storage.exception;

public class ApplicationInitializationException extends Exception {

    public ApplicationInitializationException(String message) {
        super(message);
    }

    public ApplicationInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
