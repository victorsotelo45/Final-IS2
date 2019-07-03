package negocio;


/**
 * 
 */
public class PagoEfectivo extends Pago {

    /**
     * Default constructor
     */
    public PagoEfectivo() {
    }

    /**
     * 
     */
    public void PagoEfectivo() {
        // TODO implement here
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

}