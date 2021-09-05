package one.digitalinnovation.rest.people.management.system.dto.mapper;

import one.digitalinnovation.rest.people.management.system.dto.request.PersonDTO;
import one.digitalinnovation.rest.people.management.system.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
