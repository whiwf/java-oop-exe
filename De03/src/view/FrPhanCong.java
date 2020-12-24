package view;

import io.IOFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangPhanCong;
import model.DuAn;
import model.NhanVien;

/**
 *
 * @author whiwf
 */
public class FrPhanCong extends javax.swing.JPanel implements View {

    /**
     * Creates new form FrPhanCong
     */
    private DefaultTableModel model;
    private List<NhanVien> listNV;
    private List<DuAn> listDA;
    private List<BangPhanCong> listPC;
    private final String fileNV = "NV.TXT", fileDA = "DA.TXT", filePC = "PC.TXT";

    public FrPhanCong() {
        initComponents();
        String colsString[] = {"Ten NV", "Ten DA", "Vi tri", "So ngay"};
        model = new DefaultTableModel(colsString, 0);
        jTable1.setModel(model);

        listPC = new ArrayList<>();

        btnFalse();
    }

    private void btnFalse() {
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        tfViTri.setEditable(false);
        tfSo.setEditable(false);
    }

    private void btnTrue() {
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        tfViTri.setEditable(true);
        tfSo.setEditable(true);
    }

    private void clearData() {
        tfViTri.setText("");
        tfSo.setText("");
    }

    private boolean canInitData() {
        listNV = new ArrayList<>();
        listNV = IOFile.readFromFile(fileNV);

        listDA = new ArrayList<>();
        listDA = IOFile.readFromFile(fileDA);

        if (listDA.isEmpty() || listNV.isEmpty()) {
            return false;
        }
        return true;
    }

    private void initData() {
        cbNV.removeAllItems();
        cbDA.removeAllItems();
        for (NhanVien nv : listNV) {
            cbNV.addItem(nv.formatMa());
        }
        for (DuAn da : listDA) {
            cbDA.addItem(da.formatMa());
        }
    }

    private NhanVien findNhanVienByMa(int ma) {
        for (NhanVien nv : listNV) {
            if (nv.getMa() == ma) {
                return nv;
            }
        }
        return null;
    }

    private DuAn findDuAnByMa(int ma) {
        for (DuAn da : listDA) {
            if (da.getMa() == ma) {
                return da;
            }
        }
        return null;
    }

    private boolean canAddToProject(int maNV, int maDA) {
        for (BangPhanCong pc : listPC) {
            if (pc.getDuAn().getMa() == maDA && pc.getNhanVien().getMa() == maNV) {
                return false;
            }
        }
        return true;
    }

    private void sortByTen(){
        Collections.sort(listPC, (pc1, pc2) -> {
            return pc1.getNhanVien().getTen().compareTo(pc2.getNhanVien().getTen());
        });
        showData(listPC);
    }
    
    private void sortByNgay(){
        Collections.sort(listPC, (pc1, pc2) -> {
            return pc2.getNgay() > pc1.getNgay() ? 1 : pc2.getNgay() < pc1.getNgay() ? -1 : 0;
        });
        showData(listPC);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNV = new javax.swing.JComboBox<>();
        cbDA = new javax.swing.JComboBox<>();
        tfViTri = new javax.swing.JTextField();
        tfSo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Phan cong"));

        jLabel1.setText("Ma NV");

        jLabel2.setText("Ma DA");

        jLabel3.setText("Vi tri");

        jLabel4.setText("So ngay");

        jButton2.setText("Luu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Huy");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbNV, 0, 226, Short.MAX_VALUE)
                    .addComponent(cbDA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfViTri)
                    .addComponent(tfSo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfViTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Sap xep theo:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Ten NV");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Ngay tham gia");

        jButton4.setText("Xep");
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
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton4))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (!canInitData()) {
                throw new IOException();
            }
            initData();
            btnTrue();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Du An hoac Nhan Vien khong co du lieu");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        btnFalse();
        clearData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int maNV = Integer.parseInt((String) cbNV.getSelectedItem());
        int maDA = Integer.parseInt((String) cbDA.getSelectedItem());
        String viTri = "";
        int ngay = 0;
        boolean isOk = true;
        try {
            if (!canAddToProject(maNV, maDA)) {
                throw new IOException();
            }
            try {
                viTri = tfViTri.getText().replaceAll("\\s+", " ").trim();
                if (viTri.length() == 0) {
                    throw new IOException();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "vi tri khong de trong");
                isOk = false;

            }
            try {
                ngay = Integer.parseInt(tfSo.getText().replaceAll("\\s+", " ").trim());
                if (ngay <= 0) {
                    throw new NumberFormatException();

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ngay sai dinh dang");
                isOk = false;

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NV da tham gia DA nay");
            isOk = false;
        }
        
        if(isOk){
            NhanVien nhanVien = findNhanVienByMa(maNV);
            DuAn duAn = findDuAnByMa(maDA);
            BangPhanCong pc = new BangPhanCong(nhanVien, duAn, viTri, ngay);
            addTo(pc);
            btnFalse();
            clearData();
            IOFile.writeToFile(listPC, filePC);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(jRadioButton1.isSelected()){
           sortByTen();
       } else if(jRadioButton2.isSelected()){
           sortByNgay();
       }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDA;
    private javax.swing.JComboBox<String> cbNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfSo;
    private javax.swing.JTextField tfViTri;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addTo(T t) {
        listPC.add((BangPhanCong) t);
        showData(listPC);
    }

    @Override
    public <T> void showData(List<T> ls) {
        model.setRowCount(0);
        for (T t : ls) {
            if (t instanceof BangPhanCong) {
                model.addRow(((BangPhanCong) t).toObject());
            }
        }
    }
}
