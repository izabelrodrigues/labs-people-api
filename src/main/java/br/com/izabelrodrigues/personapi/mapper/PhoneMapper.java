package br.com.izabelrodrigues.personapi.mapper;

import br.com.izabelrodrigues.personapi.dto.PhoneDTO;
import br.com.izabelrodrigues.personapi.model.Phone;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
public interface PhoneMapper {

    Phone toPerson(PhoneDTO personDTO);
}
