package negocio;

import java.util.*;

/**
 * 
 */
public class PagoTarjetaCredito extends Pago {

    private String codigo;
    private String franquisia;
    private long numeroTarjeta;
    private long codSeguridad;

  
    /**
     * Default constructor
     */
    public PagoTarjetaCredito() {
    }

    public PagoTarjetaCredito(String codigo, String franquisia, long numeroTarjeta, long codSeguridad) {
        this.codigo = codigo;
        this.franquisia = franquisia;
        this.numeroTarjeta = numeroTarjeta;
        this.codSeguridad = codSeguridad;
    }

   

    /**
     * 
     * @param cliente
     * @param valor
     */
    @Override
    public void registrarPago(Cliente cliente,long valor) {
        this.setCliente(cliente);
        this.setValor(valor);
    }
    public void registrarPago(Cliente cliente,long valor,String codigo, String franquisia, long numeroTarjeta, long codSeguridad){
        registrarPago(cliente, valor);
        this.setCodigo(codigo);
        this.setCodSeguridad(codSeguridad);
        this.setFranquisia(franquisia);
        this.setNumeroTarjeta(numeroTarjeta);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFranquisia() {
        return franquisia;
    }

    public void setFranquisia(String franquisia) {
        this.franquisia = franquisia;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public long getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(long codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    
}