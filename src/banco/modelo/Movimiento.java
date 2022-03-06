
package banco.modelo;

import java.sql.*;

public class Movimiento {
   private int id_movimiento;
   private Date fecha;
   private double monto;
   private  int no_cuenta;
   private int no_cuentadestino;

    public Movimiento() {
    }

    public Movimiento(int id_movimiento, Date fecha, double monto, int no_cuenta) {
        this.id_movimiento = id_movimiento;
        this.fecha = fecha;
        this.monto = monto;
        this.no_cuenta = no_cuenta;
    }

    public Movimiento(int id_movimiento, Date fecha, double monto, int no_cuenta, int no_cuentadestino) {
        this.id_movimiento = id_movimiento;
        this.fecha = fecha;
        this.monto = monto;
        this.no_cuenta = no_cuenta;
        this.no_cuentadestino = no_cuentadestino;
    }
    
    

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(int no_cuenta) {
        this.no_cuenta = no_cuenta;
    }
    
    public int getNo_cuentadestino() {
        return no_cuentadestino;
    }

    public void setNo_cuentadestino(int no_cuentadestino) {
        this.no_cuentadestino = no_cuentadestino;
    }
   
   
}
