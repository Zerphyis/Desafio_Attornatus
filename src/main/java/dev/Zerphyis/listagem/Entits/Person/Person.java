package dev.Zerphyis.listagem.Entits.Person;

import dev.Zerphyis.listagem.Entits.Addres.Addres;
import dev.Zerphyis.listagem.Records.DataPerson;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @NotNull
    private LocalDate dateBirth;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Addres> enderecos = new ArrayList<>();

    public Person(){

    }
    public Person(DataPerson data){
        this.name=data.name();
        this.dateBirth=data.dateBirth();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Addres> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Addres> enderecos) {
        this.enderecos = enderecos;
    }
}
