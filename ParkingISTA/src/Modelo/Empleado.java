
package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Empleado extends Persona{
    private int codEmpleado;
    private String cedualEmpleado;
    private Time horaEntradaPre;
    private Time horaSalidaPre;
    private int codRegistro;
    ConexionDB conectar = new ConexionDB();

    public Empleado() {
    }

    public Empleado(int codEmpleado, String cedualEmpleado, Time horaEntradaPre, Time horaSalidaPre, int codRegistro, String Cedula, String Nombre, String Apellido, String Celular, String Correo, String Sexo, Date fechaNacimiento, int edad) {
        super(Cedula, Nombre, Apellido, Celular, Correo, Sexo, fechaNacimiento, edad);
        this.codEmpleado = codEmpleado;
        this.cedualEmpleado = cedualEmpleado;
        this.horaEntradaPre = horaEntradaPre;
        this.horaSalidaPre = horaSalidaPre;
        this.codRegistro = codRegistro;
    }
    
    public Empleado(String cedualEmpleado, Time horaEntradaPre, Time horaSalidaPre, int codRegistro) {
        this.cedualEmpleado = cedualEmpleado;
        this.horaEntradaPre = horaEntradaPre;
        this.horaSalidaPre = horaSalidaPre;
        this.codRegistro = codRegistro;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getCedualEmpleado() {
        return cedualEmpleado;
    }

    public void setCedualEmpleado(String cedualEmpleado) {
        this.cedualEmpleado = cedualEmpleado;
    }

    public Time getHoraEntradaPre() {
        return horaEntradaPre;
    }

    public void setHoraEntradaPre(Time horaEntradaPre) {
        this.horaEntradaPre = horaEntradaPre;
    }

    public Time getHoraSalidaPre() {
        return horaSalidaPre;
    }

    public void setHoraSalidaPre(Time horaSalidaPre) {
        this.horaSalidaPre = horaSalidaPre;
    }

    public int getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
    }
    
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
    
    public boolean InsertarEmpleado(){
        String sql;
        sql = "Insert into empleado";
        sql += " (cedula_empleado, hora_entrada_predeterminada, hora_salida_predeterminada, cod_registro)";
        sql += "VALUES ('"+getCedualEmpleado()+"', TO_TIMESTAMP('"+getHoraEntradaPre()+"', 'HH24:MI:SS'), TO_TIMESTAMP('"+getHoraSalidaPre()+"', 'HH24:MI:SS'), "+getCodRegistro()+")";
        if (conectar.noQuery(sql)==null) {
            return true;
        }else{
            return false;
        }
    }
    
    public List<Empleado> MostrarEmpleado(){ 
        try {
            String sql = "select * from empleado_tabla";
            ResultSet rs = conectar.query(sql);
            List<Empleado> listaTabla = new ArrayList<Empleado>();
            while(rs.next()){
                Empleado empleadoTable = new Empleado();
                empleadoTable.setCedula(rs.getString(1));
                empleadoTable.setNombre(rs.getString(2));
                empleadoTable.setApellido(rs.getString(3));
                empleadoTable.setCelular(rs.getString(4));
                String horaentrada = rs.getString("horadeentrada");
                String horasalida = rs.getString("horadesalida");
                empleadoTable.setHoraEntradaPre(Time.valueOf(horaentrada + ":" + 00));
                empleadoTable.setHoraSalidaPre(Time.valueOf(horasalida + ":" + 00));
                listaTabla.add(empleadoTable);
            }
            rs.close();
            return listaTabla;
        } catch (Exception e) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }      
    }
    
}
