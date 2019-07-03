package negocio;

import java.util.*;

/**
 * 
 */
public class CityTour {
    
    private String[] tours;
    
     /**
     * Default constructor
     */
    public CityTour() {
    }

    public CityTour(String[] tours) {
        this.tours = tours;
    }

    public String[] getTours() {
        return tours;
    }

    public void setTours(String[] tours) {
        this.tours = tours;
    }

   

}