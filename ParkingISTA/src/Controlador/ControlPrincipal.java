package Controlador;

import Modelo.Cliente;
import Vistas.CRUD.VCrud;
import Vistas.VCamara;
import Vistas.VLogin;
import Vistas.VPrincipal;
import java.awt.Dimension;
import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

public class ControlPrincipal {

    private final VLogin vlogin;
    private VPrincipal contenedor;
    private VCamara vcam;
    private VCrud crud;
    private Cliente cone;
    private ControlCrud ventana;

    public ControlPrincipal(VLogin vlogin) {
        this.vlogin = vlogin;
        vlogin.setVisible(true);
        setearIcoJFrame(vlogin, "Login", "Ico_JFrame_20x20");
    }

    public void iniciarcontrol() {
        vlogin.setVisible(true);
        vlogin.getBtn_iniciarsesion().addActionListener(l -> iniciarPrograma());
    }

    public void VentanaCrud() {

        contenedor.getItemUsuario().addActionListener(l -> {
            contenedor.getDtp_principal().removeAll();
            AbrirCrudCliente();

        });
        contenedor.getItemEmpleado().addActionListener(l -> {
            contenedor.getDtp_principal().removeAll();
            AbrirCrudEmpleado();

        });
        contenedor.getItem_salir().addActionListener(l -> cerrarApp());
        contenedor.getItem_logout().addActionListener(l -> iniciarSesion());

    }

    private void iniciarPrograma() {
        contenedor = new VPrincipal();
        vcam = new VCamara();
        ControlCamara controlc = new ControlCamara(vcam);

        controlc.iniciarControl();
        limitarComponente(contenedor.getDtp_principal());
        VentanasJIF(vcam, contenedor.getDtp_principal());
        contenedor.getDtp_principal().add(vcam);
        vlogin.dispose();
        contenedor.setVisible(true);
        CargarIconos();

        VentanaCrud();
    }

    private void AbrirCrudCliente() {

        crud = new VCrud();

        cone = new Cliente();
        ventana = new ControlCrud(crud, cone);
        setearIcoIFrame(crud, "Ingreso de cliente", "icons8_employee_20px");
        ventana.ControlCrud();
        ventana.TableCliente();

        VentanasJIF(crud, contenedor.getDtp_principal());
        contenedor.getDtp_principal().add(crud);
        contenedor.getDtp_principal().updateUI();

    }

    private void AbrirCrudEmpleado() {

        crud = new VCrud();

        cone = new Cliente();
        ventana = new ControlCrud(crud, cone);
        setearIcoIFrame(crud, "Ingreso de empleado", "icons8_employee_20px");
        ventana.ControlCrud();
        ventana.TableEmpleado();
        VentanasJIF(crud, contenedor.getDtp_principal());
        contenedor.getDtp_principal().add(crud);
        contenedor.getDtp_principal().updateUI();

    }

    private void iniciarSesion() {
        contenedor.setVisible(false);
        contenedor.dispose();
        vlogin.setVisible(true);
    }

    private void cerrarApp() {
        contenedor.setVisible(false);
        contenedor.dispose();
        System.exit(0);
    }

    private void CargarIconos() {
        setearIcoJMItem(contenedor.getItemEmpleado(), "icons8_member_20px");
        setearIcoJMItem(contenedor.getItemUsuario(), "icons8_add_user_male_20px");
        setearIcoJMItem(contenedor.getItem_logout(), "icons8_logout_rounded_left_20px");
        setearIcoJMItem(contenedor.getItem_salir(), "icons8_exit_20px");
        setearIcoJFrame(contenedor, "Parking ISTA", "Ico_JFrame_20x20");
        setearIcoIFrame(vcam, "C\u00e1\nmara", "icons8_camera_20px");
    }

////////////////Creacion de metodos para Frames
    /**
     * Añade Icono y Titulo en el JIF pasadon por parametros el nombre del la
     * imagen y el JIF al que se desea asignar.
     *
     * @param IF Nombre del JInternalFram para asigar el titulo e imagen.
     * @param Titulo Titulo del JInternalFrame.
     * @param nomIco Nombre de la imagen en formato .png
     */
    private void setearIcoIFrame(JInternalFrame IF, String Titulo, String nomIco) {
        ImageIcon img = new ImageIcon(getClass().getResource("/Vistas/Iconos/" + nomIco + ".png"));
        IF.setFrameIcon(img);
        IF.setTitle(Titulo);

    }

    /**
     * Añade Icono JMI pasadon por parametros el nombre del la imagen y el JMI
     * al que se desea asignar.
     *
     * @param JMI Nombre del JMenuItem para asigar la imagen.
     * @param Titulo Titulo del JInternalFrame.
     * @param nomIco Nombre de la imagen en formato .png
     */
    private void setearIcoJMItem(JMenuItem JMI, String nomIco) {
        JMI.setIcon(new ImageIcon(getClass().getResource("/Vistas/Iconos/" + nomIco + ".png")));

    }

    /**
     * Añade Icono y Titulo en el JF pasadon por parametros el nombre del la
     * imagen y el JF al que se desea asignar.
     *
     * @param JF Nombre del JInternalFram para asigar el titulo e imagen.
     * @param Titulo Titulo del JInternalFrame.
     * @param nomIco Nombre de la imagen en formato .png
     */
    private void setearIcoJFrame(JFrame JF, String Titulo, String nomIco) {
        JF.setIconImage(new ImageIcon(getClass().getResource("/Vistas/Iconos/" + nomIco + ".png")).getImage());
        JF.setTitle(Titulo);
    }

    /**
     * Setea los JIF que pasen como parametro con opciones de cerar y minimizar
     * centrando el JIF dentro del contenedor pasado por parametro.
     */
    private void VentanasJIF(JInternalFrame IF, JDesktopPane JDP) {
        IF.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        IF.setIconifiable(true);
        IF.setClosable(true);
        Dimension desktopSize = JDP.getSize();
        Dimension jInternalFrameSize = IF.getSize();
        IF.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    //Este metodo es opcional. Solo se hizo para que los internal Frames ocupen los limites del contenedor
    /**
     * Mueve el JComponent y vuelve a pintar las áreas dañadas.
     */
    private void limitarComponente(JDesktopPane desktopPane) {
        DesktopManager manager = new DefaultDesktopManager() {

            @Override
            public void setBoundsForFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
                boolean didResize = (f.getWidth() != newWidth || f.getHeight() != newHeight);
                if (!inBounds((JInternalFrame) f, newX, newY, newWidth, newHeight)) {
                    return;
                }
                f.setBounds(newX, newY, newWidth, newHeight);
                if (didResize) {
                    f.validate();
                }
            }

            protected boolean inBounds(JInternalFrame f, int newX, int newY, int newWidth, int newHeight) {
                if (newX < 0 || newY < 0) {
                    return false;
                }
                if (newX + newWidth > f.getDesktopPane().getWidth()) {
                    return false;
                }
                return newY + newHeight <= f.getDesktopPane().getHeight();
            }
        };
        desktopPane.setDesktopManager(manager);
    }
}
