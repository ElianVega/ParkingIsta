
package Modelo;

import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteAutoBD extends Cliente{
    private String placa;
    private String marca;
    private String modelo;
    private String color;

    ConexionDB conectar = new ConexionDB();

    public ClienteAutoBD() {
    }
    
    public ClienteAutoBD(String placa, String marca, String modelo, String color, int codCliente, String cedulaCliente, int codTipoCliente, String Cedula, String Nombre, String Apellido, String Celular, String Correo, String Sexo, Date fechaNacimiento, int edad) {
        super(codCliente, cedulaCliente, codTipoCliente, Cedula, Nombre, Apellido, Celular, Correo, Sexo, fechaNacimiento, edad);
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public List<ClienteAutoBD> MostrarCliente(){
        try {
            String sql = "select * from cliente_tabla";
            ResultSet rs = conectar.query(sql);
            List<ClienteAutoBD> listaTabla = new ArrayList<ClienteAutoBD>();
            while(rs.next()){
                ClienteAutoBD clienteTabla = new ClienteAutoBD();
                clienteTabla.setCedula(rs.getString("cedula"));
                clienteTabla.setNombre(rs.getString("nombre"));
                clienteTabla.setApellido(rs.getString("apellido"));
                clienteTabla.setCelular(rs.getString("celular"));
                clienteTabla.setTipoCliente(rs.getString("tipo_cliente"));
                clienteTabla.setPlaca(rs.getString("placa"));
                clienteTabla.setMarca(rs.getString("marca"));
                clienteTabla.setModelo(rs.getString("modelo"));
                clienteTabla.setColor(rs.getString("color"));
                listaTabla.add(clienteTabla);
                
            }
            rs.close();
            return listaTabla;
        } catch (Exception e) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  
    }
}
