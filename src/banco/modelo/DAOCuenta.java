
package banco.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAOCuenta {
    
    public boolean insertar(String rfc,String nombre, String ciudad,String tipo,double monto){
        String q = "sp_crearCuenta('"
                + rfc + "','"
                + nombre + "','"
                + ciudad + "','"
                + tipo + "','"
                + monto + "')";
        
        return new Database().ejecutarProcedimiento(q);
        
    }
    
    public int actualizar(double no_cuenta, String tipo, double saldo, String rfc){
        String q = "UPDATE cuenta SET tipo='"
                + tipo + "' , saldo='"
                + saldo +  "' , rfc ='"
                + rfc + "' WHERE no_cuenta='"
                + no_cuenta + "'";
        return new Database().actualizar(q);
    }
    
    public Cuenta obtenerRegistro(double no_cuenta){
        String q ="SELECT * FROM cuenta_cliente WHERE no_cuenta ='"
                + no_cuenta + "'";
        
         List<Map> registros = new Database().ejecutar(q); 
         Cuenta cuenta = null;
         for(Map registro : registros){
            cuenta = new Cuenta((Integer)registro.get("no_cuenta"),
                    (String)registro.get("tipo"),((java.math.BigDecimal)registro.get("saldo")).doubleValue(),
                    (String)registro.get("rfc"));
            
            Cliente clt = new Cliente((String)registro.get("rfc"),(String)registro.get("nombre"),
                                      (String)registro.get("ciudad"));
            
            cuenta.setCliente(clt);
            }
         return cuenta;
    }
    
    public List obtenerRegistros(){
    String q = "SELECT * FROM cuenta_cliente";
     List<Map> registros = new Database().ejecutar(q); 
     List<Cuenta> cuentas = new ArrayList();
         for(Map registro : registros){
           Cuenta cuenta = new Cuenta((Integer)registro.get("no_cuenta"),
                    (String)registro.get("tipo"),((java.math.BigDecimal)registro.get("saldo")).doubleValue(),
                    (String)registro.get("rfc"));
           
            Cliente clt = new Cliente((String)registro.get("rfc"),(String)registro.get("nombre"),
                                      (String)registro.get("ciudad"));
            
            cuenta.setCliente(clt);
            cuentas.add(cuenta);   
            }
         return cuentas;
    }
    
    public List obtenerRegistros(String rfc){
    String q = "SELECT * FROM cuenta_cliente WHERE rfc='"
                                           +rfc + "'";
     List<Map> registros = new Database().ejecutar(q); 
     List<Cuenta> cuentas = new ArrayList();
         for(Map registro : registros){
           Cuenta cuenta = new Cuenta((Integer)registro.get("no_cuenta"),
                    (String)registro.get("tipo"),((java.math.BigDecimal)registro.get("saldo")).doubleValue(),
                    (String)registro.get("rfc"));
           
            Cliente clt = new Cliente((String)registro.get("rfc"),(String)registro.get("nombre"),
                                      (String)registro.get("ciudad"));
            
            cuenta.setCliente(clt);
            cuentas.add(cuenta);   
            }
         return cuentas;
    }
    
    public int eliminar(int no_cuenta){
    String q = "DELETE FROM cuenta WHERE no_cuenta='"
                                         + no_cuenta + "'";
    
    return new Database().actualizar(q);
    }
    
    
}
