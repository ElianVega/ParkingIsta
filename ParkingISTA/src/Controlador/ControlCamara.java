
package Controlador;

import Vistas.VCamara;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javaanpr.gui.ReportGenerator;
import javaanpr.imageanalysis.CarSnapshot;
import javaanpr.imageanalysis.Char;
import javaanpr.intelligence.Intelligence;
import javaanpr.recognizer.NeuralPatternClassificator;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ControlCamara {
    
    private VCamara Vcamara;

    public ControlCamara(VCamara Vcamara) {
        this.Vcamara = Vcamara;
        this.Vcamara.setVisible(true);
    }
    //Conexion de la camara
    Dimension dimension = new Dimension(360,300);//dimensiones de el cuadro de la camara
    Dimension dimension1 = WebcamResolution.VGA.getSize();//Depende de la camara  //hay otro de hd720
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcampanel = new WebcamPanel(webcam, dimension, false);
    
    String TextoReconocido = "";
    BufferedImage ruta;    
    
    public void iniciarControl(){
        ApagarBotones();
        Vcamara.getBtnIniciar().addActionListener(l-> InicializarCamara());
        Vcamara.getBtnApagar().addActionListener(l-> ApagarCamara());
        Vcamara.getBtnTomarFoto().addActionListener(l-> CapturarFoto());
        Vcamara.getBtnGuardarFoto().addActionListener(l-> GuardarFoto());
    }
    
    public void InicializarCamara(){
        webcam.setViewSize(dimension1);
        webcampanel.setFillArea(true);
        Vcamara.getPanelCamara().setLayout(new FlowLayout());
        Vcamara.getPanelCamara().add(webcampanel);
        Vcamara.getLbNombreCamara().setText(webcam.toString());
        IniciarBtnCamara();
    }
    
    public void ApagarBotones(){
        Vcamara.getBtnIniciar().setEnabled(true);
        Vcamara.getBtnApagar().setEnabled(false);
        Vcamara.getBtnTomarFoto().setEnabled(false);
        Vcamara.getBtnGuardarFoto().setEnabled(false);
    }
    
    public void PrenderBotones(){
        Vcamara.getBtnApagar().setEnabled(true);
        Vcamara.getBtnTomarFoto().setEnabled(true);
    }
    
    public void IniciarBtnCamara(){
        Thread hilo = new Thread(){
            @Override
            public void run(){
                webcampanel.start();
                PrenderBotones();
            } 
        };
        hilo.setDaemon(true);
        hilo.start();
        Vcamara.getBtnIniciar().setEnabled(false);
    }
    
    public void ApagarCamara(){
        webcampanel.stop();
        ApagarBotones();
        Vcamara.getLbFotoTomada().setIcon(null);
    }
    
    public void CapturarFoto(){
        Vcamara.getBtnGuardarFoto().setEnabled(true);
        
        ImageIcon Foto;
        Foto = new ImageIcon(webcam.getImage());
        Icon IconoFoto=new ImageIcon(Foto.getImage().getScaledInstance(Vcamara.getLbFotoTomada().getWidth(), Vcamara.getLbFotoTomada().getHeight(), Image.SCALE_SMOOTH));
        Vcamara.getLbFotoTomada().setIcon(IconoFoto);
        
        ruta= webcam.getImage();        
    }
    
    public void GuardarFoto(){
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Guardar Fotografia?","PREGUNTA",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        
        if(pregunta == 0){
            
            File salidaImagen = new File("Foto.jpg");
            
            try{
                ImageIO.write(ruta, "jpg", salidaImagen);
                JOptionPane.showMessageDialog(null, "Imagen guardada en: "+ salidaImagen.getAbsolutePath());
            }catch(HeadlessException | IOException e){
                System.out.println("Error: "+e);                
            }
            
            Vcamara.getLbFotoTomada().setIcon(null);
            Vcamara.getBtnGuardarFoto().setEnabled(false);
            AbrirFoto(null);
            VldarTxtPlaca();
        }
    }
    
    
    //Inteligencia y sus metodos
    //Variables Necesarias para la comprobación
//    String TextoReconocido = "";
//    BufferedImage ruta;
    
    boolean valiPlaca = false ;
    private static final long serialVersionUID = 0;           
    CarSnapshot car;   
    //Fin Variables
        //Proceso Inteligencia
    public static ReportGenerator rg = new ReportGenerator();
    public static Intelligence systemLogic;

    public static void newAlphabet(String srcdir, String dstdir) throws Exception { // NOT USED
        File folder = new File(srcdir);
        if (!folder.exists()) throw new IOException("Source folder doesn't exists");
        if (!new File(dstdir).exists()) throw new IOException("Destination folder doesn't exists");
        int x = Intelligence.configurator.getIntProperty("char_normalizeddimensions_x");
        int y = Intelligence.configurator.getIntProperty("char_normalizeddimensions_y");
        System.out.println("\nCreating new alphabet ("+x+" x "+y+" px)... \n");
        for (String fileName : folder.list()) {
            Char c = new Char(srcdir+File.separator+fileName);
            c.normalize();
            c.saveImage(dstdir+File.separator+fileName);
            System.out.println(fileName+" done");
        }
    }
    
    public static void learnAlphabet(String destinationFile) throws Exception {
        try {
            File f = new File(destinationFile);
            f.createNewFile();
        } catch (Exception e) {
            throw new IOException("Can't find the path specified");
        }
        System.out.println();
        NeuralPatternClassificator npc = new NeuralPatternClassificator(true);
        npc.network.saveToXml(destinationFile);
    }   
    //Metodos para Inteligencia
    public void AbrirFoto(String DireccionFoto){//Direccion de donde abrira la imagen
        DireccionFoto = ("Foto1.jpg");
        try {
            car = new CarSnapshot(DireccionFoto);
            }catch (IOException ex){
                ex.printStackTrace();
                System.out.println("aca de una");
            }
        ReconocerPlaca();
    }
    
    public void ReconocerPlaca(){
            try {
                TextoReconocido = systemLogic.recognize(car);
                Vcamara.getLbPlacaObtenida().setText(TextoReconocido);
                if(!TextoReconocido.equals("")){
                    valiPlaca = true;
                }
            } catch (Exception ex) {
                Vcamara.getLbPlacaObtenida().setText("Placa Invalida");
                valiPlaca = false;
                System.out.println("o aca");
            }
    }        
    //Fin proceso Inteligencia
    public void ProcesoVerificacion(){
//        TextoReconocido = LbPlacaObtenida.getText();
        valiPlaca = true;
        VldarTxtPlaca();   
    }
    
    public void VldarTxtPlaca(){
        
        if(valiPlaca == false){
            //GifEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Animaciones/EntradaDenegada.png")));
            Vcamara.getLbEntrada().setText("Entrada Denegada");
        }else{
            //GifEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Animaciones/EntradaPermitida.gif")));
            Vcamara.getLbEntrada().setText("Entrada Permitida");
        }
    }    
    //Fin Inteligencia
    
}
