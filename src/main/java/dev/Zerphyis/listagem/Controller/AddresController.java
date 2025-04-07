package dev.Zerphyis.listagem.Controller;

import dev.Zerphyis.listagem.Entits.Addres.Addres;
import dev.Zerphyis.listagem.Records.DataAddres;
import dev.Zerphyis.listagem.Records.DataAddresWithPersonName;
import dev.Zerphyis.listagem.Service.AddresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("endereco")
public class AddresController {
    @Autowired
    AddresService service;

    @PostMapping("/pessoa/{personId}")
    public Addres create(@PathVariable("personId") Long personId, @RequestBody DataAddres data) {
        return service.create(personId, data);
    }

    @GetMapping
    public List<DataAddresWithPersonName> listAll() {
        return service.listAll().stream()
                .map(addr -> new DataAddresWithPersonName(
                        addr.getId(),
                        addr.getPublicPlace(),
                        addr.getCep(),
                        addr.getNumber(),
                        addr.getCity(),
                        addr.isMain(),
                        addr.getPerson().getName()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DataAddresWithPersonName getById(@PathVariable("id") Long id) {
        Addres addr = service.getById(id);
        return new DataAddresWithPersonName(
                addr.getId(),
                addr.getPublicPlace(),
                addr.getCep(),
                addr.getNumber(),
                addr.getCity(),
                addr.isMain(),
                addr.getPerson().getName()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
