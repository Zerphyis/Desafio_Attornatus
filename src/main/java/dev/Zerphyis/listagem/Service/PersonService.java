package dev.Zerphyis.listagem.Service;

import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Exeception.PersonNotFoundExeception;
import dev.Zerphyis.listagem.Records.DataPerson;
import dev.Zerphyis.listagem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Person create(DataPerson data) {
        Person person = new Person(data);
        return repository.save(person);
    }

    public List<Person> listAll() {
        return repository.findAll();
    }

    public Person getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundExeception("Pessoa não encontrada com ID: " + id));
    }

    public Person update(Long id, DataPerson data) {
        Person person = getById(id);
        person.setName(data.name());
        person.setDateBirth(data.dateBirth());
        return repository.save(person);
    }

    public void delete(Long id) {
        Person person = getById(id);
        repository.delete(person);
    }

}
