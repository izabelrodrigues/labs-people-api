package br.com.izabelrodrigues.personapi.service;/* Created by Izabel Rodrigues */

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.exception.BusinessValidationException;
import br.com.izabelrodrigues.personapi.exception.NotFoundException;
import br.com.izabelrodrigues.personapi.mapper.PersonMapper;
import br.com.izabelrodrigues.personapi.model.Person;
import br.com.izabelrodrigues.personapi.repository.PersonRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public static final PersonMapper INSTANCE = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO create(PersonDTO personDTO) throws BusinessValidationException {
        return saveOrUpdatePerson(personDTO);

    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream().map(INSTANCE::toPersonDTO).collect(Collectors.toList());
    }

    public PersonDTO findBy(Long id) throws NotFoundException {
        Optional<Person> optionalPerson = verifyIfExistsPerson(id);
        return INSTANCE.toPersonDTO(optionalPerson.get());
    }

    private Optional<Person> verifyIfExistsPerson(Long id) throws NotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new NotFoundException(id.toString(), Person.class.getSimpleName());
        }
        return optionalPerson;
    }

    public void delete(Long id) throws NotFoundException {
        verifyIfExistsPerson(id);
        personRepository.deleteById(id);
    }

    public PersonDTO update(PersonDTO personDTO) throws BusinessValidationException, NotFoundException {

        verifyIfExistsPerson(personDTO.getId());

        return saveOrUpdatePerson(personDTO);

    }

    private PersonDTO saveOrUpdatePerson(PersonDTO personDTO) throws BusinessValidationException {
        Person person = INSTANCE.toPerson(personDTO);
        try {
            Person savedPerson = personRepository.save(person);
            return INSTANCE.toPersonDTO(savedPerson);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof ConstraintViolationException) {
                throw new BusinessValidationException(Arrays.asList("CPF duplicated"));
            }
            throw ex;
        }
    }
}
