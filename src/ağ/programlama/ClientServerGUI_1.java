
package ağ.programlama;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

public class ClientServerGUI_1 extends javax.swing.JFrame {

    public static Socket socket = null;
    public static PrintWriter out = null;
    public static Scanner input = null;
    
    
    public ClientServerGUI_1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baslik_yazisi = new javax.swing.JLabel();
        mesaj_giriniz_yazisi = new javax.swing.JLabel();
        mesaj_alani = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gelen_mesajlar_alani = new javax.swing.JTextArea();
        mesaj_giriniz_yazisi1 = new javax.swing.JLabel();
        gonder_butonu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        baslik_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        baslik_yazisi.setText("Client Server");

        mesaj_giriniz_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesaj_giriniz_yazisi.setText("Serverdan Gelen Mesajlar :");

        mesaj_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaj_alaniActionPerformed(evt);
            }
        });

        gelen_mesajlar_alani.setColumns(20);
        gelen_mesajlar_alani.setRows(5);
        jScrollPane1.setViewportView(gelen_mesajlar_alani);

        mesaj_giriniz_yazisi1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesaj_giriniz_yazisi1.setText("Mesaj Giriniz :");

        gonder_butonu.setText("Gönder");
        gonder_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gonder_butonuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesaj_giriniz_yazisi1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(gonder_butonu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mesaj_giriniz_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baslik_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baslik_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesaj_giriniz_yazisi1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesaj_giriniz_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mesaj_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(gonder_butonu)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesaj_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaj_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaj_alaniActionPerformed

    private void gonder_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gonder_butonuActionPerformed
        
        String mesaj = mesaj_alani.getText();
        out.println(mesaj);
        
        String gelenveri = input.nextLine();
        gelen_mesajlar_alani.setText(gelen_mesajlar_alani.getText()+gelenveri+"\n");
        
 
    }//GEN-LAST:event_gonder_butonuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientServerGUI().setVisible(true);
            }
        });
        
        
        
        
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
         } catch (UnsupportedEncodingException ex) {
        }
        
        
        try {
            
            socket =  new Socket("localhost", 1234);
             out = new PrintWriter(socket.getOutputStream(),true);
             input = new Scanner(socket.getInputStream());
            
            Scanner s = new Scanner(System.in);
            while(true){
                
                System.out.println("Gönderilecek mesajı girin: ");
                String mesaj = s.nextLine();
                
                out.println(mesaj);
                
                String gelenveri = input.nextLine();
                System.out.println("Sunucudan gelen mesaj: "+gelenveri);
                
            }
            
            
        } catch (IOException ex) {
            System.out.println("Sunucuya bağlanamadı.Hata mesajı:" + ex.getMessage());
            System.exit(1);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Bağlantı kapatılamadı!" + ex.getMessage());
                System.exit(1);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baslik_yazisi;
    private static javax.swing.JTextArea gelen_mesajlar_alani;
    private javax.swing.JButton gonder_butonu;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField mesaj_alani;
    private javax.swing.JLabel mesaj_giriniz_yazisi;
    private javax.swing.JLabel mesaj_giriniz_yazisi1;
    // End of variables declaration//GEN-END:variables
}
