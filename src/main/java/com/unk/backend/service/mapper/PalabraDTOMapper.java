package com.unk.backend.service.mapper;

import com.unk.backend.model.Palabra;
import com.unk.backend.model.dto.PalabraResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PalabraDTOMapper implements Function<Palabra, PalabraResponseDTO> {
    @Override
    public PalabraResponseDTO apply(Palabra palabra) {
        return new PalabraResponseDTO(
                palabra.getId(),
                palabra.getPalabra(),
                palabra.getTipo(),
                palabra.getOrigen(),
                palabra.getSignificados(),
                palabra.getEjemplos(),
                palabra.getSinonimos(),
                palabra.getAntonimos(),
                palabra.getNumLikes()
        );
    }
}
