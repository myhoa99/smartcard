/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nth.smartcard.view;

import com.nth.smartcard.model.ItemBook;
import com.nth.smartcard.model.ItemBookReturn;
import com.nth.smartcard.model.ItemMuonSach;
import com.nth.smartcard.utils.BookModel;
import com.nth.smartcard.utils.SmartCardWork;
import com.nth.smartcard.utils.VNCharacterUtils;
import java.awt.Image;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Tien Hoa
 */
public class Library extends javax.swing.JFrame {

    /**
     * Creates new form Library
     */
    private final SmartCardWork card;
    private final GUI gui;
    private List<ItemBook> listBook;
    private List<ItemBook> tempList;
    private List<ItemBookReturn> listBookReturn;
    private List<ItemMuonSach> listMuon;
    private static int count = 0;

    public Library(SmartCardWork card, GUI gui) {
        this.card = card;
        this.gui = gui;
        initComponents();
        init();
    }

    private void init() {
        URL path = getClass().getResource("/com/nth/smartcard/icon/icon-book.png");
        ImageIcon icon = new ImageIcon(path);
        Image pic = icon.getImage();
        Image pic2 = pic.getScaledInstance(lb_icon.getWidth(), lb_icon.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon im = new ImageIcon(pic2);
        lb_icon.setIcon(im);
        listBook = BookModel.getListBook();
        DefaultComboBoxModel modeCB = (DefaultComboBoxModel) cb_danhMuc.getModel();
        modeCB.removeAllElements();
        modeCB.addElement("ALL");
        List<String> listCategory = new ArrayList<>();
        for (int i = 0; i < listBook.size(); i++) {
            String element = listBook.get(i).getLoaiSach();
            if (!listCategory.contains(element)) {
                listCategory.add(element);
            }
        }
        for (int i = 0; i < listCategory.size(); i++) {
            Object ob = listCategory.get(i);
            modeCB.addElement(ob);
        }
        initListBook();
        setDataTabel(listBook);
    }

    public void initListBook() {
        listMuon = card.getListSach();
        if (!listMuon.isEmpty()) {
            listBookReturn = new ArrayList<>();
            for (int i = 0; i < listBook.size(); i++) {
                String idB = listBook.get(i).getIdBook();
                for (int j = 0; j < listMuon.size(); j++) {
                    if (idB.contains(listMuon.get(j).getIdBook())) {
                        ItemBookReturn it = new ItemBookReturn();
                        it.setIdBook(listMuon.get(j).getIdBook());
                        it.setLoaiSach(listBook.get(i).getLoaiSach());
                        it.setNameBook(listBook.get(i).getNameBook());
                        it.setNgayMuon(listMuon.get(j).getNgayMuon());
                        listBookReturn.add(it);
                    }
                }
            }
            setDataTabelReturn(listBookReturn);
        }else{
            DefaultTableModel model = (DefaultTableModel) tb_traSach.getModel();
            model.setRowCount(0); 
        }
        
    }

    private void setDataTabelReturn(List<ItemBookReturn> list) {

        DefaultTableModel model = (DefaultTableModel) tb_traSach.getModel();
        model.setRowCount(0);
        if (!list.isEmpty()) {
            Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row[0] = i;
                row[1] = list.get(i).getIdBook();
                row[2] = list.get(i).getNameBook();
                row[3] = list.get(i).getLoaiSach();
                row[4] = list.get(i).getNgayMuon();
                model.addRow(row);
            }
        }
    }

