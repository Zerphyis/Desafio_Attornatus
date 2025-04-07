package dev.Zerphyis.listagem.Service;

import dev.Zerphyis.listagem.Entits.Addres.Addres;
import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Exeception.AddresNotFoundExeception;
import dev.Zerphyis.listagem.Exeception.PersonNotFoundExeception;
import dev.Zerphyis.listagem.Records.DataAddres;
import dev.Zerphyis.listagem.Repository.AddresRepository;
import dev.Zerphyis.listagem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddresService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddresRepository addresRepository;

    public Addres create(Long personId, DataAddres data) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundExeception("Pessoa não encontrada com ID: " + personId));

        person.getEnderecos().forEach(Addres::desativeMain);

        Addres addres = new Addres(data, person);
        return addresRepository.save(addres);
    }

    public List<Addres> listAll() {
        return addresRepository.findAll();
    }

    public Addres getById(Long id) {
        return addresRepository.findById(id)
                .orElseThrow(() -> new AddresNotFoundExeception("Endereço não encontrado com ID: " + id));
    }

    public void delete(Long id) {
        Addres address = addresRepository.findById(id)
                .orElseThrow(() -> new AddresNotFoundExeception("Endereço não encontrado com ID: " + id));

        addresRepository.delete(address);
    }
}
