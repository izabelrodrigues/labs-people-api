package br.com.izabelrodrigues.personapi.repository;/* Created by Izabel Rodrigues */

import br.com.izabelrodrigues.personapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
