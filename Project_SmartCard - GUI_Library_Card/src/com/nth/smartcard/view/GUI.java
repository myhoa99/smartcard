/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nth.smartcard.view;

import com.nth.smartcard.utils.SmartCardWork;
import com.nth.smartcard.model.Infomation;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Tien Hoa
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private String imagePath;
    private final SmartCardWork card;
    private ChangeInfo changeInfo;
    private Library library;
    private ChangePin verifyCard;
    private Infomation info;
    private VerifyRSA veriRSA;

    public static boolean isConnect = false;
    private boolean verify = true;

    public GUI() {
        initComponents();
        card = new SmartCardWork();
        resetButuon();
//        isConnect = card.connectCard();
//        connectCard();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void readInfomation() {
        try {
            if (isConnect) {
                info = card.readInfo();
                if (info == null) {
                    JOptionPane.showMessageDialog(this, "Thẻ chưa có dữ liệu");
                } else {
                    txt_fullName.setText(info.getFullName());
                    txt_khoa.setText(info.getKhoa());
                    txt_lop.setText(info.getLop());
                    txt_masv.setText(info.getMaSV());
                    if (info.getAvata() == null) {
                        lb_img_avatar.setIcon(null);
                    } else {
                        SmartCardWork.setImageIcon(info.getAvata(), lb_img_avatar);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa connect được applet ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thẻ chưa có dữ liệu");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_img_avatar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_fullName = new javax.swing.JLabel();
        txt_khoa = new javax.swing.JLabel();
        txt_lop = new javax.swing.JLabel();
        txt_masv = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_ReadCard = new javax.swing.JButton();
        btn_ChangeInfo = new javax.swing.JButton();
        btn_Library = new javax.swing.JButton();
        btn_connect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Card - Thẻ thư viện - Nhóm 8");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>THẺ THƯ VIỆN");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lb_img_avatar.setBackground(new java.awt.Color(153, 255, 153));
        lb_img_avatar.setForeground(new java.awt.Color(153, 255, 153));
        lb_img_avatar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        lb_img_avatar.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Họ Tên :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Khóa : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Mã SV :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Lớp : ");

        txt_fullName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_fullName.setForeground(new java.awt.Color(204, 0, 0));

        txt_khoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_khoa.setForeground(new java.awt.Color(204, 0, 0));

        txt_lop.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_lop.setForeground(new java.awt.Color(204, 0, 0));

        txt_masv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_masv.setForeground(new java.awt.Color(204, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin sinh viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_khoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_ReadCard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ReadCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/readCard.png"))); // NOI18N
        btn_ReadCard.setText("Read Card");
        btn_ReadCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReadCardActionPerformed(evt);
            }
        });

        btn_ChangeInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ChangeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/icon-user-info.png"))); // NOI18N
        btn_ChangeInfo.setText("Change Info");
        btn_ChangeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChangeInfoActionPerformed(evt);
            }
        });

        btn_Library.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Library.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/icon-library-25x25.png"))); // NOI18N
        btn_Library.setText("Library");
        btn_Library.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LibraryActionPerformed(evt);
            }
        });

        btn_connect.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_connect.setForeground(new java.awt.Color(18, 110, 140));
        btn_connect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/icon-connect-25x25.png"))); // NOI18N
        btn_connect.setText("Connect");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_img_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btn_ReadCard, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_ChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_Library, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_img_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ReadCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Library, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LibraryActionPerformed
        if (isConnect) {
            if (library == null) {
                library = new Library(card, this);
                library.setVisible(true);
                library.validate();
                this.dispose();
            } else {
                library.initListBook();
                library.setVisible(true);
                library.validate();
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa connect được đến applet");
        }

    }//GEN-LAST:event_btn_LibraryActionPerformed

    private void btn_ReadCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReadCardActionPerformed
        if (SmartCardWork.verifyFalse >= 3) {
            btn_ReadCard.setText("UNBLOCK CARD");
            btn_ReadCard.setForeground(Color.red);
            btn_Library.setEnabled(false);
            btn_ChangeInfo.setEnabled(false);
            if (!verify) {
                if (card.unblockCard()) {
                    btn_ReadCard.setText("READ CARD");
                    btn_ReadCard.setForeground(Color.BLACK);
                    btn_Library.setEnabled(true);
                    btn_ChangeInfo.setEnabled(true);
                    verify = true;
                }
            }
            verify = false;
        } else {
            readInfomation();
        }
    }//GEN-LAST:event_btn_ReadCardActionPerformed

    private void btn_ChangeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChangeInfoActionPerformed
        if (isConnect) {
            if (changeInfo == null) {
                changeInfo = new ChangeInfo(card, this);
                changeInfo.setVisible(true);
                changeInfo.validate();
                this.dispose();
            } else {
                changeInfo.setVisible(true);
                changeInfo.validate();
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa connect được đến applet");
        }
    }//GEN-LAST:event_btn_ChangeInfoActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        if (!isConnect) {
            if (card.connectCard()) {
                isConnect = true;
                this.dispose();
                if (veriRSA == null) {
                    veriRSA = new VerifyRSA(card, this);
                    veriRSA.setVisible(true);
                    veriRSA.validate();
                } else {
                    veriRSA.setTextNoti("");
                    veriRSA.setVisible(true);
                    veriRSA.validate();
                }
                btn_connect.setText("Disconnect");
                btn_connect.setForeground(Color.RED);
            } else {
                JOptionPane.showMessageDialog(this, "Chưa connect được đến applet");
                isConnect = false;
                btn_connect.setText("Connect");
                btn_connect.setForeground(new Color(18, 110, 140));
            }
        } else {
            if (card.disconnect()) {
                isConnect = false;
                btn_connect.setText("Connect");
                btn_connect.setForeground(new Color(18, 110, 140));
                resetButuon();
            }
        }
    }//GEN-LAST:event_btn_connectActionPerformed

    public void resetButuon() {
        if (isConnect&&SmartCardWork.checkVeriRSA) {
            btn_connect.setText("Disconnect");
            btn_connect.setForeground(Color.RED);
            btn_ChangeInfo.setEnabled(true);
            btn_ReadCard.setEnabled(true);
            btn_Library.setEnabled(true);
        } else {
            btn_connect.setText("Connect");
            btn_connect.setForeground(new Color(18, 110, 140));
            btn_ChangeInfo.setEnabled(false);
            btn_ReadCard.setEnabled(false);
            btn_Library.setEnabled(false);
        }
        
    }

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChangeInfo;
    private javax.swing.JButton btn_Library;
    private javax.swing.JButton btn_ReadCard;
    private javax.swing.JButton btn_connect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_img_avatar;
    private javax.swing.JLabel txt_fullName;
    private javax.swing.JLabel txt_khoa;
    private javax.swing.JLabel txt_lop;
    private javax.swing.JLabel txt_masv;
    // End of variables declaration//GEN-END:variables
}
