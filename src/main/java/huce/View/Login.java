/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import huce.Controller.LoginController;
import huce.Model.Account;
import huce.Model.AdminAccount;
import huce.Model.ApplyPanel;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Login extends javax.swing.JPanel {

    static Account loginAccount = null;

    public String getUsername() {
        return this.jTextUserName.getText();
    }

    public String getPassword() {
        return new String(this.jTextPassword.getPassword());
    }

    public void addLoginListener(ActionListener event) {
        this.jLogin.addActionListener(event);
    }

    public void showError() {
        this.jinformLabelLogin.setText("Tài khoản mật khẩu không chính xác.");
    }

    /**
     * Creates new form Login
     */
    public Login(JPanel gobackPanel) {
        initComponents();
        this.addLoginListener((e) -> {
            LoginController loginController = new LoginController();
            Account account = loginController.login(jTextUserName.getText(), new String(
                    jTextPassword.getPassword()));
            if (account == null) {
                this.jinformLabelLogin.setText("Tài khoản mật khẩu không chính xác");
            } else {
                loginAccount = account;
                if (account instanceof AdminAccount) {
                    var warehouse = new WarehousePanel();
                    warehouse.addLogoutListener((evt -> {
                        ApplyPanel.apply(gobackPanel, new Login(gobackPanel));
                    }));

                    ApplyPanel.apply(gobackPanel, warehouse);

                } else {
                    ApplyPanel.apply(gobackPanel, new FormRequest());
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        jTextUserName = new javax.swing.JTextField();
        javax.swing.JPanel jPanel5 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jTextPassword = new javax.swing.JPasswordField();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        jShowPassword = new javax.swing.JCheckBox();
        jinformLabelLogin = new javax.swing.JLabel();
        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        jLogin = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        jPanel3.setLayout(new java.awt.GridLayout(0, 1, 10, 10));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Tài khoản");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jLabel3.setMaximumSize(new java.awt.Dimension(80, 23));
        jLabel3.setMinimumSize(new java.awt.Dimension(80, 23));
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 23));
        jPanel4.add(jLabel3);

        jTextUserName.setPreferredSize(new java.awt.Dimension(105, 27));
        jTextUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUserNameKeyTyped(evt);
            }
        });
        jPanel4.add(jTextUserName);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Mật khẩu ");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        jLabel4.setMaximumSize(new java.awt.Dimension(80, 23));
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 23));
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 23));
        jPanel5.add(jLabel4);

        jTextPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPasswordKeyTyped(evt);
            }
        });
        jPanel5.add(jTextPassword);

        jPanel3.add(jPanel5);

        jShowPassword.setText("Hiện");
        jShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowPasswordActionPerformed(evt);
            }
        });

        jinformLabelLogin.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jinformLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(80, 80, 80)
                .addComponent(jShowPassword)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jShowPassword)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jinformLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel2);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout1);

        jLogin.setText("Đăng nhập");
        jPanel6.add(jLogin);

        jPanel3.add(jPanel6);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Đăng nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowPasswordActionPerformed
        if (this.jShowPassword.isSelected()) {
            // show password
            jTextPassword.setEchoChar((char) 0);
        } else {
            // hide password
            jTextPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jShowPasswordActionPerformed

    public void resetText() {
        this.jTextPassword.setText("");
        this.jTextUserName.setText("");

    }
    private void jTextUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUserNameKeyTyped
        this.jinformLabelLogin.setText("");

    }//GEN-LAST:event_jTextUserNameKeyTyped

    private void jTextPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPasswordKeyTyped
        // TODO add your handling code here:
        this.jinformLabelLogin.setText("");
    }//GEN-LAST:event_jTextPasswordKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jLogin;
    private javax.swing.JCheckBox jShowPassword;
    private javax.swing.JPasswordField jTextPassword;
    private javax.swing.JTextField jTextUserName;
    private javax.swing.JLabel jinformLabelLogin;
    // End of variables declaration//GEN-END:variables
}
