/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Cliente;
import negocio.GestorClientes;
import negocio.GestorUsuarios;
import negocio.FuncionarioAgencia;

/**
 *
 * @author David
 */
public class ServidorCentralServer implements Runnable{
    private final GestorClientes gesClientes;
    private final GestorUsuarios gesUsuarios;
    
    private static ServerSocket ssock;
    private static Socket socket;

    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private static final int PUERTO = 5000;

    /**
     * Constructor
     */
    public ServidorCentralServer() {
        this.gesClientes = new GestorClientes();
        this.gesUsuarios = new GestorUsuarios();
    }
    /**
     * Logica completa del servidor
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() {
        new Thread(new ServidorCentralServer()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorCentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() throws ClassNotFoundException, SQLException {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición 
     */
    private void decodificarPeticion(String peticion) throws ClassNotFoundException, SQLException {
        System.out.println(peticion);
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Segun el protocolo decide qué accion invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) throws ClassNotFoundException, SQLException {
        switch (accion) {
            case "consultarClientes":
                ArrayList<Cliente> clientes;
                clientes = gesClientes.consultarClientes();
                salidaDecorada.println(serializarClientes(clientes));
                break;
            case "consultarUsuarios":
                ArrayList<FuncionarioAgencia> usuarios;
                usuarios = gesUsuarios.consultarUsuarios();
                salidaDecorada.println(serializarUsuarios(usuarios));
                break;
            case "agregarCliente":
                System.out.println("Estoy en agregar cliente del servidor");
                gesClientes.agregarCliente(parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], parametros[6], parametros[7], parametros[8], parametros[9]);
                salidaDecorada.println("Si");
                break;
        }
    }
    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    /**
     * Convierte el objeto Ciudadano a json
     *
     * @param listado de clientes
     * @return cadena json
     */
    private String serializarClientes(ArrayList<Cliente> listado) {       
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        for (Cliente myCliente : listado) {
            gsonObj = new JsonObject();
            gsonObj.addProperty("id", myCliente.getIdentificacion());
            gsonObj.addProperty("nombres", myCliente.getNombre());
            gsonObj.addProperty("apellidos", myCliente.getApellidos());
            gsonObj.addProperty("fechaNac", "" + myCliente.getFechaNac());            
            gsonObj.addProperty("email", "" + myCliente.getEmail());
            gsonObj.addProperty("genero", "" + myCliente.getGenero());
            gsonObj.addProperty("direccion", "" + myCliente.getDireccion());
            gsonObj.addProperty("ciudad", "" + myCliente.getCiudad());
            gsonObj.addProperty("celular", "" + myCliente.getCelular());
            array.add(gsonObj);
        }
        System.out.println("Clientes json serializado: " + array.toString());
        return array.toString();
    }
    private String serializarUsuarios(ArrayList<FuncionarioAgencia> listado) {       
        JsonArray array = new JsonArray();
        JsonObject gsonObj;
        for (FuncionarioAgencia usuario : listado) {
            gsonObj = new JsonObject();
            gsonObj.addProperty("nombre_completo", usuario.getNombre());
            gsonObj.addProperty("username", usuario.getUsername());
            gsonObj.addProperty("password", usuario.getPassword());
            array.add(gsonObj);
        }
        System.out.println("Usuarios json serializado: " + array.toString());
        return array.toString();
    }
}
