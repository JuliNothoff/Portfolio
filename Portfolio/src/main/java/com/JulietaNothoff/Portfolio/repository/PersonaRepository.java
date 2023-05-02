
package com.JulietaNothoff.Portfolio.repository;

import com.JulietaNothoff.Portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julie
 */
@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
