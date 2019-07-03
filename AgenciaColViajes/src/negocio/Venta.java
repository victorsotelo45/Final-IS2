package negocio;


/**
 * 
 */
public class Venta {

    private FabricaPagos fabrica;
      /**
     * Default constructor
     */
    public Venta() {
        this.fabrica=new FabricaPagos();
    }

    public FabricaPagos getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaPagos fabrica) {
        this.fabrica = fabrica;
    }



}