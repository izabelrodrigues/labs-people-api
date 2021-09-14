package br.com.izabelrodrigues.personapi.dto;

import br.com.izabelrodrigues.personapi.model.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class PersonDTO {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;

    @Size(max = 20, message = "Lastname must not have more than 20 letters")
    private String lastname;

    @NotBlank(message = "CPF must be filled in")
    private String cpf;

    private String birthdate;

    private List<Phone> phones;
}
