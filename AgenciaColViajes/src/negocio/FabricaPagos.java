package negocio;


/**
 * 
 */
public class FabricaPagos {


     /**
     * Default constructor
     */
    public FabricaPagos() {
    }

    /**
     * @param nombrePago 
     * @return
     */
    public Pago getPago(String nombrePago) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (Pago) Class.forName(nombrePago).newInstance();
               
    }

}