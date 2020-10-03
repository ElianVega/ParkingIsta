package Controlador;

import Modelo.Automovil;
import Modelo.Cliente;
import Modelo.ClienteAutoBD;
import Modelo.Empleado;
import Modelo.Color;
import Modelo.RegistroEmpleado;
import Vistas.CRUD.VCrud;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class ControlCrud {

    private VCrud crud;
    private Cliente cliente;
    
    SpinnerNumberModel HorasE = new SpinnerNumberModel();
    SpinnerNumberModel MinutosE= new SpinnerNumberModel();
    SpinnerNumberModel HorasS = new SpinnerNumberModel();
    SpinnerNumberModel MinutosS = new SpinnerNumberModel();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    Automovil auto = new Automovil();
    Color colores = new Color();
    ClienteAutoBD mostrar = new ClienteAutoBD();
    Empleado mostrarEmpleado = new Empleado();
    private JDialog dlg = new JDialog();

    public ControlCrud(VCrud crud, Cliente cliente) {
        this.crud = crud;
        this.cliente = cliente;
        this.crud.setVisible(true);
        
    }

    public void ControlCrud() {
        crud.getBtn_agregar().addActionListener(l -> AbrirDailogos());
        crud.getBtn_guardar().addActionListener(l -> GuardarCliente());
        crud.getBtn_guardarAdmin().addActionListener(l -> GuardarEmpleado());
        crud.getBtn_atrasAdmin().addActionListener(l -> cerrarDialogos());
        crud.getBtn_atras1().addActionListener(l -> cerrarDialogos());
    }

    public void DialogoUsuario() {
        CargarCombo();
        crud.getjDUsuario().setTitle("Ingreso de Cliente");
        crud.getjDUsuario().setSize(735, 460);
        crud.getjDUsuario().setLocationRelativeTo(crud);
        crud.getjDUsuario().setModal(true);
        crud.getjDUsuario().setVisible(true);
    }

    public void cerrarDialogos() {
        crud.getjDUsuario().dispose();
        crud.getjDPersonal().dispose();
    }

    public void DialogoEmpleado() {
        crud.getjDPersonal().setVisible(true);
        crud.getjDPersonal().setTitle("Ingreso Empleado");
        crud.getjDPersonal().setLocationRelativeTo(crud);
        HorasE.setMaximum(23);
        MinutosE.setMaximum(59);
        HorasE.setMinimum(00);
        MinutosE.setMinimum(00);
        HorasS.setMaximum(23);
        MinutosS.setMaximum(59);
        HorasS.setMinimum(00);
        MinutosS.setMinimum(00);
        crud.getEntradaHoras1().setModel(HorasE);
        crud.getSalidaHoras1().setModel(HorasS);
        crud.getEntradaMinutos1().setModel(MinutosE);
        crud.getSalidaMinutos1().setModel(MinutosS);
        crud.getjDPersonal().setSize(600, 350);
    }

    public void AbrirDailogos() {
        if (crud.getTitle().equalsIgnoreCase("Ingreso de Cliente")) {
            crud.getjDUsuario().dispose();
            DialogoUsuario();
        }
        if (crud.getTitle().equalsIgnoreCase("Ingreso de Empleado")) {
            crud.getjDPersonal().dispose();
            DialogoEmpleado();
        }
    }

    //Cargar combobox
    public void CargarCombo() {
        cliente.CargarComboTipo(crud.getJCombotipo());
        auto.CargarComboMarca(crud.getjComboMarca());
        colores.CargarComboColor(crud.getjComboColor());
        crud.getjComboMarca().addItemListener(l -> auto.CargarComboModelo(crud.getjComboModelo(), (String) crud.getjComboMarca().getSelectedItem()));
    }
    
    
    public void TableCliente(){
        DefaultTableModel mtdTable;
        mtdTable = (DefaultTableModel) crud.getJtb_registros().getModel();
        String []columnas = {"Cedula", "Nombre", "Apellido", "Celular", "Tipo", "Placa", "Marca", "Modelo", "Color"};
        mtdTable.addColumn("Cedula");mtdTable.addColumn("Nombre");mtdTable.addColumn("Apellido");mtdTable.addColumn("Celular");mtdTable.addColumn("Tipo");
        mtdTable.addColumn("Placa");mtdTable.addColumn("Marca");mtdTable.addColumn("Modelo");mtdTable.addColumn("Color");
        List<ClienteAutoBD> listaTable  = mostrar.MostrarCliente();
        mtdTable.setRowCount(0);
        listaTable.forEach(p -> {
            String Fila[]= {p.getCedula(), p.getNombre(), p.getApellido(), p.getCelular(), p.getTipoCliente(), p.getPlaca(), p.getMarca(), p.getModelo(), p.getColor()};
            mtdTable.addRow(Fila);
        });
        
    }
    
    public void TableEmpleado(){
        DefaultTableModel mtdTable;
        mtdTable = (DefaultTableModel) crud.getJtb_registros().getModel();
        String []columnas = {"Cedula", "Nombre", "Apellido", "Celular", "Tipo", "Placa", "Marca", "Modelo", "Color"};
        mtdTable.addColumn("Cedula");mtdTable.addColumn("Nombre");mtdTable.addColumn("Apellido");mtdTable.addColumn("Celular");
        mtdTable.addColumn("Hora de Entrada");mtdTable.addColumn("Hora de Salida");
        List<Empleado> listaTable  = mostrarEmpleado.MostrarEmpleado();
        mtdTable.setRowCount(0);
        listaTable.forEach(p -> {
            String Fila[]= {p.getCedula(), p.getNombre(), p.getApellido(), p.getCelular(), String.valueOf(p.getHoraEntradaPre()), String.valueOf(p.getHoraSalidaPre())};
            mtdTable.addRow(Fila);
        });
    }
    //Recuperar Datos Cliente
    public void GuardarCliente() {
        
        String cedula = crud.getCedula().getText();
        String nombre = crud.getNombre().getText();
        String apellido = crud.getApellido().getText();
        String celular = crud.getCelular().getText();
        String correo = crud.getCorreo().getText();
        String Fecha = sdf.format(crud.getJDateFecha().getDate());
        Date fechaNacimiento = Date.valueOf(Fecha);
        String sexo = (String) crud.getjComboSexo().getSelectedItem();
        String marca = (String) crud.getjComboMarca().getSelectedItem();
        String modelo = (String) crud.getjComboModelo().getSelectedItem();
        String color = (String) crud.getjComboColor().getSelectedItem();
        String placa = crud.getPlaca().getText();

        Cliente prueba = new Cliente(0, cedula, 0, cedula, nombre, apellido, celular, correo, sexo, fechaNacimiento, 0);
        prueba.InsertarPersona();
        Cliente insertarCliente = new Cliente(cedula, (String) crud.getJCombotipo().getSelectedItem());
        insertarCliente.InsertarCliente();
        Automovil insertarAuto = new Automovil(placa, null, 0, 0);
        insertarAuto.InsertarAutomovil(marca, modelo, cedula, color);
        
        TableCliente();
    }

    //Guardar empleado
    public void GuardarEmpleado() {

        String cedula = crud.getTxtCedulaAdmin().getText();
        String nombre = crud.getTxtNombreAdmin().getText();
        String apellido = crud.getTxtApellidoAdmin().getText();
        String celular = crud.getTxtCelularAdmin().getText();
        String correo = crud.getTxtCorreoAdmin().getText();
        String Fecha = sdf.format(crud.getjDateFechaAdmin().getDate());
        Date fechaNacimiento = Date.valueOf(Fecha);
        String sexo = (String)crud.getjComboSexoAdmin().getSelectedItem();
        String entradaHora = crud.getEntradaHoras1().getValue().toString() + ":" +crud.getEntradaMinutos1().getValue().toString() + ":" + 00;
        Time horaEntrada = Time.valueOf(entradaHora);
        String salidaHora = crud.getSalidaHoras1().getValue().toString() + ":" +crud.getSalidaMinutos1().getValue().toString() + ":" + 00;
        Time horaSalida = Time.valueOf(salidaHora);
        String clave = ObtenerClave();
        
        RegistroEmpleado registro = new RegistroEmpleado(0, cedula, clave);
        registro.InsertarUsuario();
        Empleado insertarPersona = new Empleado(0, cedula, null, null, 0, cedula, nombre, apellido, celular, correo, sexo, fechaNacimiento, 0);
        insertarPersona.InsertarPersona();
        Empleado insertarEmpleado = new Empleado(cedula, horaEntrada, horaSalida, registro.ObtenerCodigo(cedula));
        insertarEmpleado.InsertarEmpleado();
        
        TableEmpleado();
    }

    public boolean validarCampos() {
        return crud.getTxtCedulaAdmin().getText().isEmpty();
    }
    
    public String ObtenerClave(){
        String guardarClave = "";
        char[] recorrerClave = crud.getClave1().getPassword();
        for (int i = 0; i < recorrerClave.length; i++) {
            guardarClave += recorrerClave[i];
        }
        return guardarClave;
    }
    /**
     * Muestra un dialogo con el mensaje que pasemos por el parametro 'mensaje',
     * puede usarse cuando se registra, edita, elimina o se quiere dar cualquier
     * instrucción al usuario.
     * @param tiempo Tiempo que tarda el dialogo en pantalla inglesado en
     * milisegundos
     * @param mensaje Texto a mostrar en el dialogo emergente
     *
     */
    private void mostrarDIalogo(int tiempo, String mensaje) {
        JOptionPane opt;
        opt = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{});
        dlg = opt.createDialog(mensaje);
        dlg.setTitle("");
        new Thread(() -> {
            try {
                Thread.sleep(tiempo);
                dlg.dispose();
            } catch (InterruptedException th) {
                System.out.println("error mostrando mensaje" + th);
            }
        }).start();
        dlg.setVisible(true);
    }

}
