
package com.JulietaNothoff.Portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author julie
 */
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;    
    private String nombreE;
    private String descripcionE;
    private String finalE;

    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE, String finalE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.finalE = finalE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFinalE() {
        return finalE;
    }

    public void setFinalE(String finalE) {
        this.finalE = finalE;
    }
    
    
    
}
