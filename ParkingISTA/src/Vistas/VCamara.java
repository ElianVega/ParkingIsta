
package Vistas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public final class VCamara extends javax.swing.JInternalFrame{

    
    public VCamara() {
        initComponents();
    }      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnApagar = new javax.swing.JButton();
        BtnIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LbNombreCamara = new javax.swing.JLabel();
        BtnGuardarFoto = new javax.swing.JButton();
        BtnTomarFoto = new javax.swing.JButton();
        PanelCamara = new javax.swing.JPanel();
        LbFotoTomada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LbEntrada = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LbPropietario = new javax.swing.JLabel();
        LbPlacaObtenida = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(121, 151, 177), 4, true));
        setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        setMaximumSize(new java.awt.Dimension(887, 432));
        setMinimumSize(new java.awt.Dimension(887, 432));
        setName(""); // NOI18N
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Arial", 0, 18))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(223, 376));
        jPanel1.setMinimumSize(new java.awt.Dimension(223, 376));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnApagar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/ApagarCamara.png"))); // NOI18N
        BtnApagar.setText("Apagar");
        BtnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApagarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 200, 70));

        BtnIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/EncenderCamara.png"))); // NOI18N
        BtnIniciar.setText("INICIAR");
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 70));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Camara en uso");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 122, -1));

        LbNombreCamara.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        LbNombreCamara.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbNombreCamara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(LbNombreCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, 90));

        BtnGuardarFoto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnGuardarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/GuardarFoto.png"))); // NOI18N
        BtnGuardarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarFotoActionPerformed(evt);
            }
        });

        BtnTomarFoto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnTomarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Iconos/TomarFoto.png"))); // NOI18N
        BtnTomarFoto.setMaximumSize(new java.awt.Dimension(168, 80));
        BtnTomarFoto.setMinimumSize(new java.awt.Dimension(168, 80));
        BtnTomarFoto.setPreferredSize(new java.awt.Dimension(168, 80));
        BtnTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTomarFotoActionPerformed(evt);
            }
        });

        PanelCamara.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(7, 64, 115), 4, true));
        PanelCamara.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        PanelCamara.setMaximumSize(new java.awt.Dimension(360, 300));
        PanelCamara.setMinimumSize(new java.awt.Dimension(360, 300));

        javax.swing.GroupLayout PanelCamaraLayout = new javax.swing.GroupLayout(PanelCamara);
        PanelCamara.setLayout(PanelCamaraLayout);
        PanelCamaraLayout.setHorizontalGroup(
            PanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        PanelCamaraLayout.setVerticalGroup(
            PanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        LbFotoTomada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbFotoTomada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Placa");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 4, true));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Propietario");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 4, true));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LbPropietario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LbPropietario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LbPropietario.setText("-");

        LbPlacaObtenida.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LbPlacaObtenida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LbPlacaObtenida.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnTomarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LbPlacaObtenida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbFotoTomada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(LbPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnTomarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnGuardarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbFotoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addComponent(LbPlacaObtenida)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbPropietario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarFotoActionPerformed
        // TODO add your handling code here:                     
    }//GEN-LAST:event_BtnGuardarFotoActionPerformed
            
    private void BtnTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTomarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnTomarFotoActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnApagarActionPerformed

    
    //Getters y Setters
       
    public JButton getBtnApagar() {
        return BtnApagar;
    }

    public void setBtnApagar(JButton BtnApagar) {
        this.BtnApagar = BtnApagar;
    }

    public JButton getBtnGuardarFoto() {
        return BtnGuardarFoto;
    }

    public void setBtnGuardarFoto(JButton BtnGuardarFoto) {
        this.BtnGuardarFoto = BtnGuardarFoto;
    }

    public JButton getBtnIniciar() {
        return BtnIniciar;
    }

    public void setBtnIniciar(JButton BtnIniciar) {
        this.BtnIniciar = BtnIniciar;
    }

    public JButton getBtnTomarFoto() {
        return BtnTomarFoto;
    }

    public void setBtnTomarFoto(JButton BtnTomarFoto) {
        this.BtnTomarFoto = BtnTomarFoto;
    }
    
    public JPanel getPanelCamara() {
        return PanelCamara;
    }

    public void setPanelCamara(JPanel PanelCamara) {
        this.PanelCamara = PanelCamara;
    }

    public JLabel getLbFotoTomada() {
        return LbFotoTomada;
    }

    public void setLbFotoTomada(JLabel LbFotoTomada) {
        this.LbFotoTomada = LbFotoTomada;
    }
 
    public JLabel getLbNombreCamara() {
        return LbNombreCamara;
    }

    public void setLbNombreCamara(JLabel LbNombreCamara) {
        this.LbNombreCamara = LbNombreCamara;
    }  
    
    public JLabel getLbEntrada() {
        return LbEntrada;
    }

    public void setLbEntrada(JLabel LbEntrada) {
        this.LbEntrada = LbEntrada;
    }

    public JLabel getLbPlacaObtenida() {
        return LbPlacaObtenida;
    }

    public void setLbPlacaObtenida(JLabel LbPlacaObtenida) {
        this.LbPlacaObtenida = LbPlacaObtenida;
    }

    public JLabel getLbPropietario() {
        return LbPropietario;
    }

    public void setLbPropietario(JLabel LbPropietario) {
        this.LbPropietario = LbPropietario;
    }    
    //Fin Getters y Setters
    
    
    //    
//    /**
//     * @param args the command line arguments
//     * @throws java.lang.Exception
//     */
//    public static void main(String args[]) throws Exception {
//        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VCamara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VCamara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VCamara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VCamara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VCamara().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnApagar;
    private javax.swing.JButton BtnGuardarFoto;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JButton BtnTomarFoto;
    private javax.swing.JLabel LbEntrada;
    private javax.swing.JLabel LbFotoTomada;
    private javax.swing.JLabel LbNombreCamara;
    private javax.swing.JLabel LbPlacaObtenida;
    private javax.swing.JLabel LbPropietario;
    private javax.swing.JPanel PanelCamara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
