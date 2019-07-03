package negocio;

import java.util.*;
import mvcf.AModel;

/**
 * 
 */
public class Funcionario extends AModel{

    private String userName;
    private String passWord;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Venta> ventas;



    /**
     * Default constructor
     */
    public Funcionario(ArrayList<Cliente> lista,ArrayList<Venta> ventas) {
        this.listaClientes=lista;
        this.ventas=ventas;
    }

    /**
     * @param cliente
     */
    public void addCliente(Cliente cliente) {
        if (cliente!=null) {
            this.listaClientes.add(cliente);
        }
    }

    /**
     * @param cliente
     */
    public void editarCliente(Cliente cliente) {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarCliente() {
        // TODO implement here
    }

    /**
     * @param cliente
     */
    public void eliminarCliente(Cliente cliente) {
        // TODO implement here
    }

    /**
     * @param pack
     */
    public void addPack(PackComponent pack) {
        // TODO implement here
    }

    /**
     * @param pack
     */
    public void eliminarPack(PackComponent pack) {
        // TODO implement here
    }

    /**
     * @param pack
     */
    public void consultarPack(PackComponent pack) {
        // TODO implement here
    }

    /**
     * @param pack
     */
    public void editarPack(PackComponent pack) {
        // TODO implement here
    }

    /**
     * @param venta
     */
    public void addVenta(Venta venta) {
        
    }

    /**
     * @param venta
     */
    public void editarVenta(Venta venta) {
        // TODO implement here
    }

    /**
     * @param venta
     */
    public void consultarVenta(Venta venta) {
        // TODO implement here
    }

    /**
     * @param venta
     */
    public void eliminarVenta(Venta venta) {
        // TODO implement here
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    

}