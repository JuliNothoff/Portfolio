
package com.JulietaNothoff.Portfolio.service;

import com.JulietaNothoff.Portfolio.entity.Proyecto;
import com.JulietaNothoff.Portfolio.repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julie
 */

@Service
@Transactional
public class SProyecto {
    
    @Autowired 
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> findByNombre(String nombre){
        return rProyecto.findByNombre(nombre);
    }
    
    public void save(Proyecto proyecto){
        rProyecto.save(proyecto);
    }
    
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rProyecto.existsByNombre(nombre);
    }
    
}
