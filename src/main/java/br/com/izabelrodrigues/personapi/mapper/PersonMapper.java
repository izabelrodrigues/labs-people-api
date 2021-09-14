package br.com.izabelrodrigues.personapi.mapper;

import br.com.izabelrodrigues.personapi.dto.PersonDTO;
import br.com.izabelrodrigues.personapi.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "birthdate", target = "birthdate", qualifiedByName = "localDate")
    Person toPerson(PersonDTO personDTO);

    @Named("localDate")
    static LocalDate localDate(String date) {
        if (date == null) {
            return null;
        }

        return LocalDate.parse(date);
    }

}
