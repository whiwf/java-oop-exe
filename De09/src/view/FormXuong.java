package view;

import io.IOFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XuongSanXuat;

/**
 *
 * @author whiwf
 */
public class FormXuong extends javax.swing.JPanel implements ViewInterface {

    /**
     * Creates new form FormXuong
     */
    private DefaultTableModel model;
    private List<XuongSanXuat> list;
    private final String FILE = "XSX.TXT";

    public FormXuong() {
        initComponents();
        String colsString[] = {"Ma xuong", "Ten", "Mo ta", "He so"};
        model = new DefaultTableModel(colsString, 0);
        table.setModel(model);

        initListData();
        btnFalse();
    }

    private void initListData() {
        list = new ArrayList<>();
        list = IOFile.readFile(FILE);
        if (list.size() > 0) {
            showData(list, model);
            int ma = list.get(list.size() - 1).getMa() + 1;
            XuongSanXuat.setsMa(ma);
        }
    }

    private void clearData() {
        tfTen.setText("");
        tfMoTa.setText("");
        tfHeSo.setText("");
    }

    private void btnTrue() {
        btnHuy.setEnabled(true);
        btnLuu.setEnabled(true);
    }

    private void btnFalse() {
        btnHuy.setEnabled(false);
        btnLuu.setEnabled(false);
    }

    private String stringInputFormat(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    private boolean isFormatted(String s, String regex) {
        String checkArr[] = s.split(" ");
        for (String check : checkArr) {
            if (!check.matches(regex)) {
                return false;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        tfMoTa = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        tfHeSo = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Them"));

        jLabel1.setText("Ten");

        jLabel2.setText("Mo Ta");

        jLabel4.setText("He so");

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
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnHuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnThem)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnThem)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String ten = "", moTa = "", heSo = "";
        float so = 0;
        boolean isOk = true;
        try {
            ten = stringInputFormat(tfTen.getText());
            if (ten.length() == 0) {
                throw new IOException();
            }
            String regexTen = "^[a-zA-Z]+$";
            if (!isFormatted(ten, regexTen)) {
                throw new InputMismatchException();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ten khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Ten sai dinh dang");
            isOk = false;
        }
        try {
            moTa = stringInputFormat(tfMoTa.getText());
            if (moTa.length() == 0) {
                throw new IOException();
            }
            String regexMoTa = "^[a-zA-Z0-9]+$";
            if (!isFormatted(moTa, regexMoTa)) {
                throw new InputMismatchException();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Mo ta khong de trong");
            isOk = false;
        } catch (InputMismatchException e) {
            JOptionPane.showMessageDialog(null, "Mo ta sai dinh dang");
            isOk = false;
        }

        try {
            heSo = stringInputFormat(tfHeSo.getText());
            if (heSo.length() == 0) {
                throw new IOException();
            }
            so = Float.parseFloat(heSo);
            if(so < 1 || so > 20)
                throw new NumberFormatException();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "He so khong de trong");
            isOk = false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "He so sai dinh dang");
            isOk = false;
        }
        if (isOk) {
            XuongSanXuat c = new XuongSanXuat(ten, moTa, so);
            addToList(list, c);
            IOFile.writeFile(FILE, list);
            clearData();
            btnFalse();
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        clearData();
        btnFalse();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        clearData();
        btnTrue();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfHeSo;
    private javax.swing.JTextField tfMoTa;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void addToList(List<T> ls, T t) {
        ls.add(t);
        showData(ls, model);
    }

    @Override
    public <T> void showData(List<T> ls, DefaultTableModel md) {
        md.setRowCount(0);
        for (T t : ls) {
            if (t instanceof XuongSanXuat) {
                md.addRow(((XuongSanXuat) t).toObjects());
            }
        }
    }
}