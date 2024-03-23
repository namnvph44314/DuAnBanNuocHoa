/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.LoginService;
import Services.LoginServiceImpl;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class LoginJFrame extends javax.swing.JFrame {

    LoginService loginService = new LoginServiceImpl();

    public LoginJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTendangNhap1 = new javax.swing.JLabel();
        txtTenDangNhap1 = new javax.swing.JTextField();
        lblTendangNhap = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JToggleButton();
        btnDangKy = new javax.swing.JToggleButton();
        txtMatKhau = new javax.swing.JPasswordField();
        lblNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTendangNhap1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTendangNhap1.setForeground(new java.awt.Color(255, 255, 255));
        lblTendangNhap1.setText("Tên đăng nhập");
        getContentPane().add(lblTendangNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 100, -1));
        getContentPane().add(txtTenDangNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 300, -1));

        lblTendangNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblTendangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTendangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblTendangNhap.setText("Mật khẩu");
        getContentPane().add(lblTendangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 100, -1));

        lblQuenMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMatKhau.setText("Quên mật khẩu?");
        getContentPane().add(lblQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        btnDangNhap.setBackground(new java.awt.Color(51, 153, 255));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 300, -1));

        btnDangKy.setBackground(new java.awt.Color(255, 51, 51));
        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Thoát");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 300, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 300, -1));

        lblNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nenDangNhap_1.png"))); // NOI18N
        getContentPane().add(lblNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        TaiKhoanViews taiKhoan = new TaiKhoanViews();
        taiKhoan.setEmail(txtTenDangNhap1.getText());
        taiKhoan.setMatKhau(String.valueOf(txtMatKhau.getPassword()));
        ArrayList<TaiKhoanViews> listAccount = loginService.checkLogin(taiKhoan);
        if (listAccount.size() == 0) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại, vui lòng kiểm tra lại tài khoản hoặc mật khẩu");
            return;
        }
        if (listAccount.get(0).getIdLoaiNguoiDung().equalsIgnoreCase("ND1")) {
            JOptionPane.showMessageDialog(this, "Đây là view của quản lý");
        } else {
            JOptionPane.showMessageDialog(this, "Đây là view của nhân viên");
        }

    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKyActionPerformed

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDangKy;
    private javax.swing.JToggleButton btnDangNhap;
    private javax.swing.JLabel lblNen;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblTendangNhap;
    private javax.swing.JLabel lblTendangNhap1;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap1;
    // End of variables declaration//GEN-END:variables
}
