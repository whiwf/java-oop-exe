package view;

import io.IOFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangTinhCong;
import model.CongNhan;
import model.SanPham;

/**
 *
 * @author whiwf
 */
public class FormTinhCong extends javax.swing.JPanel implements View {

    /**
     * Creates new form FormTinhCong
     */
    private DefaultTableModel model;
    private List<SanPham> listSP;
    private List<CongNhan> listCN;
    private List<BangTinhCong> listTC;
    private final String fileSP = "SP.TXT", fileCN = "CN.TXT", fileTC = "TINHCONG.TXT";
    private final int OVER = 5;

    public FormTinhCong() {
        initComponents();
        listTC = new ArrayList<>();
        String colsString[] = {"Ten CN", "Ten SP", "So luong"};
        model = new DefaultTableModel(colsString, 0);
        jTable1.setModel(model);
        btnFalse();
    }

    private void initCN() {
        cbCN.removeAllItems();
        listCN = new ArrayList<>();
        listCN = IOFile.readFile(fileCN);
        for (CongNhan c : listCN) {
            cbCN.addItem(c.getMa() + "");
        }
    }

    private void initSP() {
        cbSP.removeAllItems();
        listSP = new ArrayList<>();
        listSP = IOFile.readFile(fileSP);
        for (SanPham c : listSP) {
            cbSP.addItem(c.getMa() + "");
        }
    }

    private void btnTrue() {
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
    }

    private void btnFalse() {
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        tfSo.setText("");
    }

    private CongNhan findCongNhanByMa(int ma) {
        for (CongNhan t : listCN) {
            if (t.getMa() == ma) {
                return t;
            }
        }
        return null;
    }

    private SanPham findSanPhamByMa(int ma) {
        for (SanPham t : listSP) {
            if (t.getMa() == ma) {
                return t;
            }
        }
        return null;
    }

    private boolean canAddTo(int maCN, int maSP) {
        for (BangTinhCong tc : listTC) {
            if (tc.getCongNhan().getMa() == maCN && tc.getSanPham().getMa() == maSP) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverAdd(int maCN) {
        int dem = 0;
        for (BangTinhCong tc : listTC) {
            if (tc.getCongNhan().getMa() == maCN) {
                dem++;
            }
        }
        return dem >= OVER;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbCN = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbSP = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfSo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("them "));

        jLabel3.setText("Cong nhan");

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

        jLabel4.setText("San pham");

        jLabel5.setText("So luong");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(cbCN, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSP, 0, 203, Short.MAX_VALUE)
                            .addComponent(tfSo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );

        jButton1.setText("Them");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Ho ten");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("So luong");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Sap xep theo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioButton1)
                        .addGap(35, 35, 35)
                        .addComponent(jRadioButton2)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel6))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int maCN = Integer.parseInt((String) cbCN.getSelectedItem());
        int maSP = Integer.parseInt((String) cbSP.getSelectedItem());
        try {
            if (!canAddTo(maCN, maSP)) {
                throw new IOException();
            }
            if (isOverAdd(maCN)) {
                throw new InputMismatchException();
            }
            CongNhan c = findCongNhanByMa(maCN);
            SanPham s = findSanPhamByMa(maSP);
            int so = Integer.parseInt(tfSo.getText().replaceAll("\\s+", " ").trim());
            if (so <= 0) {
                throw new NumberFormatException();
            }
            BangTinhCong b = new BangTinhCong(c, s, so);
            addTo(b);
            btnFalse();
            IOFile.writeFile(listTC, fileTC);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "CN da tham gia sx SP nay");

        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "CN da tham gia sx qua 5 san pham");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "So luong sai dinh dang");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        btnFalse();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        initCN();
        initSP();
        btnTrue();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        Collections.sort(listTC, (t1, t2) -> {
            return t1.getCongNhan().getTen().compareToIgnoreCase(t2.getCongNhan().getTen());
        });
        showData(listTC);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        Collections.sort(listTC, (t1, t2) -> {
            return t1.getSo() < t2.getSo() ? 1 : t1.getSo() > t2.getSo() ? -1 : 0;
        });
        showData(listTC);
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCN;
    private javax.swing.JComboBox<String> cbSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfSo;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addTo(T t) {
        listTC.add((BangTinhCong) t);
        showData(listTC);
    }

    @Override
    public <T> void showData(List<T> ls) {
        model.setRowCount(0);
        for (T t : ls) {
            if (t instanceof BangTinhCong) {
                model.addRow(((BangTinhCong) t).toObject());
            }
        }
    }
}
