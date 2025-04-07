package dev.Zerphyis.listagem.Repository;

import dev.Zerphyis.listagem.Entits.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
