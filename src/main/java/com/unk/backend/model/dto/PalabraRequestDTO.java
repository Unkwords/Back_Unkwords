package com.unk.backend.model.dto;

import java.util.List;

public record PalabraRequestDTO(

     String palabra,
     String tipo,
     String origen,
     List<String> significados,
     List<String> ejemplos,
     List<String> sinonimos,
     List<String> antonimos,
     int numLikes

) {
}
