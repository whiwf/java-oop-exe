package view;

import io.IOFile;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;

/**
 *
 * @author whiwf
 */
public class FormSinhVien extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form FormSinhVien
     */
    private DefaultTableModel model;
    private List<SinhVien> list;
    private final String file = "SV.TXT";
    private final String DATE_FORMAT = "yyyy/MM/dd";

    public FormSinhVien() {
        initComponents();
        String cols[] = {"Ma SV", "Ten", "Dia chi", "Ngay sinh", "Lop"};
        model = new DefaultTableModel(cols, 0);
        table.setModel(model);

        initListData();
        initCbData();
        btnFalse();
        clearData();
    }

    private void initListData() {
        list = new ArrayList<>();
        list = IOFile.readFile(file);
        if (list.size() > 0) {
            showData(list, model);
            int ma = list.get(list.size() - 1).getMa() + 1;
            SinhVien.setsMa(ma);
        }
    }

    private void initCbData() {
        String lops[] = {"D18CQCN01-B", "D18CQCN02-B", "D18CQCN03-B", "D18CQCN04-B"};

        cbLop.removeAllItems();

        for (String lop : lops) {
            cbLop.addItem(lop);
        }
    }

    private void btnTrue() {
        btnLuu.setEnabled(true);
        btnHuy.setEnabled(true);
        tfTen.setEditable(true);
        tfDiaChi.setEditable(true);
        tfNgaySinh.setEditable(true);
    }

    private void btnFalse() {
        btnLuu.setEnabled(false);
        btnHuy.setEnabled(false);
        tfTen.setEditable(false);
        tfDiaChi.setEditable(false);
        tfNgaySinh.setEditable(false);
    }

    private void clearData() {
        tfTen.setText("");
        tfDiaChi.setText("");
        tfNgaySinh.setText("");
        erTen.setText("");
        erDiaChi.setText("");
        erNgay.setText("");
        lbNgay.setText("Nhap dang: yyyy/MM/dd");
    }

    private String formatStringInput(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    private boolean checkValidString(String s, String regex) {
        String checkArr[] = s.split(" ");
        for (String check : checkArr) {
            if (!check.matches(regex)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDateValid(String ngay) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            //format date
            df.setLenient(false);
            ngay = df.format(df.parse(ngay));
            //compare to current date
            Date date = new Date();
            String curDate = df.format(date);
            if (ngay.compareTo(curDate) > 0) {
                throw new IOException();
            }
            return true;
        } catch (ParseException e) {
            return false;
        } catch (IOException e) {
            return false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        tfDiaChi = new javax.swing.JTextField();
        tfNgaySinh = new javax.swing.JTextField();
        cbLop = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        erTen = new javax.swing.JLabel();
        erDiaChi = new javax.swing.JLabel();
        erNgay = new javax.swing.JLabel();
        lbNgay = new javax.swing.JLabel();
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

        jLabel2.setText("Ten");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Ngay sinh");

        jLabel5.setText("Lop");

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

        erTen.setForeground(new java.awt.Color(255, 0, 51));

        erDiaChi.setForeground(new java.awt.Color(255, 0, 51));

        erNgay.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(76, 76, 76)
                .addComponent(btnLuu)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(erNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(erDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(erTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(tfTen)
                        .addComponent(tfNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(cbLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erTen)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erDiaChi)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addGap(26, 26, 26))
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
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnThem)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnThem)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        btnTrue();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String ten = "", diaChi = "", ngaySinh = "";
        boolean isOk = true;
        try {
            ten = formatStringInput(tfTen.getText());
            if (ten.length() == 0) {
                throw new IOException();
            }
            String regexTen = "^[a-zA-Z]+$";
            if (!checkValidString(ten, regexTen)) {
                throw new InputMismatchException();
            }
            erTen.setText("");
        } catch (IOException e) {
            erTen.setText("Ten khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            erTen.setText("Ten sai dinh dang");
            isOk = false;
        }
        try {
            diaChi = formatStringInput(tfDiaChi.getText());
            if (diaChi.length() == 0) {
                throw new IOException();
            }
            String regexDiaChi = "^[a-zA-Z0-9/-]+$";
            if (!checkValidString(diaChi, regexDiaChi)) {
                throw new InputMismatchException();
            }
            erDiaChi.setText("");
        } catch (IOException e) {
            erDiaChi.setText("Dia chi khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            erDiaChi.setText("Dia chi sai dinh dang");
            isOk = false;
        }
        try {
            ngaySinh = formatStringInput(tfNgaySinh.getText());
            if (ngaySinh.length() == 0) {
                throw new IOException();
            }
            if (!isDateValid(ngaySinh)) {
                throw new InputMismatchException();
            }
            erNgay.setText("");
        } catch (IOException e) {
            erNgay.setText("Ngay sinh khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            erNgay.setText("Ngay sai dinh dang");
            isOk = false;
        }
        String lop = (String) cbLop.getSelectedItem();
        if (isOk) {
            SinhVien sv = new SinhVien(ten, diaChi, ngaySinh, lop);
            addTo(sv);
            IOFile.writeFile(file, list);
            clearData();
            btnFalse();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        clearData();
        btnFalse();
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JLabel erDiaChi;
    private javax.swing.JLabel erNgay;
    private javax.swing.JLabel erTen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNgay;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfNgaySinh;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addTo(T t) {
        list.add((SinhVien) t);
        showData(list, model);
    }

    @Override
    public <T> void showData(List<T> ls, DefaultTableModel md) {
        md.setRowCount(0);
        for (T t : ls) {
            if (t instanceof SinhVien) {
                md.addRow(((SinhVien) t).toObjects());
            }
        }
    }
}