    private void setDataTabel(List<ItemBook> list) {
        if (!list.isEmpty()) {

            DefaultTableModel model = (DefaultTableModel) tb_muonSach.getModel();
            model.setRowCount(0);
            Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row[0] = i;
                row[1] = list.get(i).getIdBook();
                row[2] = list.get(i).getNameBook();
                row[3] = list.get(i).getLoaiSach();
                row[4] = list.get(i).getNxb();
                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Cancel = new javax.swing.JButton();
        btn_MuonSach = new javax.swing.JButton();
        btn_TraSach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_traSach = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_muonSach = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb_danhMuc = new javax.swing.JComboBox<>();
        lb_icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/cancel-25x25.png"))); // NOI18N
        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_MuonSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_MuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/icon-book-1-25x25.png"))); // NOI18N
        btn_MuonSach.setText("M?????n S??ch");
        btn_MuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MuonSachActionPerformed(evt);
            }
        });

        btn_TraSach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_TraSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nth/smartcard/icon/icon-book25x25.png"))); // NOI18N
        btn_TraSach.setText("Tr??? S??ch");
        btn_TraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TraSachActionPerformed(evt);
            }
        });

        tb_traSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tb_traSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID S??CH", "T??N S??CH", "LO???I S??CH", "NG??Y M?????N", "CH???N"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_traSach.setRowHeight(25);
        jScrollPane1.setViewportView(tb_traSach);
        if (tb_traSach.getColumnModel().getColumnCount() > 0) {
            tb_traSach.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_traSach.getColumnModel().getColumn(1).setMaxWidth(250);
            tb_traSach.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        tb_muonSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tb_muonSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID S??CH", "T??N S??CH", "LO???I S??CH", "NH?? XB - Ch??? Bi??n", "CH???N"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_muonSach.setRowHeight(25);
        jScrollPane2.setViewportView(tb_muonSach);
        if (tb_muonSach.getColumnModel().getColumnCount() > 0) {
            tb_muonSach.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_muonSach.getColumnModel().getColumn(1).setMaxWidth(250);
            tb_muonSach.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Search : ");

        txt_search.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_search.setForeground(new java.awt.Color(204, 0, 0));
        txt_search.setPreferredSize(new java.awt.Dimension(99, 30));
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Danh M???c : ");

        cb_danhMuc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cb_danhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_danhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_danhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_MuonSach)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_TraSach))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_MuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_TraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed

        this.dispose();
        gui.setVisible(true);
        gui.validate();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void btn_MuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MuonSachActionPerformed
        Boolean check = false;
        List<ItemMuonSach> tempList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        String date = today.toString();
        tempList.removeAll(tempList);
        for (int i = 0; i < tb_muonSach.getRowCount(); i++) {
            if (tb_muonSach.getValueAt(i, 5) != null) {
                check = Boolean.valueOf(tb_muonSach.getValueAt(i, 5).toString());
                String id = tb_muonSach.getValueAt(i, 1).toString();
                if (check) {
                    ItemMuonSach item = new ItemMuonSach();
                    item.setIdBook(id);
                    item.setNgayMuon(date);
                    tempList.add(item);
                }
            }
        }
        List<ItemMuonSach> listTemp = card.getListSach();
        tempList.addAll(listTemp);
        for (int i = 0; i < tempList.size(); i++) {
            String id = tempList.get(i).getIdBook();
            System.out.println("IDTemp: " + id);
            int cout = 0;
            for (int j = 0; j < tempList.size(); j++) {
                String idM = tempList.get(j).getIdBook();
                if (id.contains(idM)) {
                    if (cout >= 1) {
                         JOptionPane.showMessageDialog(this, "S??ch v???i ID: " + tempList.get(i).getIdBook() + " ???? ???????c m?????n.");
                         tempList.remove(i);
                    }
                    cout++;
                }
            }
        }
        if(card.muonSach(tempList)){
              JOptionPane.showMessageDialog(null, "M?????n t??i li???u th??nh c??ng ");
        }else{
            JOptionPane.showMessageDialog(null, "Kh??ng m?????n ???????c t??i li???u");
        }
        initListBook();
    }//GEN-LAST:event_btn_MuonSachActionPerformed

    private void btn_TraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TraSachActionPerformed

        Boolean check = false;
        List<ItemMuonSach> tempList = listMuon;
        for (int i = 0; i < tb_traSach.getRowCount(); i++) {
            if (tb_traSach.getValueAt(i, 5) != null) {
                check = Boolean.valueOf(tb_traSach.getValueAt(i, 5).toString());
                String id = tb_traSach.getValueAt(i, 1).toString();
                if (check) {
                    for (int j = 0; j < tempList.size(); j++) {
                        String element = tempList.get(j).getIdBook();
                        if (element.contains(id)) {
                            tempList.remove(j);
                        }
                    }
                }
            }
        }
         if(card.muonSach(tempList)){
              JOptionPane.showMessageDialog(null, "Tr??? t??i li???u th??nh c??ng ");
        }else{
            JOptionPane.showMessageDialog(null, "Kh??ng tr??? ???????c t??i li???u");
        }
        initListBook();
    }//GEN-LAST:event_btn_TraSachActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        String sText = txt_search.getText();
        String searchT = VNCharacterUtils.removeAccent(sText).toUpperCase();
        if (!sText.equals("")) {
            tempList = new ArrayList<>();
            for (int i = 0; i < listBook.size(); i++) {
                String element = listBook.get(i).getNameBook();
                String resultText = VNCharacterUtils.removeAccent(element).toUpperCase();
                if (resultText.contains(searchT)) {
                    tempList.add(listBook.get(i));
                }
            }
            setDataTabel(tempList);
        } else {
            setDataTabel(listBook);
        }

    }//GEN-LAST:event_txt_searchKeyReleased

    private void cb_danhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_danhMucActionPerformed
        if (count >= 2) {
            String cate = cb_danhMuc.getSelectedItem().toString();
            tempList = new ArrayList<>();
            if (cate.equals("ALL")) {
                setDataTabel(listBook);
            } else {
                for (int i = 0; i < listBook.size(); i++) {
                    String element = listBook.get(i).getLoaiSach();
                    if (cate.equals(element)) {
                        tempList.add(listBook.get(i));
                    }
                }
                setDataTabel(tempList);
            }
        }
        count++;
    }//GEN-LAST:event_cb_danhMucActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_MuonSach;
    private javax.swing.JButton btn_TraSach;
    private javax.swing.JComboBox<String> cb_danhMuc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_icon;
    private javax.swing.JTable tb_muonSach;
    private javax.swing.JTable tb_traSach;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
