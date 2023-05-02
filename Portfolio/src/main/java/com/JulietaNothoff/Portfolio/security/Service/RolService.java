
package com.JulietaNothoff.Portfolio.security.Service;

import com.JulietaNothoff.Portfolio.security.Entity.Rol;
import com.JulietaNothoff.Portfolio.security.Enums.RolNombre;
import com.JulietaNothoff.Portfolio.security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julie
 */
@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    
    }
    
    public void save(Rol rol){
        
        irolRepository.save(rol);    
    }
    
}
