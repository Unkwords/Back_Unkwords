package com.unk.backend.controller;

import com.unk.backend.model.dto.PalabraRequestDTO;
import com.unk.backend.model.dto.PalabraResponseDTO;
import com.unk.backend.service.IPalabraService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/palabras")
public class PalabraController {

    private final IPalabraService iPalabraService;

    /**
     * Endpoint en el cual se guardara una nueva palabra
     *
     * @param palabraRequestDTO
     * @return ResponseEntity
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PalabraRequestDTO palabraRequestDTO){
       PalabraResponseDTO response = iPalabraService.save(palabraRequestDTO);
       //TODO: manejar los errores con excepciones personalizadas
       if(palabraRequestDTO==null){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }else{
           return new ResponseEntity<>(response,HttpStatus.OK);
       }
    }

    /**
     * Endpoint el cual no devolvera una paginacion de los primeros 10 elementos de la primer pagina
     * @return ResponseEntity
     */
    @GetMapping("/find")
    public ResponseEntity<?> findAllByDefault(){
        List<PalabraResponseDTO> palabras = iPalabraService.findAll(0,10);
        if(palabras==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(palabras,HttpStatus.OK);
        }
    }

    /**
     * Endpoint el cual no devolvera una paginacion de la pagina indicada con el numero de elementos indicados
     * @param numPagina
     * @param numElementos
     * @return ResponseEntity
     */
    @GetMapping("/find/{numPagina}/{numElementos}")
    public ResponseEntity<?> findAll(@PathVariable("numPagina") Integer numPagina,
                                              @PathVariable("numElementos") Integer numElementos){

        List<PalabraResponseDTO> palabras = iPalabraService.findAll(numPagina,numElementos);
        if(palabras==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(palabras,HttpStatus.OK);
        }
    }
}
