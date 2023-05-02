
package com.JulietaNothoff.Portfolio.controller;

import com.JulietaNothoff.Portfolio.dto.dtoHys;
import com.JulietaNothoff.Portfolio.entity.Hys;
import com.JulietaNothoff.Portfolio.security.Controller.Mensaje;
import com.JulietaNothoff.Portfolio.service.SHys;
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
@RequestMapping("/hys")
@CrossOrigin (origins = "http://localhost:4200")
public class CHys {
    
    @Autowired
    SHys sHys;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = sHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de HyS no existe"), HttpStatus.BAD_REQUEST);
        }
        Hys person = sHys.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id de HyS no existe"), HttpStatus.NOT_FOUND);
        }
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("HyS fue eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        Hys hys = new Hys(dtohys.getHtml(), dtohys.getBootstrap(), dtohys.getAngular(), dtohys.getMysql(), dtohys.getJava(), dtohys.getSpringboot());   
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("Hys creado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El id de HyS no existe"), HttpStatus.NOT_FOUND);
        } 
        Hys hys = sHys.getOne(id).get();
        hys.setHtml(dtohys.getHtml());
        hys.setBootstrap(dtohys.getBootstrap());
        hys.setAngular(dtohys.getAngular());
        hys.setMysql(dtohys.getMysql());
        hys.setJava(dtohys.getJava());
        hys.setSpringboot(dtohys.getSpringboot());
        
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("HyS actualizado correctamente"), HttpStatus.OK);
    }
    
}
