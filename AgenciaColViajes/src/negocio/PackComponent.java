package negocio;

import java.util.*;

/**
 * 
 */
public abstract class PackComponent {

    private String nombre;


    /**
     * Default constructor
     */
    public PackComponent() {
    }
    /**
     * @param nombre
     */
    public PackComponent(String nombre) {
        this.nombre=nombre;
    }

    /**
     * @param component
     */
    public void addComponent(PackComponent component) {
        // TODO implement here
    }

    /**
     * @param componetnNum 
     * @return
     */
    public PackComponent getComponent(int componetnNum) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract long getComponentPrecio();

    /**
     * @return
     */
    public String getNombre() {    
        return this.nombre;
        // TODO implement here
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

}