package br.com.izabelrodrigues.personapi.exception;/* Created by Izabel Rodrigues */

import java.util.List;

public class BusinessValidationException extends Exception {

    private final List<String> messages;

    public BusinessValidationException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
