/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Func.Hyrid_Encryption;
import Network.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Comfirm_Account extends javax.swing.JFrame {

    String email = "pnmthuan@gmail.com";
    Socket s = null;
    String randomKey = "";
    PublicKey pKeyServer = null;
    int code = 0;
    ReadCLient readClient = null;
    String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbPndbAp25koChNaXO9XfZHLBEVKWedG5c2Inio657AePBaYzYISc2ucXwHDzn+xJsFbthGzyt+CYsnVdrtwpVB3Pv7TpWnj2W2l0yG5vrOjsUERVBaC+6Mk1+RNXRimqxCJDtJTtXeB9/bZGXBe4WcPXUhwIB563JPyAGTyeVnwIDAQAB";

    /**
     * Creates new form Register
     */
    public Comfirm_Account() {
        initComponents();
        this.setLocationRelativeTo(null);
        email_input.setEnabled(false);
        email_input.setText(email);
        initSocket();

    }

    public Comfirm_Account(String email) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.email = email;
        System.out.println("Gui mail " + this.email);
        email_input.setEnabled(false);
        email_input.setText(email);
        initSocket();
    }

    public void initSocket() {
        try {
            s = new Socket(Config.HOST, Config.PORT);

            //Tao random key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example
            SecretKey secretKey = keyGen.generateKey();
            randomKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            pKeyServer = Hyrid_Encryption.getPublicKeyRSA(PUBLIC_KEY_STRING);
            readClient = new ReadCLient(s, randomKey, code, time_remain, this);

            Thread getOTP = new Thread(new getOTP(s, email, randomKey, pKeyServer));
            Thread read = new Thread(readClient);

            getOTP.start();
            read.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server. Vui lòng khởi động lại chương trình [" + ex.getMessage() + "]");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        otp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        email_input = new javax.swing.JTextField();
        resendOTPBtn = new javax.swing.JButton();
        time_remain = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4291178-200.png"))); // NOI18N

        confirmBtn.setBackground(new java.awt.Color(51, 153, 255));
        confirmBtn.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        confirmBtn.setText("Xác Nhận");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("OTP:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setText("XÁC NHẬN");

        otp.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Xác nhận cho email : ");

        email_input.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        resendOTPBtn.setFont(new java.awt.Font("Arimo", 0, 24)); // NOI18N
        resendOTPBtn.setText("Gửi lại");
        resendOTPBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resendOTPBtnMouseClicked(evt);
            }
        });

        time_remain.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        time_remain.setText("03:02");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Thời gian còn lại : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addGap(44, 44, 44)
                                .addComponent(time_remain, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(resendOTPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resendOTPBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time_remain, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        code = readClient.getConfirmCode();
        if (code == 0) {
            JOptionPane.showMessageDialog(null, "Lỗi. Vui lòng nhấn nút gửi lại");
            time_remain.setText("0");
            return;
        }

        if (Integer.valueOf(time_remain.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Mã code xác nhận đã hết hạn vui lòng gửi lại mã code");
        } else if (otp.getText().compareTo(String.valueOf(code)) != 0) {
            JOptionPane.showMessageDialog(null, "Mã code xác nhận không chính xác");
        } else {
            new Thread(new ActiveAccount(s, email, randomKey, pKeyServer)).start();
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void resendOTPBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendOTPBtnMouseClicked
        // TODO add your handling code here:
        if (Integer.valueOf(time_remain.getText()) != 0) {
            JOptionPane.showMessageDialog(null, "Bạn phải chờ hết thời gian để gủi lại mã xác nhận");
            return;
        }

        new Thread(new getOTP(s, email, randomKey, pKeyServer)).start();
    }//GEN-LAST:event_resendOTPBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Comfirm_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comfirm_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comfirm_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comfirm_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comfirm_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField otp;
    private javax.swing.JButton resendOTPBtn;
    private javax.swing.JLabel time_remain;
    // End of variables declaration//GEN-END:variables

}

class getOTP implements Runnable {

    String email;
    Socket socket = null;
    String randomKey = "";
    PublicKey pKeyServer = null;

    public getOTP(Socket s, String email, String rdKey, PublicKey pKey) {
        this.email = email;
        this.socket = s;
        this.randomKey = rdKey;
        this.pKeyServer = pKey;
    }

    @Override
    public void run() {
        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            HashMap<String, String> maps = new HashMap<>();

            //Khoi tao data          
            maps.put("command", "RESEND_OTP");
            maps.put("data", email);

            //Ma hoa du lieu
            String data = new Gson().toJson(maps);
            data = Hyrid_Encryption.encryptAES(data, randomKey);
            //Ma hoa randomkey
            String encryptRandomKey = Hyrid_Encryption.encryptRSA(randomKey, pKeyServer);
            //Tao du lieu gui den server                     
            HashMap<String, String> sendServer = new HashMap<>();
            sendServer.put("key", encryptRandomKey);
            sendServer.put("value", data);
            String strSend = new Gson().toJson(sendServer);

            output.write(strSend);
            output.newLine();
            output.flush();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server. Vui lòng khởi động lại chương trình [" + ex.getMessage() + "]");
        }
    }
}

class ReadCLient implements Runnable {

    Socket s;
    String randomKey = "";
    int ConfirmCode = 0;
    JLabel label;
    JFrame frame;

    public ReadCLient(Socket s, String rdKey, int code, JLabel lb, JFrame j) {
        this.s = s;
        this.randomKey = rdKey;
        this.ConfirmCode = code;
        this.label = lb;
        this.frame = j;
    }

    public int getConfirmCode() {
        return ConfirmCode;
    }

    @Override
    public void run() {
        BufferedReader bufferRead = null;
        try {
            bufferRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                String input = bufferRead.readLine();
                if (input == null) {
                    continue;
                }

                //Giai ma du lieu
                input = Hyrid_Encryption.decryptAES(input, randomKey);
                //ep kieu thanh hashmap
                HashMap<String, String> maps = new Gson().fromJson(input, new TypeToken<HashMap<String, String>>() {
                }.getType());
                System.out.println(maps);
                switch (maps.get("command")) {
                    case "RESEND_OTP": {
                        ConfirmCode = Integer.valueOf(maps.get("code"));
                        JOptionPane.showMessageDialog(null, "Đã gửi Email kich hoạt");
                        //Dem nguoc thoi gian
                        Thread countDown = new Thread(new CountDown(label));
                        countDown.start();
                        break;
                    }
                    case "ACTIVE_ACCOUNT": {
                        String result = maps.get("result");
                        JOptionPane.showMessageDialog(null, result);

                        if (result.compareTo("Kích hoạt tài khoản thành công") == 0) {
                            frame.dispose();
                            new Login().setVisible(true);
                        }
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server. Vui lòng khởi động lại chương trình [" + ex.getMessage() + "]");
        }
    }
}

class CountDown implements Runnable {

    JLabel label = null;

    public CountDown(JLabel lb) {
        this.label = lb;
    }

    @Override
    public void run() {
        try {
            int time = 600;
            while (time >= 0) {

                label.setText(String.valueOf(time--));
                Thread.sleep(1000);

            }
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi thời gian hệ thống");
        }
    }

}

class ActiveAccount implements Runnable {

    String email;
    Socket socket = null;
    String randomKey = "";
    PublicKey pKeyServer = null;

    public ActiveAccount(Socket s, String email, String rdKey, PublicKey pKey) {
        this.email = email;
        this.socket = s;
        this.randomKey = rdKey;
        this.pKeyServer = pKey;
    }

    @Override
    public void run() {
        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            HashMap<String, String> maps = new HashMap<>();

            //Khoi tao data          
            maps.put("command", "ACTIVE_ACCOUNT");
            maps.put("data", email);

            //Ma hoa du lieu
            String data = new Gson().toJson(maps);
            data = Hyrid_Encryption.encryptAES(data, randomKey);
            //Ma hoa randomkey
            String encryptRandomKey = Hyrid_Encryption.encryptRSA(randomKey, pKeyServer);
            //Tao du lieu gui den server                     
            HashMap<String, String> sendServer = new HashMap<>();
            sendServer.put("key", encryptRandomKey);
            sendServer.put("value", data);
            String strSend = new Gson().toJson(sendServer);

            output.write(strSend);
            output.newLine();
            output.flush();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến server. Vui lòng khởi động lại chương trình [" + ex.getMessage() + "]");
        }
    }
}
