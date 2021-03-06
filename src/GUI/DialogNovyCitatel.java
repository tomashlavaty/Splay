/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import splay.InformacnySystem;

/**
 *
 * @author tomas
 */
public class DialogNovyCitatel extends javax.swing.JDialog {

    private InformacnySystem informacnySystem;
    
    public DialogNovyCitatel(java.awt.Frame parent, boolean modal,InformacnySystem informacnySystem) {
        super(parent, modal);
        this.informacnySystem=informacnySystem;
        initComponents();
        this.setLocationRelativeTo(parent);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMeno = new javax.swing.JLabel();
        lblPriezvisko = new javax.swing.JLabel();
        txtVstupMeno = new javax.swing.JTextField();
        txtVstupPriezvisko = new javax.swing.JTextField();
        txtVstupCisPreukazu = new javax.swing.JTextField();
        lblCisloPreukazu = new javax.swing.JLabel();
        btnPridaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMeno.setText("meno");

        lblPriezvisko.setText("priezvisko");

        lblCisloPreukazu.setText("čislo preukazu");

        btnPridaj.setText("Pridaj");
        btnPridaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPridajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPriezvisko, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMeno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCisloPreukazu, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVstupCisPreukazu, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtVstupMeno)
                            .addComponent(txtVstupPriezvisko)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnPridaj)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVstupCisPreukazu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCisloPreukazu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVstupMeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMeno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVstupPriezvisko)
                    .addComponent(lblPriezvisko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPridaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPridajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridajActionPerformed
               informacnySystem.pridajCitatela(txtVstupMeno.getText(), txtVstupPriezvisko.getText());
               //informacnySystem.pridajCitatela(txtVstupMeno.getText(), txtVstupPriezvisko.getText(), txtVstupCisPreukazu.getText());
               this.dispose();
    }//GEN-LAST:event_btnPridajActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPridaj;
    private javax.swing.JLabel lblCisloPreukazu;
    private javax.swing.JLabel lblMeno;
    private javax.swing.JLabel lblPriezvisko;
    private javax.swing.JTextField txtVstupCisPreukazu;
    private javax.swing.JTextField txtVstupMeno;
    private javax.swing.JTextField txtVstupPriezvisko;
    // End of variables declaration//GEN-END:variables
}
