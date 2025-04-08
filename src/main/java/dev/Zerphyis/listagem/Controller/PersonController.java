package dev.Zerphyis.listagem.Controller;

import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Records.DataAddresExit;
import dev.Zerphyis.listagem.Records.DataPerson;
import dev.Zerphyis.listagem.Records.DataPersonExit;
import dev.Zerphyis.listagem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@RestController
public class PersonController {
    @Autowired
    PersonService service;

    @PostMapping
    public Person create(@RequestBody  DataPerson data) {
        return service.create(data);
    }


    @GetMapping
    public List<DataPersonExit> listAll() {
        return service.listAll().stream()
                .map(person -> new DataPersonExit(
                        person.getName(),
                        person.getDateBirth(),
                        person.getEnderecos().stream()
                                .map(addr -> new DataAddresExit(
                                        addr.getPublicPlace(),
                                        addr.getNumber(),
                                        addr.getCity()))
                                .toList()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public DataPersonExit getById(@PathVariable("id") Long id) {
        Person person = service.getById(id);
        List<DataAddresExit> addresses = person.getEnderecos().stream()
                .map(addr -> new DataAddresExit(
                        addr.getPublicPlace(),
                        addr.getNumber(),
                        addr.getCity()))
                .toList();

        return new DataPersonExit(person.getName(), person.getDateBirth(), addresses);
    }

    @PutMapping("/{id}")
    public DataPersonExit update(@PathVariable("id") Long id, @RequestBody DataPerson data) {
        Person person = service.update(id, data);

        List<DataAddresExit> addresses = person.getEnderecos().stream()
                .map(addr -> new DataAddresExit(
                        addr.getPublicPlace(),
                        addr.getNumber(),
                        addr.getCity()))
                .toList();

        return new DataPersonExit(person.getName(), person.getDateBirth(), addresses);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
