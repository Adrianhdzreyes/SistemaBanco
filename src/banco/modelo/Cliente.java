
package banco.modelo;

public class Cliente {
    private String rfc;
    private String nombre;
    private String ciudad;
    private int cuentas;
    public Cliente() {
    }

    public Cliente(String rfc, String nombre, String ciudad) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Cliente(String rfc, String nombre, String ciudad, int cuentas) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cuentas = cuentas;
    }
    
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCuentas() {
        return cuentas;
    }

    public void setCuentas(int cuentas) {
        this.cuentas = cuentas;
    }
    
    public String toString(){
        return nombre;
    }
    
    
   
}
