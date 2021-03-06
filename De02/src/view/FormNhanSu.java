/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerImp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanSu;
import model.NhanVien;
import model.PhongBan;

/**
 *
 * @author whiwf
 */
public class FormNhanSu extends javax.swing.JPanel implements View {

    private DefaultTableModel model;
    private List<NhanVien> listNV;
    private List<PhongBan> listPB;
    private List<NhanSu> listNS;
    private ControllerImp controller;
    private String fileNV = "NV.TXT", filePB = "PB.TXT", fileNS = "QLNS.TXT";

    public FormNhanSu() {
        initComponents();

        String colsString[] = {"Ma NV", "Ten NV", "Ma PB", "Ngay cong"};
        model = new DefaultTableModel(colsString, 0);
        jTable1.setModel(model);
        controller = new ControllerImp();
        listNS = new ArrayList<>();
        btnFalse();
        showFromFile(listNS, model, fileNS);
    }

    private void getData() {
        cbNV.removeAllItems();
        cbPB.removeAllItems();

        listNV = new ArrayList<>();
        listPB = new ArrayList<>();
        boolean canAdd = true;
        try {
            listNV = controller.readFromFile(fileNV);
            if (listNV.size() == 0) {
                throw new NullPointerException();
            }
            for (NhanVien nv : listNV) {
                cbNV.addItem(String.format("%04d", nv.getMaNV()));
            }
        } catch (NullPointerException e) {
            canAdd = false;
        }
        try {
            listPB = controller.readFromFile(filePB);
            if (listPB.size() == 0) {
                throw new NullPointerException();
            }
            for (PhongBan phong : listPB) {
                cbPB.addItem(String.format("%03d", phong.getMaPB()));
            }
        } catch (NullPointerException e) {
            canAdd = false;
        }
        if (canAdd) {
            btnTrue();
        }
    }

    private void btnTrue() {
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }

    private void btnFalse() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    private NhanVien getNhanVienByMa(int ma) {
        for (NhanVien nv : listNV) {
            if (nv.getMaNV() == ma) {
                return nv;
            }
        }
        return null;
    }

    ;
    
    private PhongBan getPhongBanByMa(int ma) {
        for (PhongBan p : listPB) {
            if (p.getMaPB() == ma) {
                return p;
            }
        }
        return null;
    }

    private void clearData() {
        tfNgay.setText("");
    }

    private boolean isExistData(NhanVien nv) {
        for (NhanSu ns : listNS) {
            if (ns.getNhanVien().getMaNV() == nv.getMaNV()) {
                return true;
            }
        }
        return false;
    }

    private void sortByNameNhanVien(){
        Collections.sort(listNS, (NhanSu s1, NhanSu s2) -> {
            return s1.getNhanVien().getHoTen().compareTo(s2.getNhanVien().getHoTen());
        });
        showData(listNS, model);
    }
    
    private void sortByPhongBan(){
        Set<String> dsPhong = new HashSet<>();
        List<NhanSu> dsNhanSuTheoPhong = new ArrayList<>();
        for(NhanSu ns : listNS){
            dsPhong.add(ns.getPhongBan().getMaPB() + "");
        }
        for(String phong : dsPhong){
            List<NhanSu> nsTheoPhong = new ArrayList<>();
            for(NhanSu ns : listNS){
                String nvThuocPhong = ns.getPhongBan().getMaPB() + "";
                if(nvThuocPhong.equals(phong)){
                    nsTheoPhong.add(ns);
                }
            }
            dsNhanSuTheoPhong.addAll(nsTheoPhong);
        }
        showData(dsNhanSuTheoPhong, model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbNV = new javax.swing.JComboBox<>();
        cbPB = new javax.swing.JComboBox<>();
        tfNgay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Ma NV:");

        jLabel2.setText("Ma PB:");

        jLabel3.setText("Ngay cong:");

        jButton1.setText("Luu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Huy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cap nhat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Ten Nhan Vien");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Phong Ban");

        jLabel4.setText("Sap xep theo:");

        jButton4.setText("Sap xep");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(42, 42, 42)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(48, 48, 48)
                        .addComponent(jRadioButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jButton4)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jLabel4))
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        getData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int maNV = Integer.parseInt((String) cbNV.getSelectedItem());
        int maPB = Integer.parseInt((String) cbPB.getSelectedItem());
        int so = 0;
        boolean isOk = true;
        try {
            so = Integer.parseInt(tfNgay.getText());
            if (so < 0 || so > 31) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nhap sai dinh dang ngay");
            isOk = false;
        }
        if (isOk) {
            NhanVien nv = getNhanVienByMa(maNV);
            PhongBan pb = getPhongBanByMa(maPB);
            try {
                if (isExistData(nv)) {
                    throw new IOException();
                }
                NhanSu ns = new NhanSu(nv, pb, so);
                addTo(ns);
                controller.writeToFile(fileNS, listNS);
                clearData();
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Nhan vien da ton tai trong phong ban khac");
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(jRadioButton1.isSelected()){
            sortByNameNhanVien();
        } else {
            sortByPhongBan();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbNV;
    private javax.swing.JComboBox<String> cbPB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfNgay;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void showData(List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        for (T t : list) {
            if (t instanceof NhanSu) {
                model.addRow(((NhanSu) t).toObject());
            }
        }
    }

    @Override
    public <T> void addTo(T t) {
        listNS.add((NhanSu) t);
        showData(listNS, model);
    }

    @Override
    public <T> void showFromFile(List<T> list, DefaultTableModel model, String fileName) {
        list = controller.readFromFile(fileNS);
        if (list.size() > 0) {
            listNS = (List<NhanSu>) list;
            showData(listNS, model);
        }
    }
}
