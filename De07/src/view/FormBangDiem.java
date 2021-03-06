package view;

import io.IOFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangDiem;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author whiwf
 */
public class FormBangDiem extends javax.swing.JPanel implements ViewInterface{

    /**
     * Creates new form FormBangDiem
     */
    private DefaultTableModel model;
    private List<MonHoc> listMH;
    private List<SinhVien> listSV;
    private List<BangDiem> listBD;

    private final String fileMH = "MONHOC.TXT", fileSV = "SV.TXT", fileBD = "BANGDIEM.TXT";

    public FormBangDiem() {
        initComponents();
        String cols[] = {"Ten SV", "Ten MH", "Diem"};
        model = new DefaultTableModel(cols, 0);
        table.setModel(model);

        listBD = new ArrayList<>();

        btnFalse();
    }

    private void initCbData() {
        try {
            listSV = new ArrayList<>();
            listSV = IOFile.readFile(fileSV);

            listMH = new ArrayList<>();
            listMH = IOFile.readFile(fileMH);

            if (listSV.size() == 0 || listMH.size() == 0) {
                throw new InputMismatchException();
            }
            addToCb(cbSV, listSV);
            addToCb(cbMH, listMH);
            btnTrue();
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Du lieu con trong");
        }
    }

    private <T> void addToCb(JComboBox cb, List<T> ls) {
        cb.removeAllItems();
        for (T t : ls) {
            if (t instanceof SinhVien) {
                cb.addItem(((SinhVien) t).formatMa());
            } else if (t instanceof MonHoc) {
                cb.addItem(((MonHoc) t).formatMa());
            }
        }
    }

    private void btnTrue() {
        btnHuy.setEnabled(true);
        btnLuu.setEnabled(true);
    }

    private void btnFalse() {
        btnHuy.setEnabled(false);
        btnLuu.setEnabled(false);
    }

    private void clearData() {
        tfDiem.setText("");
    }

    private String formatStringInput(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    private <T> T findByMa(int ma, List<T> ls) {
        for (T t : ls) {
            if (t instanceof SinhVien) {
                if (((SinhVien) t).getMa() == ma) {
                    return t;
                }
            } else if (t instanceof MonHoc) {
                if (((MonHoc) t).getMa() == ma) {
                    return t;
                }
            }
        }
        return null;
    }

    private boolean canAddToList(int maSV, int maMH){
        for(BangDiem bangDiem : listBD){
            if(bangDiem.getSinhVien().getMa() == maSV && bangDiem.getMonHoc().getMa() == maMH)
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        tfDiem = new javax.swing.JTextField();
        cbSV = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbMH = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rbtnSV = new javax.swing.JRadioButton();
        rbtnMH = new javax.swing.JRadioButton();

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

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Them"));

        jLabel2.setText("Diem");

        jLabel3.setText("Ma SV");

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

        jLabel4.setText("Ma MH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDiem)
                    .addComponent(cbSV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnLuu))
                .addGap(35, 35, 35))
        );

        jLabel1.setText("Sap xep:");

        buttonGroup1.add(rbtnSV);
        rbtnSV.setText("Ten SV");
        rbtnSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSVActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnMH);
        rbtnMH.setText("Ten MH");
        rbtnMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMHActionPerformed(evt);
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
                                .addGap(27, 27, 27)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnThem))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(rbtnSV)
                        .addGap(55, 55, 55)
                        .addComponent(rbtnMH)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnThem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rbtnSV)
                    .addComponent(rbtnMH))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        initCbData();
        clearData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        int maSV = Integer.parseInt((String) cbSV.getSelectedItem());
        int maMH = Integer.parseInt((String) cbMH.getSelectedItem());
        boolean isOk = true;
        float diem = (float) 0.0;
        try {
            String diemSo = formatStringInput(tfDiem.getText());
            if (diemSo.length() == 0) {
                throw new IOException();
            }
            diem = Float.parseFloat(diemSo);
            if(diem < 0 || diem > 10)
                throw new NumberFormatException();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Diem khong de trong");
            isOk = false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Diem sai dinh dang");
            isOk = false;
        }
        if (isOk) {
            try {
                if(!canAddToList(maSV, maMH))
                    throw new IOException();
                SinhVien sv = findByMa(maSV, listSV);
                MonHoc mh = findByMa(maMH, listMH);
                BangDiem bangDiem = new BangDiem(sv, mh, diem);
                addTo(bangDiem);
                IOFile.writeFile(fileBD, listBD);
                clearData();
                btnFalse();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Du lieu da ton tai");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        clearData();
        btnFalse();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void rbtnSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSVActionPerformed
        try{
            listBD = IOFile.readFile(fileBD);
            if(listBD.size() == 0)
                throw new IOException();
            Collections.sort(listBD, (b1, b2) -> {
                return b1.getSinhVien().getTen().compareToIgnoreCase(b2.getSinhVien().getTen());
            });
            showData(listBD, model);
        }  catch(IOException e){
            JOptionPane.showMessageDialog(null, "Khong co du lieu");
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_rbtnSVActionPerformed

    private void rbtnMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMHActionPerformed
        try{
            listBD = IOFile.readFile(fileBD);
            if(listBD.size() == 0)
                throw new IOException();
            Collections.sort(listBD, (b1, b2) -> {
                return b1.getMonHoc().getTen().compareToIgnoreCase(b2.getMonHoc().getTen());
            });
            showData(listBD, model);
        }  catch(IOException e){
            JOptionPane.showMessageDialog(null, "Khong co du lieu");
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_rbtnMHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMH;
    private javax.swing.JComboBox<String> cbSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnMH;
    private javax.swing.JRadioButton rbtnSV;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfDiem;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addTo(T t) {
        listBD.add((BangDiem) t);
        showData(listBD, model);
    }

    @Override
    public <T> void showData(List<T> ls, DefaultTableModel md) {
        md.setRowCount(0);
        for(T t : ls){
            if(t instanceof BangDiem){
                md.addRow(((BangDiem) t).toObjects());
            }
        }
    }
}
