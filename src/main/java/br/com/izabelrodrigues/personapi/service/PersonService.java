package br.com.izabelrodrigues.personapi.service;

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.mapper.PersonMapper;
import br.com.izabelrodrigues.personapi.model.Person;
import br.com.izabelrodrigues.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toPerson(personDTO);
        return personRepository.save(person);
    }
}
