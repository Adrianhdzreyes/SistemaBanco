
package banco.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAOCliente {
    public Cliente insertar(String rfc,String nombre,String ciudad){
        String q ="INSERT INTO Cliente VALUES('"
                + rfc + "','"
                + nombre + "','"
                +ciudad + "')";
       if(new Database().actualizar(q) > 0){
            return new Cliente(rfc,nombre,ciudad);
        }
        return null;
    }
    
    public int actualizar(String rfc,String nombre,String ciudad){
        String q = "UPDATE Cliente SET nombre='"
                + nombre + "',ciudad='"
                + ciudad + "' WHERE rfc='"
                + rfc + "'";
        return new Database().actualizar(q);
    }
    
    public Cliente obtenerRegistro(String rfc){
        String q = "SELECT * FROM cliente_cuentas WHERE RFC='"
                + rfc+ "'";
        List<Map> registros = new Database().ejecutar(q);
        Cliente cliente= null;
        for(Map registro : registros){
           cliente = new Cliente((String)registro.get("rfc"),
                    (String)registro.get("nombre"),(String)registro.get("ciudad"),(Integer)registro.get("cuentas"));
        }
        return cliente;
    }
    
    public List obtenerRegistros(){
        String q = "SELECT * FROM cliente_cuentas";
        List<Map> registros = new Database().ejecutar(q);    
        List<Cliente> clientes = new ArrayList();
         for(Map registro : registros){
          Cliente cliente = new Cliente((String)registro.get("rfc"),
                    (String)registro.get("nombre"),(String)registro.get("ciudad"),(Integer)registro.get("cuentas"));
          clientes.add(cliente);
         }
        return clientes;
    }
    
    public List obtenerRegistros(String ciudad){
        String q = "SELECT * FROM cliente_cuentas WHERE ciudad='" + ciudad + "'";
        List<Map> registros = new Database().ejecutar(q);    
        List<Cliente> clientes = new ArrayList();
         for(Map registro : registros){
          Cliente cliente = new Cliente((String)registro.get("rfc"),
                    (String)registro.get("nombre"),(String)registro.get("ciudad"),(Integer)registro.get("cuentas"));
          clientes.add(cliente);
         }
        return clientes;
    }
    
    public int eliminar(String rfc){
        String q = "DELETE FROM cliente WHERE rfc='"
                    + rfc + "'";
    return new Database().actualizar(q);
    }
    
}
