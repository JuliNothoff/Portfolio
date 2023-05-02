
package com.JulietaNothoff.Portfolio.repository;

import com.JulietaNothoff.Portfolio.entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julie
 */

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    
    public Optional<Proyecto> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
