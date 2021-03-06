/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.DialogDajPobocku;
import core.Pobocka;
import splay.InformacnySystem;
import splay.Node;

/**
 *
 * @author tomas
 */
public class FrameKnihy extends javax.swing.JFrame {

    private InformacnySystem informacnySystem;
    
    public FrameKnihy(InformacnySystem informacnySystem) {
        this.informacnySystem=informacnySystem;
        this.setLocation(500,500);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVypisKnih = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEvidenciaKnih = new javax.swing.JTextArea();
        btnPridajKnihu = new javax.swing.JToggleButton();
        btnNajdiKnihu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Evidencia kníh");

        btnVypisKnih.setText("Výpis kníh (7)");
        btnVypisKnih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVypisKnihActionPerformed(evt);
            }
        });

        txtEvidenciaKnih.setColumns(20);
        txtEvidenciaKnih.setRows(5);
        jScrollPane1.setViewportView(txtEvidenciaKnih);

        btnPridajKnihu.setText("Pridanie Knihy (10)");
        btnPridajKnihu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPridajKnihuActionPerformed(evt);
            }
        });

        btnNajdiKnihu.setText("Nájdi knihu (1)");
        btnNajdiKnihu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNajdiKnihuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVypisKnih)
                        .addGap(18, 18, 18)
                        .addComponent(btnPridajKnihu)
                        .addGap(18, 18, 18)
                        .addComponent(btnNajdiKnihu)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVypisKnih)
                    .addComponent(btnPridajKnihu)
                    .addComponent(btnNajdiKnihu))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVypisKnihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVypisKnihActionPerformed
        /*txtEvidenciaKnih.setText("");
        DialogDajPobocku dialog=new DialogDajPobocku(this);
        String nazov =dialog.getNazovPobocky();   
        nazov=dialog.getNazovPobocky();
        if(nazov!=null){
        Pobocka pomPob=new Pobocka(nazov);       
        Node hladany=informacnySystem.getPobocky().search(new Node(pomPob));
        if(hladany!=null){
           // txtEvidenciaKnih.append(((Pobocka)hladany.getData()).getKnihy().InOrderPrint());
            txtEvidenciaKnih.append(((Pobocka)hladany.getData()).getKnihyNazvov().InOrderPrint());
        }
        else{
             txtEvidenciaKnih.append("Pobocka neexistuje");
        }
        }*/
       
    }//GEN-LAST:event_btnVypisKnihActionPerformed

    private void btnPridajKnihuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPridajKnihuActionPerformed
       // DialogPridajKnihu dialog=new DialogPridajKnihu(this, rootPaneCheckingEnabled,informacnySystem);
        
    }//GEN-LAST:event_btnPridajKnihuActionPerformed

    private void btnNajdiKnihuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNajdiKnihuActionPerformed
       /*DialogNajdiKnihu dialog=new DialogNajdiKnihu(this, rootPaneCheckingEnabled);
       int idKnihy=dialog.getIdKnihy();
       String  nazovPobocky=dialog.getNazovPobocky();         
       txtEvidenciaKnih.setText(informacnySystem.najdiKnihu(idKnihy, nazovPobocky).udaje());*/
    }//GEN-LAST:event_btnNajdiKnihuActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNajdiKnihu;
    private javax.swing.JToggleButton btnPridajKnihu;
    private javax.swing.JButton btnVypisKnih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtEvidenciaKnih;
    // End of variables declaration//GEN-END:variables
}
