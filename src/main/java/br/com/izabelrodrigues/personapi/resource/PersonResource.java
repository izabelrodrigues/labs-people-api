package br.com.izabelrodrigues.personapi.resource;

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.model.Person;
import br.com.izabelrodrigues.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {


    private PersonService personService;

    @Autowired
    PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody PersonDTO personDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDTO));
    }
}
