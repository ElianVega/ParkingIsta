
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RegistroEmpleado {
    private int codRegistro;
    private String usuario;
    private String clave;
    ConexionDB conectar = new ConexionDB();
    public RegistroEmpleado() {
    }

    public RegistroEmpleado(int codRegistro, String usuario, String clave) {
        this.codRegistro = codRegistro;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean InsertarUsuario(){
        String sql;
        sql = "Insert into registro";
        sql += " (usuario, clave)";
        sql += "VALUES ('"+getUsuario()+"', '"+getClave()+"')";
        if (conectar.noQuery(sql)==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public int ObtenerCodigo(String cedula){
        int codRegistro = 0;
        try {
            String sql = "select cod_registro from registro where usuario = '"+cedula+"'";
            ResultSet rs = conectar.query(sql);
            while (rs.next()) {
                codRegistro = (rs.getInt("cod_registro"));
            }
        } catch (SQLException ex) {
            System.out.println("codigo");
        }
        return codRegistro;
    }
}
