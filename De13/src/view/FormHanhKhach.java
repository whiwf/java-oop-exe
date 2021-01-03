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
import model.HanhKhach;
import model.LoaiVe;

/**
 *
 * @author whiwf
 */
public class FormHanhKhach extends javax.swing.JPanel implements ViewInterace {

    /**
     * Creates new form FormHanhKhach
     */
    private DefaultTableModel model;
    private List<HanhKhach> list;
    private final String FILE = "HK.TXT";

    public FormHanhKhach() {
        initComponents();
        String colsString[] = {"Ma HK", "Ho ten", "Dia chi", "Loai HK"};
        model = new DefaultTableModel(colsString, 0);
        table.setModel(model);

        initListData();
        btnFalse();
    }

    private void initListData() {
        list = new ArrayList<>();
        list = IOFile.readFile(FILE);
        if (!list.isEmpty()) {
            showData(list, model);
            int ma = list.get(list.size() - 1).getMaHK() + 1;
            HanhKhach.setsMa(ma);
        }
    }
    
    private void clearData(){
        tfTen.setText("");
        tfDiaChi.setText("");
    }

    private void btnTrue(){
        btnHuy.setEnabled(true);
        btnLuu.setEnabled(true);
    }
    
    private void btnFalse(){
        btnHuy.setEnabled(false);
        btnLuu.setEnabled(false);
    }
    
    private String formatStringInput(String s){
        return s.replaceAll("\\s+", " ").trim();
    }
    
    private boolean isFormattedString(String s, String regex){
        String checkArr[] = s.split(" ");
        for(String check : checkArr){
            if(!check.matches(regex))
                return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        tfDiaChi = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

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

        jLabel1.setText("Ho ten");

        jLabel2.setText("Dia chi");

        jLabel3.setText("Loai khach");

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hoc sinh sinh vien", "can bo trong nganh", "hanh khach thong thuong" }));

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
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTen)
                    .addComponent(tfDiaChi)
                    .addComponent(cbLoai, 0, 261, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addGap(25, 25, 25))
        );

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(btnThem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnTrue();
        clearData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String ten = "", diaChi = "";
        boolean isOk = true;
        try{
            ten = formatStringInput(tfTen.getText());
            if(ten.length() == 0)
                throw new IOException();
            String regexTen = "^[a-zA-Z]+$";
            if(!isFormattedString(ten, regexTen))
                throw new InputMismatchException();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ten khong de trong");
            isOk = false;
        } catch(InputMismatchException e){
            JOptionPane.showMessageDialog(null, "Ten chi co ky tu chu");
            isOk = false;
        }
        
        try{
            diaChi = formatStringInput(tfDiaChi.getText());
            if(diaChi.length() == 0)
                throw new IOException();
            String regexDiaChi = "^[a-zA-Z0-9/]+$";
            if(!isFormattedString(diaChi, regexDiaChi))
                throw new InputMismatchException();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "dia chi khong de trong");
            isOk = false;
        } catch(InputMismatchException e){
            JOptionPane.showMessageDialog(null, "dia chi sai dinh dang");
            isOk = false;
        }
        
        String loai = (String) cbLoai.getSelectedItem();
        if(isOk){
            HanhKhach khach = new HanhKhach(ten, diaChi, loai);
            addToList(khach, list);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfTen;
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
            if(t instanceof HanhKhach){
                md.addRow(((HanhKhach) t).toObjects());
            }
        }
    }
}