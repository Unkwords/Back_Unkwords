package com.unk.backend.service;

import com.unk.backend.model.Palabra;
import com.unk.backend.model.dto.PalabraRequestDTO;
import com.unk.backend.model.dto.PalabraResponseDTO;
import com.unk.backend.respository.PalabraRepository;
import com.unk.backend.service.mapper.PalabraDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PalabraServiceImp implements IPalabraService{

    private final PalabraRepository palabraRepository;
    private final PalabraDTOMapper palabraDTOMapper;

    /**
     * Metodo para guardar/crear una nueva palabra
     *
     * @param palabraRequestDTO
     * @return PalabraResponseDTO
     */
    @Override
    public PalabraResponseDTO save(PalabraRequestDTO palabraRequestDTO) {

        Palabra palabra = Palabra.builder()
                .palabra(palabraRequestDTO.palabra())
                .tipo(palabraRequestDTO.tipo())
                .origen(palabraRequestDTO.origen())
                .significados(significados(palabraRequestDTO.significados()))
                .ejemplos(ejemplos(palabraRequestDTO.ejemplos()))
                .sinonimos(sinonimos(palabraRequestDTO.sinonimos()))
                .antonimos(antonimos(palabraRequestDTO.antonimos()))
                .numLikes(palabraRequestDTO.numLikes())
                .build();
        return palabraDTOMapper.apply(palabraRepository.save(palabra));
    }

    /**
     * Metodo para obtener una paginacion de palabras, es decir que no se obtendran todas las palabras,
     * solo una parte de ellas, esto con el fin de que cuando se tenga demasiados datos en la base de datos
     * optimizar las llamadas a la base de datos, y asi el usuario no vea retrasos al momento de obtener los datos
     *
     * @param numPagina
     * @param numElementos
     * @return List
     */
    @Override
    public List<PalabraResponseDTO> findAll(Integer numPagina, Integer numElementos) {
        int totalPalabras = palabraRepository.countPalabras();
        int adjustedOff = numElementos * numPagina;
        adjustedOff = Math.min(adjustedOff,totalPalabras);
        if(adjustedOff>=totalPalabras){
            //TODO: manejar con excepciones personalizadas
            return null;
        }else{
            Page<Palabra> palabras = palabraRepository.findAll(PageRequest.of(numPagina, numElementos));
            return palabras.stream().map(palabra -> palabraDTOMapper.apply(palabra)).collect(Collectors.toList());
        }
    }


    /**
     * Metodo para saber si la lista de signficados que viene en el DTO no esta vacia,
     * si esta vacia, retornamos un nuevo ArrayList, de lo contrario retornamos la lista de significados
     * @param significados
     * @return ArrayList
     */
    private List<String> significados(List<String> significados){
        return Objects.requireNonNullElseGet(significados, ArrayList::new);
    }
    /**
     * Metodo para saber si la lista de ejemplos que viene en el DTO no esta vacia,
     * si esta vacia, retornamos un nuevo ArrayList, de lo contrario retornamos la lista de ejemplos
     * @param ejemplos
     * @return ArrayList
     */
    private List<String> ejemplos(List<String> ejemplos){
        return Objects.requireNonNullElseGet(ejemplos, ArrayList::new);
    }
    /**
     * Metodo para saber si la lista de sinonimos que viene en el DTO no esta vacia,
     * si esta vacia, retornamos un nuevo ArrayList, de lo contrario retornamos la lista de sinonimos
     * @param sinonimos
     * @return ArrayList
     */
    private List<String> sinonimos(List<String> sinonimos){
        return Objects.requireNonNullElseGet(sinonimos, ArrayList::new);
    }
    /**
     * Metodo para saber si la lista de antonimos que viene en el DTO no esta vacia,
     * si esta vacia, retornamos un nuevo ArrayList, de lo contrario retornamos la lista de antonimos
     * @param antonimos
     * @return ArrayList
     */
    private List<String> antonimos(List<String> antonimos){
        return Objects.requireNonNullElseGet(antonimos, ArrayList::new);
    }
}
