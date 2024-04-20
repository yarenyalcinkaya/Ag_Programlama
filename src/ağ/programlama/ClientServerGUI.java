package ağ.programlama;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ClientServerGUI extends javax.swing.JFrame {

    public static Socket socket = null;
    public static PrintWriter out = null;
    public static Scanner input = null;

    public ClientServerGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        baslik_yazisi = new javax.swing.JLabel();
        mesaj_giriniz_yazisi = new javax.swing.JLabel();
        mesaj_alani = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        gelen_mesajlar_alani = new javax.swing.JTextArea();
        mesaj_giriniz_yazisi1 = new javax.swing.JLabel();
        gonder_butonu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ağ/programlama/resim.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        baslik_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        baslik_yazisi.setText("  CLİENT SERVER");
        getContentPane().add(baslik_yazisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 6, 283, 55));

        mesaj_giriniz_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesaj_giriniz_yazisi.setText("SERVER'DAN GELEN MESAJLAR:");
        getContentPane().add(mesaj_giriniz_yazisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 219, 255, 42));

        mesaj_alani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaj_alaniActionPerformed(evt);
            }
        });
        getContentPane().add(mesaj_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 144, 597, 63));

        gelen_mesajlar_alani.setColumns(20);
        gelen_mesajlar_alani.setRows(5);
        jScrollPane1.setViewportView(gelen_mesajlar_alani);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 279, 606, 56));

        mesaj_giriniz_yazisi1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesaj_giriniz_yazisi1.setText("MESAJ GİRİNİZ:");
        getContentPane().add(mesaj_giriniz_yazisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 96, 164, 42));

        gonder_butonu.setText("GÖNDER");
        gonder_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gonder_butonuActionPerformed(evt);
            }
        });
        getContentPane().add(gonder_butonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 347, -1, 34));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ağ/programlama/yaren.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesaj_alaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaj_alaniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaj_alaniActionPerformed

    private void gonder_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gonder_butonuActionPerformed

        String mesaj = mesaj_alani.getText();
        if (mesaj.equals("")) {
            JOptionPane.showMessageDialog(null, "Boş mesaj giremezsiniz.");
        } else {
            out.println(mesaj);

            String gelenveri = input.nextLine();
            gelen_mesajlar_alani.setText(gelen_mesajlar_alani.getText() + gelenveri + "\n");

        }


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

            socket = new Socket("localhost", 1234);
            out = new PrintWriter(socket.getOutputStream(), true);
            input = new Scanner(socket.getInputStream());

            Scanner s = new Scanner(System.in);
            while (true) {

                System.out.println("Gönderilecek mesajı girin: ");
                String mesaj = s.nextLine();

                out.println(mesaj);

                String gelenveri = input.nextLine();
                System.out.println("Sunucudan gelen mesaj: " + gelenveri);

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField mesaj_alani;
    private javax.swing.JLabel mesaj_giriniz_yazisi;
    private javax.swing.JLabel mesaj_giriniz_yazisi1;
    // End of variables declaration//GEN-END:variables
}
