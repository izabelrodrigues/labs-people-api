package br.com.izabelrodrigues.personapi.service;

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.exception.BusinessValidationException;
import br.com.izabelrodrigues.personapi.mapper.PersonMapper;
import br.com.izabelrodrigues.personapi.model.Person;
import br.com.izabelrodrigues.personapi.repository.PersonRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(PersonDTO personDTO) throws BusinessValidationException {
        Person person = PersonMapper.INSTANCE.toPerson(personDTO);
        try {
            return personRepository.save(person);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                throw new BusinessValidationException(Arrays.asList("CPF duplicated"));
            }
            throw ex;
        }

    }
}
