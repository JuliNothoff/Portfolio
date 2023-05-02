
package com.JulietaNothoff.Portfolio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author julie
 */
public class dtoProyecto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String link;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion, String fecha, String link) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    
}
