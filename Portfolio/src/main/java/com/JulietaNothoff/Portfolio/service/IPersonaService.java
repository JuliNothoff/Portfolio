
package com.JulietaNothoff.Portfolio.service;

import com.JulietaNothoff.Portfolio.model.Persona;
import java.util.List;

/**
 *
 * @author julie
 */
public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public void editarPersona(Persona per);
    
}
