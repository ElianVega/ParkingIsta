
package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;


public class Cliente extends Persona{
    ConexionDB conectar = new ConexionDB();
    private int codCliente;
    private String cedulaCliente;
    private int codTipoCliente;
    private String tipoCliente;
    public Cliente() {
    }

    public Cliente(int codCliente, String cedulaCliente, int codTipoCliente, String Cedula, String Nombre, String Apellido, String Celular, String Correo, String Sexo, Date fechaNacimiento, int edad) {
        super(Cedula, Nombre, Apellido, Celular, Correo, Sexo, fechaNacimiento, edad);
        this.codCliente = codCliente;
        this.cedulaCliente = cedulaCliente;
        this.codTipoCliente = codTipoCliente;
    }

    public Cliente(String cedulaCliente, String tipoCliente) {
        this.cedulaCliente = cedulaCliente;
        this.tipoCliente = tipoCliente;
    }

    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(int codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
    //consultas SQL
    public boolean InsertarPersona(){
        String sql;
        sql = "Insert into persona";
        sql += " (cedula, nombre, apellido, celular, correo, sexo, fecha_nacimiento, edad)";
        sql += " VALUES('"+getCedula()+"','"+getNombre()+"','"+getApellido()+"','"+getCelular()+"','"+getCorreo()+"','"+getSexo()+"',TO_DATE('"+getFechaNacimiento()+"','YYYY-MM-DD'),"+getEdad()+")";
        if (conectar.noQuery(sql)==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public void CargarComboTipo(JComboBox comboTipo){
        try {
            String sql = "select * from tiposclientes";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                comboTipo.addItem(rs.getString("tipo_cliente"));
            }
        } catch (SQLException ex) {
            System.out.println("error combo");
        }
    }
    
    public boolean InsertarCliente(){
        String sql, sqlTipo;
        
        try {
            sqlTipo = "select cod_tipo from tipo_cliente where tipo_cliente ='"+getTipoCliente()+"'";
            ResultSet rs = conectar.query(sqlTipo);
            while (rs.next()) {                
                setCodTipoCliente(rs.getInt("cod_tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "Insert into cliente";
        sql += " (cedula_cliente, cod_tipo_cliente)";
        sql += " values('"+getCedulaCliente()+"',"+getCodTipoCliente()+")";
        if (conectar.noQuery(sql)==null) {
            return true;
        }else{
            return false;
        }
    }
    
    
}
