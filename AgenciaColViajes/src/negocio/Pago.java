package negocio;


/**
 * 
 */
public abstract class Pago {

    protected long valor;
    protected Cliente cliente;   
    
    /**
     * Default constructor
     */
    public Pago() {
    }

    public Pago(int valor, Cliente cliente) {
        this.valor = valor;
        this.cliente = cliente;
    }
    

    /**
     * @param cliente
     */
    public void Pago(Cliente cliente) {
        // TODO implement here
    }

    public abstract void registrarPago(Cliente cliente,long valor);

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

}