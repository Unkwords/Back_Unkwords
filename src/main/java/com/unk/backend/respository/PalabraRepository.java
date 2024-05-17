package com.unk.backend.respository;

import com.unk.backend.model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra,Long> {
    @Query("SELECT COUNT(p) FROM palabras p")
    int countPalabras();
}
