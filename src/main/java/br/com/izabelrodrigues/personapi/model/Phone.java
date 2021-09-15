package br.com.izabelrodrigues.personapi.model;/* Created by Izabel Rodrigues */

import enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Size(min = 2, max = 2, message = "Invalid ddd phone number. Size should be 2 numbers.")
    @Column(nullable = false)
    private String ddd;

    @Size(min = 8, max = 9, message = "Invalid phone number. Size should be between 8 and 9 numbers.")
    @Column(nullable = false)
    private String number;

}
