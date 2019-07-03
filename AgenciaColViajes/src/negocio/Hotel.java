package negocio;

import java.util.*;

/**
 * 
 */
public class Hotel {

    private String nombre;
    /**
     * Default constructor
     */
    public Hotel() {
    }

    public Hotel(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}