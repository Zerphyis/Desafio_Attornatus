package dev.Zerphyis.listagem.Records;

public record DataAddresWithPersonName(    Long id,
                                           String publicPlace,
                                           String cep,
                                           String number,
                                           String city,
                                           boolean main,
                                           String personName
) {
}