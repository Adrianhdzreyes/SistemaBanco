package banco.modelo;

import java.sql.*;
import java.util.*;
   
public class Database {
    private final String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL ="jdbc:sqlserver://DESKTOP-SUH7FLC:1433;databaseName=Banco";
    private final String USER="sa";
    private final String PASSWORD="sasa";
    private Connection conexion;
    
    
    public Database(){
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection( URL, USER, PASSWORD);
         }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
    }   
    
    public int actualizar(String consulta){
        try{
            Statement st = conexion.createStatement();
            return st.executeUpdate(consulta);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public List ejecutar(String consulta){
        ResultSet rs = null;
        List resultado = new ArrayList();
        try{
            Statement st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            resultado = acomodarDatos(rs);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    private List acomodarDatos(ResultSet rs){
        List renglones = new ArrayList();
        try{
            int cantColumnas = rs.getMetaData().getColumnCount();
            while(rs.next()){
               Map<String,Object>renglon=new HashMap();
               for(int i=1;i<= cantColumnas;i++){
                   String nombreCampo = rs.getMetaData().getColumnName(i);
                   Object valor = rs.getObject(nombreCampo);
                   renglon.put(nombreCampo,valor);
                }
               renglones.add(renglon);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return renglones;
    }
    
    public boolean ejecutarProcedimiento (String nombre){
        try{
            CallableStatement cs = conexion.prepareCall("{call " + nombre + " }");
           return cs.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
       return false; 
    }
     
    
    public void cerrarConexion(){
         try{
             conexion.close();
         }catch(SQLException e){
            e.printStackTrace();
        }   
    }
    

}