package one.digitalinnovation.rest.people.management.system.services;

import one.digitalinnovation.rest.people.management.system.dto.mapper.PersonMapper;
import one.digitalinnovation.rest.people.management.system.dto.request.PersonDTO;
import one.digitalinnovation.rest.people.management.system.dto.response.MessageResponseDTO;
import one.digitalinnovation.rest.people.management.system.entities.Person;
import one.digitalinnovation.rest.people.management.system.repositories.PersonRepository;
import one.digitalinnovation.rest.people.management.system.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.rest.people.management.system.utils.PersonUtils.createFakeDTO;
import static one.digitalinnovation.rest.people.management.system.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
