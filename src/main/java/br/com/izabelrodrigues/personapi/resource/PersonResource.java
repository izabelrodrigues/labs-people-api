package br.com.izabelrodrigues.personapi.resource;/* Created by Izabel Rodrigues */

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.exception.BusinessValidationException;
import br.com.izabelrodrigues.personapi.exception.NotFoundException;
import br.com.izabelrodrigues.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonResource {

    private final PersonService personService;

    @Autowired
    PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO personDTO, Errors errors) throws BusinessValidationException {
        validateBeforeCreateOrUpdate(errors);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDTO));
    }

    @GetMapping
    public List<PersonDTO> findAll() throws NotFoundException {
        List<PersonDTO> list = personService.findAll();
        if (list.isEmpty()) {
            throw new NotFoundException("Not found people.");
        }
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity.ok(personService.findBy(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws NotFoundException {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@Valid @RequestBody PersonDTO personDTO, @PathVariable Long id, Errors errors) throws BusinessValidationException, NotFoundException {
        validateBeforeCreateOrUpdate(errors);
        personDTO.setId(id);
        return ResponseEntity.ok(personService.update(personDTO));
    }

    private void validateBeforeCreateOrUpdate(Errors errors) throws BusinessValidationException {
        if (errors.hasErrors()) {
            List<String> errorMsg = new ArrayList<>();
            errors.getAllErrors().forEach(a -> errorMsg.add(a.getDefaultMessage()));
            throw new BusinessValidationException(errorMsg);
        }
    }
}
