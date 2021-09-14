package br.com.izabelrodrigues.personapi.exception;

import org.apache.logging.log4j.util.Strings;

public class NotFoundException extends Exception {


    private String idResource;
    private String typeResource;

    private String customMessage;

    public NotFoundException(String idResource, String typeResource) {
        this.idResource = idResource;
        this.typeResource = typeResource;
    }

    public NotFoundException(String customMessage) {
        this.customMessage = customMessage;
    }


    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder(typeResource);
        sb.append(" ");
        sb.append(idResource);
        sb.append(" ");
        sb.append("not found.");

        return Strings.isBlank(customMessage) ? sb.toString() : customMessage;
    }
}
