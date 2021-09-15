package br.com.izabelrodrigues.personapi.dto;/* Created by Izabel Rodrigues */

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class PersonDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters.")
    private String name;

    @Size(min = 3, max = 150, message = "Lastname must not have more than 150 letters.")
    private String lastname;

    @NotBlank(message = "CPF must be filled in.")
    @CPF
    private String cpf;

    private String birthdate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
