package one.digitalinnovation.rest.people.management.system.repositories;

import one.digitalinnovation.rest.people.management.system.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
