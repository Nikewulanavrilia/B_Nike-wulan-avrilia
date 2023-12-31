/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import koneksi.Session;
import koneksi.koneksi;

/**
 *
 * @author asus
 */
public class Pengaturan extends javax.swing.JPanel {
     public void ShowData(){
        DefaultTableModel model = new DefaultTableModel();
        
        jTable2.setModel(model);
        model.addColumn("Kode User");
        model.addColumn("Nama Lengkap");
        model.addColumn("Alamat");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Jabatan");
        model.addColumn("Question");
        model.addColumn("Answer");
        
        try{
        Statement s = koneksi.configDB().createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM user");
        
        while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getString("nik"),
                    rs.getString("nama_lengkap"),
                    rs.getString("alamat"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("jabatan"),
                    rs.getString("question"),
                    rs.getString("answer"),
                    
                });
                jTable2.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
    }   
        
    }
     
    public void clear(){
        txtnik.setText("");
        txtnamalengkap.setText("");
        txtalamat.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtquestion.setText("");
        txtanswer.setText("");
       
    }

    /**
     * Creates new form Pengaturan
     */
    public Pengaturan() {
        try{
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex){
            ex.getMessage();
             
        }
        initComponents();
          jTable2.getTableHeader().setFont(new Font("Fredoka One", Font.CENTER_BASELINE, 16));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(241,175,9));
        jTable2.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable2.setRowHeight(25);
       
        txtusernamee1.setText(Session.get_username());
        ShowData();
        txtnik.requestFocus();
         txtusernamee1.setText(Session.get_username());
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
        txtusernamee1 = new javax.swing.JLabel();
        myButton4 = new Button.MyButton();
        myButton3 = new Button.MyButton();
        txtalamat = new javax.swing.JTextField();
        txtnamalengkap = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtquestion = new javax.swing.JTextField();
        myButton2 = new Button.MyButton();
        rAdmin = new javax.swing.JRadioButton();
        rKaryawan = new javax.swing.JRadioButton();
        txtnik = new javax.swing.JTextField();
        txtanswer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1571, 965));
        setPreferredSize(new java.awt.Dimension(1571, 965));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusernamee1.setFont(new java.awt.Font("YouYuan", 1, 18)); // NOI18N
        txtusernamee1.setText("jLabel2");
        add(txtusernamee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 60, 150, 30));

        myButton4.setBackground(new java.awt.Color(255, 228, 0));
        myButton4.setText("Edit");
        myButton4.setBorderColor(new java.awt.Color(255, 228, 0));
        myButton4.setColor(new java.awt.Color(255, 228, 0));
        myButton4.setColorClick(new java.awt.Color(255, 228, 0));
        myButton4.setColorOver(new java.awt.Color(255, 190, 2));
        myButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myButton4.setRadius(10);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 850, 100, 75));

        myButton3.setBackground(new java.awt.Color(0, 215, 255));
        myButton3.setText("Tambah");
        myButton3.setBorderColor(new java.awt.Color(0, 215, 255));
        myButton3.setColor(new java.awt.Color(0, 215, 255));
        myButton3.setColorClick(new java.awt.Color(0, 201, 235));
        myButton3.setColorOver(new java.awt.Color(0, 158, 195));
        myButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myButton3.setRadius(10);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 850, 100, 75));

        txtalamat.setBackground(new java.awt.Color(237, 231, 228));
        txtalamat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtalamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtalamat.setMinimumSize(new java.awt.Dimension(4, 33));
        txtalamat.setPreferredSize(new java.awt.Dimension(4, 33));
        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });
        add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 390, 310, 40));

        txtnamalengkap.setBackground(new java.awt.Color(237, 231, 228));
        txtnamalengkap.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnamalengkap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnamalengkap.setMinimumSize(new java.awt.Dimension(4, 33));
        txtnamalengkap.setPreferredSize(new java.awt.Dimension(4, 33));
        txtnamalengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamalengkapActionPerformed(evt);
            }
        });
        add(txtnamalengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 330, 310, 40));

        txtusername.setBackground(new java.awt.Color(237, 231, 228));
        txtusername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtusername.setMinimumSize(new java.awt.Dimension(4, 33));
        txtusername.setPreferredSize(new java.awt.Dimension(4, 33));
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 460, 310, 40));

        txtpassword.setBackground(new java.awt.Color(237, 231, 228));
        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtpassword.setMinimumSize(new java.awt.Dimension(4, 33));
        txtpassword.setPreferredSize(new java.awt.Dimension(4, 33));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 530, 310, 40));

        txtquestion.setBackground(new java.awt.Color(237, 231, 228));
        txtquestion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtquestion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtquestion.setMinimumSize(new java.awt.Dimension(4, 33));
        txtquestion.setPreferredSize(new java.awt.Dimension(4, 33));
        txtquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquestionActionPerformed(evt);
            }
        });
        add(txtquestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 600, 310, 40));

        myButton2.setBackground(new java.awt.Color(255, 30, 30));
        myButton2.setText("Hapus");
        myButton2.setBorderColor(new java.awt.Color(255, 30, 30));
        myButton2.setColor(new java.awt.Color(255, 30, 30));
        myButton2.setColorClick(new java.awt.Color(255, 10, 11));
        myButton2.setColorOver(new java.awt.Color(255, 33, 0));
        myButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myButton2.setRadius(10);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 850, 100, 75));

        rAdmin.setBackground(new java.awt.Color(237, 231, 228));
        buttonGroup1.add(rAdmin);
        rAdmin.setText("Admin");
        rAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAdminActionPerformed(evt);
            }
        });
        add(rAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 750, 90, -1));

        rKaryawan.setBackground(new java.awt.Color(237, 231, 228));
        buttonGroup1.add(rKaryawan);
        rKaryawan.setText("Karyawan");
        add(rKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 750, -1, -1));

        txtnik.setBackground(new java.awt.Color(237, 231, 228));
        txtnik.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnik.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnik.setMinimumSize(new java.awt.Dimension(4, 33));
        txtnik.setPreferredSize(new java.awt.Dimension(4, 33));
        txtnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnikActionPerformed(evt);
            }
        });
        add(txtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 260, 310, 40));

        txtanswer.setBackground(new java.awt.Color(237, 231, 228));
        txtanswer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtanswer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtanswer.setMinimumSize(new java.awt.Dimension(4, 33));
        txtanswer.setPreferredSize(new java.awt.Dimension(4, 33));
        txtanswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanswerActionPerformed(evt);
            }
        });
        add(txtanswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 670, 310, 40));

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable2.setBackground(new java.awt.Color(173, 172, 172));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    jTable2.setFocusable(false);
    jTable2.setGridColor(new java.awt.Color(0, 0, 0));
    jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
    jTable2.setRowHeight(25);
    jTable2.setSelectionBackground(new java.awt.Color(241, 175, 9));
    jTable2.getTableHeader().setResizingAllowed(false);
    jTable2.getTableHeader().setReorderingAllowed(false);
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTable2MouseEntered(evt);
        }
    });
    jScrollPane1.setViewportView(jTable2);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 910, 730));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/pengaturan (11).png"))); // NOI18N
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
       String jk = null;
        if(rAdmin.isSelected()){
            jk = "Admin";
        }else if(rKaryawan.isSelected()){
            jk = "Karyawan";
        }
        try{
            String sql = "INSERT INTO user(nik, nama_lengkap , alamat, username, password, jabatan, question, answer) VALUES ('"+txtnik.getText()+"','"+txtnamalengkap.getText()
                    +"','"+txtalamat.getText()+"','"+txtusername.getText()+"','"+txtpassword.getText()
                    +"','"+jk+"','"+txtquestion.getText()+"','"+txtanswer.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            ShowData();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n" +e.getMessage());
        }
        clear();
          

    }//GEN-LAST:event_myButton3ActionPerformed

    private void txtnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnikActionPerformed
        // TODO add your handling code here:
        txtnamalengkap.requestFocus();
    }//GEN-LAST:event_txtnikActionPerformed

    private void txtnamalengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamalengkapActionPerformed
        // TODO add your handling code here:
        txtalamat.requestFocus();
    }//GEN-LAST:event_txtnamalengkapActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
        txtusername.requestFocus();

    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
        txtpassword.requestFocus();
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
        txtquestion.requestFocus();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquestionActionPerformed
        // TODO add your handling code here:
        txtanswer.requestFocus();
    }//GEN-LAST:event_txtquestionActionPerformed

    private void txtanswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanswerActionPerformed

    private void rAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rAdminActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        String jk = null;
        if(rAdmin.isSelected()){
            jk = "Admin";
        }else if(rKaryawan.isSelected()){
            jk = "Karyawan";
        }
        try{
            String sql = "UPDATE user SET nama_lengkap='"+txtnamalengkap.getText()+"', alamat='"+txtalamat.getText()+"', username='"
                    +txtusername.getText()+"', password='"+txtpassword.getText()
                    +"', jabatan='"+ jk +"', question='"+txtquestion.getText()+"', answer='"+txtanswer.getText()+"' WHERE nik='"+txtnik.getText()+"'"; 
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Edit");
            ShowData();
            clear();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE from user where nik='"+txtnik.getText()+"'";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            ShowData();
            clear();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_myButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        String nik = model.getValueAt(i, 0).toString();
        String nama = model.getValueAt(i, 1).toString();
        String alamat = model.getValueAt(i, 2).toString();
        String username = model.getValueAt(i, 3).toString();
        String password = model.getValueAt(i, 4).toString();
        String question = model.getValueAt(i, 6).toString();
        String answer = model.getValueAt(i, 7).toString();

        txtnik.setText(nik);
        txtnamalengkap.setText(nama);
        txtalamat.setText(alamat);
        txtusername.setText(username);
        txtpassword.setText(password);
        txtquestion.setText(question);
        txtanswer.setText(answer);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
       
    }//GEN-LAST:event_jTable2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable2;
    private Button.MyButton myButton2;
    private Button.MyButton myButton3;
    private Button.MyButton myButton4;
    private javax.swing.JRadioButton rAdmin;
    private javax.swing.JRadioButton rKaryawan;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtanswer;
    private javax.swing.JTextField txtnamalengkap;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtquestion;
    private javax.swing.JTextField txtusername;
    private javax.swing.JLabel txtusernamee1;
    // End of variables declaration//GEN-END:variables
}
