package view;

import io.IOFile;
import java.io.IOException;
import java.util.*;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangDiem;

/**
 *
 * @author whiwf
 */
public class FormThongKe extends javax.swing.JPanel {

    /**
     * Creates new form FormThongKe
     */
    private List<BangDiem> list;
    private final String file = "BANGDIEM.TXT";
    private final String textTitle = "Ten SV\tTen MH\tDiem\tSo dvht\n";

    public FormThongKe() {
        initComponents();

    }

    private void clearData() {
        taThongKe.setText("");
        tfDiem.setText("");
    }

    private void showData(int ma) {
        String text = "" + textTitle;
        for (BangDiem bangDiem : list) {
            if (bangDiem.getSinhVien().getMa() == ma) {
                text += bangDiem;
            }
        }
        taThongKe.setText(text);
    }

    private void initCbData() {
        cbSV.removeAllItems();
        Set<String> dsSV = new HashSet<>();
        for (BangDiem bangDiem : list) {
            dsSV.add(bangDiem.getSinhVien().formatMa());
        }
        for (String ma : dsSV) {
            cbSV.addItem(ma);
        }
    }

    private void showDiemTrungBinh(int ma){
        float diem = 0;
        int soTin = 0;
        for(BangDiem bangDiem : list){
            if(bangDiem.getSinhVien().getMa() == ma){
                diem += bangDiem.getMonHoc().getSo() * bangDiem.getDiem();
                soTin += bangDiem.getMonHoc().getSo();
            }
        }
        float diemTrungBinh = (float) (1.0*diem/soTin);
        tfDiem.setText(diemTrungBinh + "");
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
        taThongKe = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDiem = new javax.swing.JTextField();
        cbSV = new javax.swing.JComboBox<>();
        btnTao = new javax.swing.JButton();

        taThongKe.setEditable(false);
        taThongKe.setColumns(20);
        taThongKe.setRows(5);
        jScrollPane1.setViewportView(taThongKe);

        jLabel1.setText("Thong ke");

        jLabel2.setText("Diem trung binh");

        tfDiem.setEditable(false);

        cbSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSVActionPerformed(evt);
            }
        });

        btnTao.setText("Tao");
        btnTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(tfDiem))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(cbSV, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(73, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTao)
                        .addGap(211, 211, 211))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(cbSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnTao)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoActionPerformed
        list = new ArrayList<>();
        try {
            list = IOFile.readFile(file);
            if (list.size() == 0) {
                throw new IOException();
            }
            initCbData();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Khong co du lieu");
        }

    }//GEN-LAST:event_btnTaoActionPerformed

    private void cbSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSVActionPerformed
        int ma = Integer.parseInt((String) cbSV.getSelectedItem());
        showData(ma);
        showDiemTrungBinh(ma);
    }//GEN-LAST:event_cbSVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTao;
    private javax.swing.JComboBox<String> cbSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taThongKe;
    private javax.swing.JTextField tfDiem;
    // End of variables declaration//GEN-END:variables
}