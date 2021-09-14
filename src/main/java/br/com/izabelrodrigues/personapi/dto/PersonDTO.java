package br.com.izabelrodrigues.personapi.dto;

import br.com.izabelrodrigues.personapi.model.Phone;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDTO {

    private String name;

    private String lastname;

    private String cpf;

    private String birthdate;

    private List<Phone> phones;
}
