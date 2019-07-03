package negocio;


/**
 * 
 */
public class PlanAlimentacion {
    
    private String[] alimentacion;

    /**
     * Default constructor
     */
    public PlanAlimentacion() {
    }

    public PlanAlimentacion(String[] alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String[] getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String[] alimentacion) {
        this.alimentacion = alimentacion;
    }
    
}