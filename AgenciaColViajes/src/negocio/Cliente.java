package negocio;

import java.util.*;

/**
 * 
 */
public class Cliente {
    
    private long identificacion;
    private String nombre;
    private String apellidos;
    private Date fecha_nac;//TODO
    private String fecha_nac2;
    private String email;
    private String genero;
    private String direccion;
    private String ciudad;
    private long celular;
    
    /**
     * Default constructor
     */
    public Cliente() {
    }

    public Cliente(long identificacion, String nombre, String apellidos, String fecha_nac, String email, String genero, String direccion, String ciudad, long celular) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac2 = fecha_nac;
        this.email = email;
        this.genero = genero;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
    }

    public Cliente(long identificacion, String nombre, String apellidos, String email, String genero) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.genero = genero;
    }
    
    

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    

}