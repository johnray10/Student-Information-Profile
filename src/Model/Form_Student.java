/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author JayJomJohn
 */
public class Form_Student extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    CallableStatement cst;

    public static String ImgPath;

    public Form_Student() {
        initComponents();
        conn = Database.JavaConnector.ConnectDB();
        showIcon();
        showStudentList();

    }

    private void showIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/job.png")));
    }

    private void showStudentList() {
        try {
            pst = conn.prepareStatement("SELECT * FROM vw_getallstudents");
            rs = pst.executeQuery();
            tbl_employee.setModel(DbUtils.resultSetToTableModel(rs));
            tbl_employee.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            lbl_TotalEntry.setText("TOTAL ENTRY: " + tbl_employee.getRowCount());
            tbl_employee.getColumnModel().getColumn(0).setWidth(100);
            tbl_employee.getColumnModel().getColumn(0).setMinWidth(100);
            tbl_employee.getColumnModel().getColumn(0).setMaxWidth(100);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tbl_employee.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_employee.getColumnModel().getColumn(1).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(2).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(3).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbl_employee.getColumnModel().getColumn(5).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(6).setPreferredWidth(60);
            tbl_employee.getColumnModel().getColumn(7).setPreferredWidth(800);
            tbl_employee.setSelectionBackground(Color.ORANGE);

        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        cmbboxFilter = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        btnAddNewStudent = new javax.swing.JButton();
        lbl_TotalEntry = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 650));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbboxFilter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbboxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Student ID", "Last Name", "Given Name", "Middle Name", "Gender", "Date of Birth", "Age", "Address" }));
        cmbboxFilter.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.add(cmbboxFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 210, 30));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 210, 30));

        tbl_employee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_employee.setFillsViewportHeight(true);
        tbl_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_employee);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 88, 1210, 470));

        btnAddNewStudent.setBackground(new java.awt.Color(30, 139, 195));
        btnAddNewStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddNewStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewStudent.setText("ADD A NEW STUDENT");
        btnAddNewStudent.setBorderPainted(false);
        btnAddNewStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddNewStudent.setFocusPainted(false);
        btnAddNewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewStudentActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddNewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, 230, 40));

        lbl_TotalEntry.setBackground(new java.awt.Color(51, 0, 102));
        lbl_TotalEntry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_TotalEntry.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TotalEntry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_TotalEntry.setText("TOTAL ENTRY:");
        lbl_TotalEntry.setInheritsPopupMenu(false);
        jPanel1.add(lbl_TotalEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(1132, 570, 120, 40));

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewStudentActionPerformed
        Form_AddNewStudent nextform = new Form_AddNewStudent();
        nextform.show();
    }//GEN-LAST:event_btnAddNewStudentActionPerformed

    private Image scaledImage(byte[] img, int w, int h) {
        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D g2 = resizedImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            ByteArrayInputStream in = new ByteArrayInputStream(img);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            g2.drawImage(bImageFromConvert, 0, 0, w, h, null);
            g2.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        return resizedImage;
    }

    private void tbl_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_employeeMouseClicked
        try {
            String employeeId = (this.tbl_employee.getValueAt(this.tbl_employee.getSelectedRow(), 0).toString());
            pst = conn.prepareStatement("SELECT * FROM tbl_students WHERE ID=?");
            pst.setString(1, employeeId);
            rs = pst.executeQuery();
            if (rs.next()) {
                Form_StudentProfile sp = new Form_StudentProfile();
                sp.setVisible(true);
                btnAddNewStudent.setVisible(false);
                cmbboxFilter.setVisible(false);
                txtSearch.setVisible(false);
                sp.setLocationRelativeTo(this);
                sp.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        if (txtSearch.getText().equals("")) {
                            showStudentList();
                        } else {
                            SearchData();
                        }
                        btnAddNewStudent.setVisible(true);
                        cmbboxFilter.setVisible(true);
                        txtSearch.setVisible(true);
                    }
                });
                sp.txtStudentId.setText(rs.getInt(1) + "");
                sp.txtLastName.setText(rs.getString(2));
                sp.txtGivenName.setText(rs.getString(3));
                sp.txtMiddleName.setText(rs.getString(4));
                String tempgender = (rs.getString(5));
                if ("1".equals(tempgender)) {
                    sp.radiobtnMale.setSelected(true);
                } else if ("2".equals(tempgender)) {
                    sp.radiobtnFemale.setSelected(true);
                }
                sp.dcDateOfBirth.setDate(rs.getDate(6));
                sp.txtAge.setText(rs.getInt(7) + "");
                sp.txtAddress.setText(rs.getString(8));
                byte[] imageByte = rs.getBytes("Photo");
                ImageIcon format = new ImageIcon(scaledImage(imageByte, sp.lblProfile.getWidth(), sp.lblProfile.getHeight()));
                sp.lblProfile.setIcon(format);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_employeeMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        if (txtSearch.getText().length() >= 30) {
            evt.consume();
        }
        String stringHolder = (String) cmbboxFilter.getSelectedItem();
        char c = evt.getKeyChar();
        switch (stringHolder) {
            case "None":
                if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == KeyEvent.VK_DELETE || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Student ID":
                if (!(Character.isDigit(c) || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
                break;
            case "Last Name":
                if (!(Character.isAlphabetic(c) || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Given Name":
                if (!(Character.isAlphabetic(c) || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Middle Name":
                if (!(Character.isAlphabetic(c) || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Gender":
                if (!(Character.isAlphabetic(c) || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Date of Birth":
                if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == KeyEvent.VK_DELETE || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
            case "Age":
                if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == KeyEvent.VK_DELETE || Character.isWhitespace(c))) {
                    evt.consume();
                }
                break;
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        SearchData();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void SearchData() {
        try {
            String sql = "SELECT \n"
                    + "`tbl_students`.`id` AS `STUDENT ID`, \n"
                    + "`tbl_students`.`Last_Name` AS `LAST NAME`, \n"
                    + "`tbl_students`.`Given_Name` AS `GIVEN NAME`, \n"
                    + "`tbl_students`.`Middle_Name` AS `MIDDLE NAME`, \n"
                    + "`tbl_genders`.`gender` AS `GENDER`, \n"
                    + "`tbl_students`.`Date_of_Birth` AS `DATE OF BIRTH`,\n"
                    + " `tbl_students`.`Age` AS `AGE`, \n"
                    + " `tbl_students`.`Address` AS `ADDRESS`, \n"
                    + " `tbl_students`.`Photo` AS `photo`\n"
                    + " FROM `tbl_students`\n"
                    + " INNER JOIN `tbl_genders` ON `tbl_students`.`Gender_Id` = `tbl_genders`.`id`\n"
                    + " WHERE `tbl_students`.`id` LIKE '%" + txtSearch.getText() + "%' OR `tbl_students`.`last_name` LIKE '%" + txtSearch.getText() + "%' `tbl_students`.`given_name` LIKE '%" + txtSearch.getText() + "%' `tbl_students`.`middle_name` LIKE '%" + txtSearch.getText() + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tbl_employee.setModel(DbUtils.resultSetToTableModel(rs));
            tbl_employee.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            lbl_TotalEntry.setText("TOTAL ENTRY: " + tbl_employee.getRowCount());
            tbl_employee.getColumnModel().getColumn(0).setWidth(100);
            tbl_employee.getColumnModel().getColumn(0).setMinWidth(100);
            tbl_employee.getColumnModel().getColumn(0).setMaxWidth(100);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tbl_employee.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_employee.getColumnModel().getColumn(1).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(2).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(3).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(4).setPreferredWidth(120);
            tbl_employee.getColumnModel().getColumn(5).setPreferredWidth(260);
            tbl_employee.getColumnModel().getColumn(6).setPreferredWidth(60);
            tbl_employee.getColumnModel().getColumn(7).setPreferredWidth(800);
            tbl_employee.setSelectionBackground(Color.ORANGE);

        } catch (Exception e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewStudent;
    private javax.swing.JComboBox<String> cmbboxFilter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_TotalEntry;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
