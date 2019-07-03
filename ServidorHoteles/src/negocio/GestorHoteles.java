/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class GestorHoteles {
    
    private ArrayList<Hotel> hoteles;

    public GestorHoteles() {
        this.hoteles = new ArrayList<>();
        this.inicializar();
    }
    
    private void inicializar(){
       
        hoteles.add(new Hotel("San Andres","Sol marino", new Habitacion("sencilla", "cama,tv,aire acondicionado", "disponible",25000)));
        hoteles.add(new Hotel("San Andres","Decamerun", new Habitacion("doble", "tv,aire acondicionado", "disponible",35000)));
        hoteles.add(new Hotel("España","Tardes Españolas",new Habitacion("familiar", "dos camas,tv,", "disponible",90000)));
        hoteles.add(new Hotel("España","Tardes Españolas",new Habitacion("doble", "tv,aire acondicionado", "disponible",70000)));
        hoteles.add(new Hotel("California","Hilton",new Habitacion("sencilla", "cama,tv,aire acondicionado, vista a la playa", "disponible",120000)));
        hoteles.add(new Hotel("Itala","Hotel Romal",new Habitacion("doble", "tv,aire acondicionado","disponible",150000)));
        
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }
    
    public ArrayList<Hotel> hotelesCiudad(String ciudad){
        ArrayList<Hotel> hotelesEnCiudad = new ArrayList<>();
        
        for (Hotel hotel : hoteles) {
            if(hotel.getCiudad().equals(ciudad)){
                hotelesEnCiudad.add(hotel);
            }
        }
        return hotelesEnCiudad;
    
    }
    
    
}
