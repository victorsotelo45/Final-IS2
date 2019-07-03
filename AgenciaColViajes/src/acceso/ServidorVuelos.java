package acceso;

import java.util.*;

/**
 * 
 */
public interface ServidorVuelos {

    /**
     * @param fecha1 
     * @param fecha2 
     * @param origen 
     * @param destino
     */
    public void getInfoVuelo(String fecha1, String fecha2, String origen, String destino);

}