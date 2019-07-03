package negocio;

import java.util.*;

/**
 * 
 */
public class RegionComponent extends PackComponent {

  
    private ArrayList<PackComponent> regionContenido;


      /**
     * Default constructor
     */
    public RegionComponent() {
    }
    /**
     * @param nombre
     */
    public RegionComponent(String nombre) {
        super(nombre);
        this.regionContenido=new ArrayList<PackComponent>();
    }

    /**
     * @param component
     */
    @Override
    public void addComponent(PackComponent component) {
            if (component!=null) {
            this.regionContenido.add(component);
        }
    }

    /**
     * @param location 
     * @return
     */
    @Override
    public PackComponent getComponent(int location) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    @Override
    public long getComponentPrecio() {
           long precioOfAllHojas = 0;

        for (Object component : regionContenido) {
            precioOfAllHojas = precioOfAllHojas + (((PackComponent) component).getComponentPrecio());
        }
        return precioOfAllHojas;
    }

    public ArrayList<PackComponent> getRegionContenido() {
        return regionContenido;
    }

    public void setRegionContenido(ArrayList<PackComponent> regionContenido) {
        this.regionContenido = regionContenido;
    }
    

}