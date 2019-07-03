/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.*;

/**
 *
 * @author dawish
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        ArrayList<Cliente> listaClientes= new ArrayList ();
        //Funcionario fun= new Funcionario(listaClientes);
        Cliente c1=new Cliente(123,"Ander", "clae", "12/01/1990", "adr@gmail.com","M", "pomona", "popa", 32413545);
       // fun.addCliente(c1);
        PackComponent principal =  new  RegionComponent ( " Europa " );
        PackComponent pais1 =  new  RegionComponent ( " Italia " );
        PackComponent pais2 =  new  RegionComponent ( " Francia " );
        PackComponent pais3 =  new  RegionComponent ( " España " );

        PackComponent ciudad1 =  new  CityComponent ( " Roma " , 1000000 );
        PackComponent ciudad2 =  new  CityComponent ( " Paris " , 2000000 );
        PackComponent ciudad3 =  new  CityComponent ( " Madrid " , 3000000 );
        PackComponent ciudad4 =  new  CityComponent ( " Valencia " , 2000000 );

       // fun.addPack (pais1);
        //fun.addPack (pais2);
        //fun.addPack (pais3);

        pais1 . addComponent (ciudad1);
        pais2 . addComponent (ciudad2);
        pais3 . addComponent (ciudad3);
        pais3 . addComponent (ciudad4);
        Venta v= new Venta();
       
        
            Pago pago; // Referencia a la clase base
        try {
 
            pago= v.getFabrica().getPago("negocio.PagoContado");
            pago.registrarPago(c1,12342);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
