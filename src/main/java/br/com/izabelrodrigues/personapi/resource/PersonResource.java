package br.com.izabelrodrigues.personapi.resource;

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.exception.BusinessValidationException;
import br.com.izabelrodrigues.personapi.model.Person;
import br.com.izabelrodrigues.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {


    private PersonService personService;

    @Autowired
    PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody PersonDTO personDTO, Errors errors) throws BusinessValidationException {
        if (errors.hasErrors()) {
            List<String> errorMsg = new ArrayList<>();
            errors.getAllErrors().forEach(a -> errorMsg.add(a.getDefaultMessage()));
            throw new BusinessValidationException(errorMsg);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDTO));
    }
}
