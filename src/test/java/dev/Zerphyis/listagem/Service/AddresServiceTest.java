package dev.Zerphyis.listagem.Service;

import static org.junit.jupiter.api.Assertions.*;
import dev.Zerphyis.listagem.Entits.Addres.Addres;
import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Exeception.AddresNotFoundExeception;
import dev.Zerphyis.listagem.Exeception.PersonNotFoundExeception;
import dev.Zerphyis.listagem.Records.DataAddres;
import dev.Zerphyis.listagem.Repository.AddresRepository;
import dev.Zerphyis.listagem.Repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
class AddresServiceTest {
    @InjectMocks
    private AddresService service;

    @Mock
    private AddresRepository addresRepository;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateAddres() {
        DataAddres data = new DataAddres("Rua A", "12345-000", "100", "Cidade X");

        Person person = new Person();
        person.setEnderecos(new ArrayList<>());

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        when(addresRepository.save(any(Addres.class))).thenAnswer(inv -> inv.getArgument(0));

        Addres created = service.create(1L, data);

        assertEquals("Rua A", created.getPublicPlace());
        assertTrue(created.isMain());
    }

    @Test
    void shouldThrowIfPersonNotFound() {
        DataAddres data = new DataAddres("Rua A", "12345-000", "100", "Cidade X");

        when(personRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundExeception.class, () -> service.create(99L, data));
    }

    @Test
    void shouldListAllAddresses() {
        when(addresRepository.findAll()).thenReturn(List.of(new Addres(), new Addres()));
        assertEquals(2, service.listAll().size());
    }

    @Test
    void shouldGetAddressById() {
        Addres addr = new Addres();
        when(addresRepository.findById(1L)).thenReturn(Optional.of(addr));
        assertEquals(addr, service.getById(1L));
    }

    @Test
    void shouldThrowIfAddressNotFound() {
        when(addresRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(AddresNotFoundExeception.class, () -> service.getById(1L));
    }

    @Test
    void shouldDeleteAddress() {
        Addres addr = new Addres();
        when(addresRepository.findById(1L)).thenReturn(Optional.of(addr));
        service.delete(1L);
        verify(addresRepository).delete(addr);
    }
  
}