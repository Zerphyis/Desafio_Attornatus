package dev.Zerphyis.listagem.Records;

import java.time.LocalDate;
import java.util.List;

public record DataPersonExit(String name, LocalDate dateBirth, List<DataAddresExit> addresses) {
}