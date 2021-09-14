package br.com.izabelrodrigues.personapi.exception;

public class BusinessValidationException extends Exception {

    private final String customMessage;

    public BusinessValidationException(String customMessage) {
        this.customMessage = customMessage;
    }

    @Override
    public String getMessage() {
        return customMessage;
    }
}
