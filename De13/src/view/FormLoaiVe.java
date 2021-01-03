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
public class FormLoaiVe extends javax.swing.JPanel implements ViewInterace {

    /**
     * Creates new form FormLoaiVe
     */
    private DefaultTableModel model;
    private List<LoaiVe> list;
    private final String FILE = "VE.TXT";

    public FormLoaiVe() {
        initComponents();
        String cols[] = {"Ma loai ve", "Mo ta", "Gia ban"};
        model = new DefaultTableModel(cols, 0);
        table.setModel(model);

        initListData();
        btnFalse();
    }

    private void initListData() {
        list = new ArrayList<>();
        list = IOFile.readFile(FILE);
        if (!list.isEmpty()) {
            showData(list, model);
            int ma = list.get(list.size() - 1).getMaLoai() + 1;
            LoaiVe.setsMa(ma);
        }
    }

    private void btnTrue(){
        btnLuu.setEnabled(true);
        btnHuy.setEnabled(true);
    }
    
    private void btnFalse(){
        btnLuu.setEnabled(false);
        btnHuy.setEnabled(false);
    }
    
    private void clearData(){
        tfGia.setText("");
        tfMoTa.setText("");
    }
    
    private String formatInputString(String s){
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
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        tfGia = new javax.swing.JTextField();
        tfMoTa = new javax.swing.JTextField();
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

        jLabel1.setText("Mo ta");

        jLabel2.setText("Gia ban");

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
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(btnLuu)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfGia)
                            .addComponent(tfMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(181, 181, 181))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        btnFalse();
        clearData();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String moTa = "", giaBan = "";
        float gia = 0;
        boolean isOk = true;
        try{
            moTa = formatInputString(tfMoTa.getText());
            if(moTa.length() == 0)
                throw new IOException();
            String regexMoTa = "^[a-zA-Z0-9]+$";
            if(!isFormattedString(moTa, regexMoTa))
                throw new InputMismatchException();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Mo ta khong de trong");
            isOk = false;
        } catch(InputMismatchException e){
            JOptionPane.showMessageDialog(null, "Mo ta sai dinh dang");
            isOk = false;
        }
        
        try{
            giaBan = formatInputString(tfGia.getText());
            if(giaBan.length() == 0)
                throw new IOException();
            gia = Float.parseFloat(giaBan);
            if(gia <= 0)
                throw new InputMismatchException();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Gia ban khong de trong");
            isOk = false;
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Gia ve chi la so");
            isOk = false;
        } catch(InputMismatchException e){
            JOptionPane.showMessageDialog(null, "Gia ban phai lon hon 0");
            isOk = false;
        }
        
        if(isOk){
            LoaiVe ve = new LoaiVe(moTa, gia);
            addToList(ve, list);
            clearData();
            btnFalse();
            IOFile.writeFile(FILE, list);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnTrue();
        clearData();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMoTa;
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
