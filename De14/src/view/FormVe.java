/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import io.IOFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LoaiVe;

/**
 *
 * @author whiwf
 */
public class FormVe extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form FormVe
     */
    private DefaultTableModel model;
    private List<LoaiVe> list;
    private final String FILE = "VE.TXT";

    public FormVe() {
        initComponents();
        String cols[] = {"Ma ve", "Loai ve", "Don gia"};
        model = new DefaultTableModel(cols, 0);
        table.setModel(model);
        
        initListData();
        initCbData();
        btnFalse();
    }

    private void initCbData(){
        cbLoai.removeAllItems();
        String items[] = {"doanh nhan", "pho thong", "pho thong gia re", "the vang", "the xanh", "ngoai giao"};
        
        for(String item : items){
            cbLoai.addItem(item);
        }
    }
    private void initListData() {
        list = new ArrayList<>();
        list = IOFile.readFile(FILE);
        if (list.size() > 0) {
            showData(list, model);
            int ma = list.get(list.size() - 1).getMaVe() + 1;
            LoaiVe.setsMa(ma);
        }
    }

    private void clearData() {
        tfGia.setText("");
    }

    private void btnTrue() {
        btnLuu.setEnabled(true);
        btnHuy.setEnabled(true);
    }

    private void btnFalse() {
        btnLuu.setEnabled(false);
        btnHuy.setEnabled(false);
    }

    private String formatInputString(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Them"));

        jLabel2.setText("Don gia");

        jLabel3.setText("Loai");

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mua le", "mua tap the", "mua qua mang" }));

        btnLuu.setText("Luu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Huy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfGia, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnThem)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnThem)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnTrue();
        clearData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String donGia = "", loai = "";
        float gia = 0;
        boolean isOk = true;
        
        try {
            loai = (String) cbLoai.getSelectedItem();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Loai khong co du lieu");
            isOk = false;
        }
        
        try {
            donGia = formatInputString(tfGia.getText());
            if (donGia.length() == 0) {
                throw new IOException();
            }
            gia = Float.parseFloat(donGia);
            if(gia <= 0)
                throw new InputMismatchException();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Don gia khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Don gia phai lon hon 0");
            isOk = false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Don gia chi la so");
            isOk = false;
        }

        if (isOk) {
            LoaiVe ve = new LoaiVe(loai, gia);
            addToList(ve, list);
            clearData();
            btnFalse();
            IOFile.writeFile(FILE, list);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        btnFalse();
        clearData();
    }//GEN-LAST:event_btnHuyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfGia;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addToList(T t, List<T> ls) {
        ls.add(t);
        showData(ls, model);
    }

    @Override
    public <T> void showData(List<T> ls, DefaultTableModel md) {
        md.setRowCount(0);
        for(T t : ls){
            if(t instanceof LoaiVe){
                md.addRow(((LoaiVe) t).toObjects());
            }
        }
    }

}
