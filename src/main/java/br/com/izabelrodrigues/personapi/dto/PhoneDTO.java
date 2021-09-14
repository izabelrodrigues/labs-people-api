package br.com.izabelrodrigues.personapi.dto;

import enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Size(min = 2, max = 2, message = "Invalid ddd phone number. Size should be 2 numbers.")
    private String ddd;

    @NotEmpty
    @Size(min = 8, max = 9, message = "Invalid phone number. Size should be between 8 and 9 numbers.")
    private String number;

}
