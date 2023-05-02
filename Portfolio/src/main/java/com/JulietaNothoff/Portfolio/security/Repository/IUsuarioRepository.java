
package com.JulietaNothoff.Portfolio.security.Repository;

import com.JulietaNothoff.Portfolio.security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julie
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario); 
    
}
