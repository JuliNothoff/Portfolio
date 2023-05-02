
package com.JulietaNothoff.Portfolio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author julie
 */
public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String periodoE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String periodoE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.periodoE = periodoE;
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

    public String getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(String periodoE) {
        this.periodoE = periodoE;
    }
    
    
    
}
