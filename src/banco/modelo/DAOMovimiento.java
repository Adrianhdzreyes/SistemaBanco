
package banco.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DAOMovimiento {
   
    public int insertar(java.sql.Date fecha, double monto,int no_cuenta){
        String q = "INSERT INTO Movimiento(fecha, monto , no_cuenta)" + "VALUES ('"
                                                                      + fecha + "','"
                                                                      + monto +"','"
                                                                      + no_cuenta + "')";
        return new Database().actualizar(q);
    }
    
    public int actualizar (double id_movimiento,java.sql.Date fecha, double monto,int no_cuenta){
        
        String q="UPDATE Movimiento SET fecha='"
                + fecha + "',monto='"
                + monto + "',no_cuenta='"
                + no_cuenta + "' WHERE id_movimiento='"
                + id_movimiento + "'";
        return new Database().actualizar(q);
    }
    
    public List obtenerRegistros(double no_cuenta){
        String q  = "SELECT * FROM movimiento WHERE no_cuenta='"
                + no_cuenta +"'";
        
        List<Map> registros = new Database().ejecutar(q); 
        List<Movimiento> movimientos = new ArrayList();
             for(Map registro : registros){
                     Movimiento movimiento = new Movimiento((Integer)registro.get("id_movimiento"),
                    (java.sql.Date)registro.get("fecha"),(Double)registro.get("monto"),
                    (Integer)registro.get("no_cuenta"));
           
            movimientos.add(movimiento);   
            }
         return movimientos;
    }
    
    public boolean Transferir(double no_cuenta ,double no_cuentadestino,double monto){
        String q = "sp_transferir("
               + no_cuenta + ","
               + no_cuentadestino + ","
               + monto + ")";
        return new Database().ejecutarProcedimiento(q);
        
    }
    
    public boolean Deposito(double no_cuenta , double monto){
        String q = "sp_insertarMovimiento("
                + no_cuenta +","
                + monto + ")";
              
        return new Database().ejecutarProcedimiento(q);
        
    }
    
    public boolean Retiro(double no_cuenta , double monto){
        String q = "sp_insertarMovimiento("
                + no_cuenta +","
                + monto + ")";
              
        return new Database().ejecutarProcedimiento(q);
        
    }

    
    public int eliminar(int id_movimiento){
    String q = "DELETE FROM cuenta WHERE id_movimiento='"
                                         + id_movimiento + "'";
    
    return new Database().actualizar(q);
    }
}
