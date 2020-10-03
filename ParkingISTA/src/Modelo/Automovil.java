
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;


public class Automovil {
    private String placa;
    private String color;
    private int marca;
    private int codCliente;
    ConexionDB conectar = new ConexionDB();

    public Automovil() {
    }

    public Automovil(String placa, String color, int marca, int codCliente) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.codCliente = codCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    //Sentencias SQL
    public boolean InsertarAutomovil(String Marca, String Modelo, String Cedula, String color){
        String sql, sqlMarca, sqlCodCliente, sqlColor;
        try {
            sqlMarca = "select cod_marca from marca where marca = '"+Marca+"' and modelo = '"+Modelo+"'";
            ResultSet rs = conectar.query(sqlMarca);
            while (rs.next()) {                
                setMarca(rs.getInt("cod_marca"));
            }
            System.out.println(getMarca());
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            sqlCodCliente = "select cod_cliente from cliente where cedula_cliente = '"+Cedula+"'";
            ResultSet rs = conectar.query(sqlCodCliente);
            while (rs.next()) {                
                setCodCliente(rs.getInt("cod_cliente"));
            }
            System.out.println(getCodCliente());
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            sqlColor = "select cod_color from vehiculo_color where color = '"+color+"'";
            ResultSet rs = conectar.query(sqlColor);
            while (rs.next()) {                
                setColor(rs.getString("cod_color"));
            }
            System.out.println(getColor());
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        sql = "Insert into automovil";
        sql += " (placa, cod_color, cod_marca, cod_cliente)";
        sql += " values('"+getPlaca()+"','"+getColor()+"',"+getMarca()+","+getCodCliente()+")";
        if (conectar.noQuery(sql)==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public void CargarComboMarca(JComboBox comboMarca){
        try {
            String sql = "select * from marcaauto";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                comboMarca.addItem(rs.getString("marca"));
            }
        } catch (SQLException ex) {
            System.out.println("error combo");
        }
    }
    
    public void CargarComboModelo(JComboBox comboModelo, String marca){
        comboModelo.removeAllItems();
        try {
            String sql = "select modelo from marca where marca = '"+marca+"'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                comboModelo.addItem(rs.getString("modelo"));
            }
        } catch (SQLException ex) {
            System.out.println("error combo");
        }
    }
}
