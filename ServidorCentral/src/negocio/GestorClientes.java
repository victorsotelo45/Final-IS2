/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class GestorClientes {
    
    ArrayList<Cliente> listado;
    private ConectorJdbc conector;
    
    public GestorClientes() {
        listado = new ArrayList();
        conector = new ConectorJdbc();
        inicializar();
    }
    
    public void inicializar() {
        //TODOS LOS CLIENTES   
    }
    
    public ArrayList<Cliente> getListado(){
        return (ArrayList<Cliente>) listado;
    }
    
    public ArrayList<Cliente> consultarClientes() throws ClassNotFoundException, SQLException{
        //TODO Buscar        
          
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM CLIENTE;");
        ArrayList<Cliente> clientes = new ArrayList();

        while (conector.getResultado().next()) {
            Cliente cli = new Cliente(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"),conector.getResultado().getString("fechaNac"), conector.getResultado().getString("email"),conector.getResultado().getString("sexo"),conector.getResultado().getString("direccion"),conector.getResultado().getString("ciudad"),conector.getResultado().getString("celular"));
            clientes.add(cli);
        }
        conector.desconectarse();
        return clientes;
    }
 
    /**
     * agrega un cliente a la base de datos
     *
     * @param id
     * @param nombres
     * @param apellidos
     * @param fechaNac
     * @param direccion
     * @param celular
     * @param ciudad
     * @param email
     * @param sexo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void agregarCliente(String id, String nombres, String apellidos,String fechaNac, String direccion, String celular,String ciudad, String email, String sexo) throws ClassNotFoundException, SQLException {
        System.out.println("Entre agregar gestor");
        conector.conectarse();
        conector.actualizar("INSERT INTO Cliente(id, nombres, apellidos, fechaNac, direccion, celular,ciudad, email, sexo)"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + fechaNac + "',"        
                + "'" + direccion + "',"
                + "'" + celular + "',"
                + "'" + ciudad + "',"
                + "'" + email + "',"
                + "'" + sexo + "'"
                + ")");
        conector.desconectarse();

    }
    
    
}
