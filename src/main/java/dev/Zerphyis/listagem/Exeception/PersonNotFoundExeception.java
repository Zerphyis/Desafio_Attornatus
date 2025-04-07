package dev.Zerphyis.listagem.Exeception;

public class PersonNotFoundExeception extends RuntimeException {
    public PersonNotFoundExeception(String message) {
        super(message);
    }
}
