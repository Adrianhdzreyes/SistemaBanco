
package banco.modelo;

public class Cuenta {
    private int no_cuenta;
    private String tipo;
    private double saldo;
    private String rfc;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(int no_cuenta, String tipo, double saldo, String rfc) {
        this.no_cuenta = no_cuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.rfc = rfc;
    }

    public Cuenta(int no_cuenta, String tipo, double saldo, String rfc, Cliente cliente) {
        this.no_cuenta = no_cuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.rfc = rfc;
        this.cliente = cliente;
    }

      
    
    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    public String toString(){
     
      return  String.valueOf(no_cuenta);
    }
    
     
    
    
}
