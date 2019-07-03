package negocio;


/**
 * 
 */
public class PagoContado extends Pago {
    /**
     * 
     */
    private int plazo;
    
     /**
     * Default constructor
     */
    public PagoContado() {
    }

    public PagoContado(int plazo) {
        this.plazo = plazo;
    }
    

    /**
     * 
     */
    public void calcularDeuda() {
        // TODO implement here
    }

    /**
     * 
     */
    public void calcularPagoInicial() {
        // TODO implement here
    }

   
    @Override
    public void registrarPago(Cliente cliente,long valor){
        this.setCliente(cliente);
        this.setValor(valor);
    }
    public void registrarPago(Cliente cliente,long valor, int plazo){
        registrarPago(cliente, valor);
        this.setPlazo(plazo);
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    

}