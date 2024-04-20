package ağ.programlama;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ServerGUI extends javax.swing.JFrame {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    
    public ServerGUI() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        baslik_yazisi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gelen_mesajlar_alani = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        baglantilar_alani = new javax.swing.JTextArea();
        mesajlar_yazisi = new javax.swing.JLabel();
        baglantilar_yazisi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 750, 600));

        baslik_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        baslik_yazisi.setText("SERVER");

        gelen_mesajlar_alani.setEditable(false);
        gelen_mesajlar_alani.setColumns(20);
        gelen_mesajlar_alani.setRows(5);
        jScrollPane1.setViewportView(gelen_mesajlar_alani);

        baglantilar_alani.setEditable(false);
        baglantilar_alani.setColumns(20);
        baglantilar_alani.setRows(5);
        jScrollPane2.setViewportView(baglantilar_alani);

        mesajlar_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesajlar_yazisi.setText("Gelen Mesajlar :");

        baglantilar_yazisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        baglantilar_yazisi.setText("Bağlı Cihazlar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baslik_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(baglantilar_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mesajlar_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(baslik_yazisi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesajlar_yazisi)
                    .addComponent(baglantilar_yazisi))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
        
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
         } catch (UnsupportedEncodingException ex) {
        }
        
        
        try {
            
            serverSocket = new ServerSocket(1234);
            System.out.println("Server olusturuldu baglantı bekleniyor");
            clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress().getHostName() + " baglandi");
            baglantilar_alani.setText(baglantilar_alani.getText()+clientSocket.toString()+"\n");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner input = new Scanner(clientSocket.getInputStream());

            Scanner s = new Scanner(System.in);

            while (true) {

                String gelenveri = input.nextLine();
                String log = gelenveri;
                System.out.println(clientSocket.getInetAddress().getHostName() + "'dan gelen mesaj: " + gelenveri);
                gelen_mesajlar_alani.setText(gelen_mesajlar_alani.getText()+" "+log+"\n");
                out.println(gelenveri.toUpperCase());

            }
            
        } catch (IOException ex) {
            System.out.println("Baglanti saglanamadi." + ex.getMessage());
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                System.out.println("Bağlantı kapatılamadı!" + ex.getMessage());
                System.exit(1);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea baglantilar_alani;
    private javax.swing.JLabel baglantilar_yazisi;
    private static javax.swing.JLabel baslik_yazisi;
    private static javax.swing.JTextArea gelen_mesajlar_alani;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mesajlar_yazisi;
    // End of variables declaration//GEN-END:variables
}
