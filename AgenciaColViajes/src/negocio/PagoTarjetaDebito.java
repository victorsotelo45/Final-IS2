package negocio;

/**
 * 
 */
public class PagoTarjetaDebito extends Pago {

    private int codigo;
    private String banco;
    private long numCuenta;
    /**
     * Default constructor
     */
    public PagoTarjetaDebito() {
    }

    public PagoTarjetaDebito(int codigo, String banco, long numCuenta) {
        this.codigo = codigo;
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    

      /**
     * 
     * @param cliente
     * @param valor
     */
    @Override
    public void registrarPago(Cliente cliente,long valor) {
        this.setCliente(cliente);
        this.setValor(valor);
    }
    public void registrarPago(Cliente cliente,long valor,int codigo, String banco, long numCuenta){
        registrarPago(cliente,valor);
        this.setBanco(banco);
        this.setCodigo(codigo);
        this.setNumCuenta(numCuenta);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }
    

 

}