package dev.Zerphyis.listagem.Service;

import static org.junit.jupiter.api.Assertions.*;

import dev.Zerphyis.listagem.Entits.Person.Person;
import dev.Zerphyis.listagem.Exeception.PersonNotFoundExeception;
import dev.Zerphyis.listagem.Records.DataPerson;
import dev.Zerphyis.listagem.Repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {
    @InjectMocks
    private PersonService service;

    @Mock
    private PersonRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreatePerson() {
        DataPerson data = new DataPerson("Otávio", LocalDate.of(2000, 1, 1));
        Person person = new Person(data);

        when(repository.save(any(Person.class))).thenReturn(person);

        Person result = service.create(data);

        assertEquals("Otávio", result.getName());
        verify(repository).save(any(Person.class));
    }

    @Test
    void shouldListAllPersons() {
        when(repository.findAll()).thenReturn(List.of(new Person(), new Person()));
        List<Person> result = service.listAll();
        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnPersonById() {
        Person person = new Person();
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        assertEquals(person, service.getById(1L));
    }

    @Test
    void shouldThrowIfPersonNotFoundOnGet() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(PersonNotFoundExeception.class, () -> service.getById(1L));
    }

    @Test
    void shouldUpdatePerson() {
        DataPerson newData = new DataPerson("Novo Nome", LocalDate.of(1999, 10, 10));
        Person existing = new Person(new DataPerson("Antigo", LocalDate.of(1990, 1, 1)));

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(Person.class))).thenReturn(existing);

        Person updated = service.update(1L, newData);

        assertEquals("Novo Nome", updated.getName());
        assertEquals(LocalDate.of(1999, 10, 10), updated.getDateBirth());
    }

    @Test
    void shouldDeletePerson() {
        Person person = new Person();
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        service.delete(1L);
        verify(repository).delete(person);
    }

}