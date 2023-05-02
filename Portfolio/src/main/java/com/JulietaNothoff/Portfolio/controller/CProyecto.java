
package com.JulietaNothoff.Portfolio.controller;

import com.JulietaNothoff.Portfolio.dto.dtoProyecto;
import com.JulietaNothoff.Portfolio.entity.Proyecto;
import com.JulietaNothoff.Portfolio.security.Controller.Mensaje;
import com.JulietaNothoff.Portfolio.service.SProyecto;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julie
 */

@RestController
@RequestMapping("/proyecto")
@CrossOrigin (origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("El proyecto ha sido eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyecto.existsByNombre(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Este nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoproyecto.getNombre(), dtoproyecto.getDescripcion(), dtoproyecto.getFecha(), dtoproyecto.getLink());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("El proyecto fue creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }        
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombre(dtoproyecto.getNombre());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setFecha(dtoproyecto.getFecha());
        proyecto.setLink(dtoproyecto.getLink());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }
    
}
