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
public class GestorUsuarios {
    ArrayList<FuncionarioAgencia> listado;
    private ConectorJdbc conector;

    public GestorUsuarios() {
        this.conector = new ConectorJdbc();
    }

    public GestorUsuarios(ArrayList<FuncionarioAgencia> listado, ConectorJdbc conector) {
        this.listado = listado;
        this.conector = conector;
    }
    
    public ArrayList<FuncionarioAgencia> consultarUsuarios() throws ClassNotFoundException, SQLException{
        //TODO Buscar        
          
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM USUARIO;");
        ArrayList<FuncionarioAgencia> usuarios = new ArrayList();

        while (conector.getResultado().next()) {
            FuncionarioAgencia usu = new FuncionarioAgencia(conector.getResultado().getString("username"), conector.getResultado().getString("password"),conector.getResultado().getString("nombre_completo"));
            usuarios.add(usu);
        }
        conector.desconectarse();
        return usuarios;
    }
    
}
