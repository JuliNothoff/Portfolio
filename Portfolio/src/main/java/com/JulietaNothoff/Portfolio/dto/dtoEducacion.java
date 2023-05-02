
package com.JulietaNothoff.Portfolio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author julie
 */
    
public class dtoEducacion {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String finalE;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String finalE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.finalE = finalE;
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
