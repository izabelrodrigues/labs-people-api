package br.com.izabelrodrigues.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    @Column(nullable = false)
    private String name;

    @Size(max = 20, message = "Last Name must not have more than 20 letters")
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotBlank(message = "CPF must be filled in")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;


}
