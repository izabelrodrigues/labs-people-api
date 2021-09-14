package br.com.izabelrodrigues.personapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private Date timestamp;
    private List<String> messages;
    private String description;
}
