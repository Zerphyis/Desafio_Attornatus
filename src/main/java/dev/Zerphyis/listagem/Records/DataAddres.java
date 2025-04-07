package dev.Zerphyis.listagem.Records;

import jakarta.validation.constraints.NotBlank;

public record DataAddres(String publicPlace, String cep, String number, String city) {
}
