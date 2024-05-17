package com.unk.backend.service;

import com.unk.backend.model.Palabra;
import com.unk.backend.model.dto.PalabraRequestDTO;
import com.unk.backend.model.dto.PalabraResponseDTO;

import java.util.List;

public interface IPalabraService {
    PalabraResponseDTO save(PalabraRequestDTO palabraRequestDTO);
    List<PalabraResponseDTO> findAll(Integer numPagina, Integer numElementos);
}
