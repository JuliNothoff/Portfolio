
package com.JulietaNothoff.Portfolio.controller;

import com.JulietaNothoff.Portfolio.dto.dtoPerson;
import com.JulietaNothoff.Portfolio.entity.Person;
import com.JulietaNothoff.Portfolio.security.Controller.Mensaje;
import com.JulietaNothoff.Portfolio.service.SPerson;
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
@RequestMapping("/person")
@CrossOrigin (origins = "http://localhost:4200")
public class CPerson {
    
    @Autowired
    SPerson sPerson;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Person>> list(){
        List<Person> list = sPerson.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de perfil no existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = sPerson.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de perfil no existe"), HttpStatus.NOT_FOUND);
        }
        sPerson.delete(id);
        return new ResponseEntity(new Mensaje("Perfil fue eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerson dtoperson){
        if(StringUtils.isBlank(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("El campo Nombre completo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sPerson.existsByFullname(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = new Person(dtoperson.getFullname(), dtoperson.getImgPerfil(), dtoperson.getPosicion(), dtoperson.getUbicacion(),
        dtoperson.getContacto(), dtoperson.getInteres(), dtoperson.getAcercade());
        sPerson.save(person);
        
        return new ResponseEntity(new Mensaje("Perfil creado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody dtoPerson dtoperson){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El id de perfil no existe"), HttpStatus.NOT_FOUND);
        }     
        if(sPerson.existsByFullname(dtoperson.getFullname()) && sPerson.getByFullname(dtoperson.getFullname()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre para perfil ya existe"), HttpStatus.BAD_REQUEST);            
        }
        if(StringUtils.isBlank(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("El campo Nombre completo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Person person = sPerson.getOne(id).get();
        person.setFullname(dtoperson.getFullname());
        person.setImgPerfil(dtoperson.getImgPerfil());
        person.setPosicion(dtoperson.getPosicion());
        person.setUbicacion(dtoperson.getUbicacion());
        person.setContacto(dtoperson.getContacto());
        person.setInteres(dtoperson.getInteres());
        person.setAcercade(dtoperson.getAcercade());
        
        sPerson.save(person);
        return new ResponseEntity(new Mensaje("Perfil actualizado correctamente"), HttpStatus.OK);
    }
    
}
