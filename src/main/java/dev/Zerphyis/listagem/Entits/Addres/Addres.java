package dev.Zerphyis.listagem.Entits.Addres;

import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Records.DataAddres;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "endereco")
public class Addres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String publicPlace;
    @NotBlank
    private String cep;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    private boolean main;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Person person;

    public Addres() {

    }

    public Addres(DataAddres data ,Person person){
        this.publicPlace= data.publicPlace();
        this.cep= data.cep();
        this.number= data.number();
        this.city= data.city();
        this.main=true;
        this.person=person;
    }

    public void desativeMain() {
        this.main = false;
    }


    public String getPublicPlace() {
        return publicPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}