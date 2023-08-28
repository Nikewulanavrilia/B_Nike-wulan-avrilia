/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import Admin.Dashboard;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Session;
import koneksi.koneksi;
import static panel.Barang.tabeldashboard;
import static panel.dashboard.tabelbarang;

/**
 *
 * @author asus
 */
public class Pemasokan extends javax.swing.JPanel {
    String Tanggal;
    private DefaultTableModel model;

    /**
     * Creates new form Pemasokan
     */
    public void tampilkanTabel(){
        DefaultTableModel model = new DefaultTableModel();
        
        tabelbarang.setModel(model);
        
        model.addColumn("kode barang");
        model.addColumn("Nama barang");
        model.addColumn("Harga beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        model.addColumn("Keuntungan");
        
        
       try {
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("SELECT * from barang");
            
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("harga_beli"),
                    rs.getString("harga_jual"),
                    rs.getString("stok"),
                    rs.getString("keuntungan"),
                    
                });
                tabelbarang.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    
    public void tampilkanTabel1(){
        DefaultTableModel model = new DefaultTableModel();
        
        tabeldashboard.setModel(model);
        
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual");
        model.addColumn("Stok");
        model.addColumn("Keuntungan");
        
        
       try {
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("SELECT * from barang");
            
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("harga_beli"),
                    rs.getString("harga_jual"),
                    rs.getString("stok"),
                    rs.getString("keuntungan"),
                    
                });
                tabeldashboard.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    
    private void autocode(){
        try{
            Connection c=koneksi.configDB();
            Statement s=c.createStatement();
            String sql="select * from pemasokan order by id_pemasokan desc";
            ResultSet r=s.executeQuery(sql);
            if (r.next()){
                String nopembelian=r.getString("id_pemasokan").substring(2);
                String NP =""+(Integer.parseInt(nopembelian)+1);
                String Nol="";
                if (NP.length()==1){
                    Nol="000"; 
                }else if (NP.length()==2){
                   Nol="00";
                }else if (NP.length()==3){
                    Nol="0";
                }else if (NP.length()==4){
                    Nol="";
                }
                    txtnopembelian.setText("PM" +Nol +NP);
            }else {
                txtnopembelian.setText("PM0001");
            }
            c.close();
            s.close();
        }catch (Exception e){
            System.out.println("autonumber error");
        }
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    public void utama(){
            txtnopembelian.setText("");
            txtnamabarang.setText("");
            txtnamasupplier.setText("");
            txthargabarang.setText("");
            txtstok.setText("");
            
            
            autocode();
    }
    
    public void clear(){
            txtnamabarang.setText("");
            txtnamasupplier.setText("");
            txthargabarang.setText("");
            txtstok.setText("");
            
            
    }
    
    public Pemasokan() {
        initComponents();
        txtusernamee1.setText(Session.get_username());
        
        jTable1.getTableHeader().setFont(new Font("Fredoka One", Font.CENTER_BASELINE, 16));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(241,175,9));
        jTable1.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable1.setRowHeight(25);
       
      
//        txt_namaKasir.setText(Session.get_username());
//        txt_namaKasir.setEchoChar('*');
        
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("No Pembelian");
        model.addColumn("Nama Supplier");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Stok");
        
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txttanggal.setText(s.format(date));
        
        utama();
        autocode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusernamee1 = new javax.swing.JLabel();
        buttongradient2 = new Button.buttongradient();
        buttongradient1 = new Button.buttongradient();
        txtstok = new javax.swing.JTextField();
        txtnopembelian = new javax.swing.JTextField();
        txthargabarang = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        myButton1 = new Button.MyButton();
        myButton2 = new Button.MyButton();
        myButton3 = new Button.MyButton();
        myButton4 = new Button.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        txtidsupplier.setText("jTextField1");

        txtidbarang.setBackground(new java.awt.Color(28, 24, 18));
        txtidbarang.setForeground(new java.awt.Color(28, 24, 18));

        setMinimumSize(new java.awt.Dimension(1571, 965));
        setPreferredSize(new java.awt.Dimension(1571, 965));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/image 81.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 230, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/image 81.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1103, 150, 40, 40));

        txtusernamee1.setFont(new java.awt.Font("YouYuan", 1, 18)); // NOI18N
        txtusernamee1.setText("jLabel2");
        add(txtusernamee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 60, 150, 30));

        txtnamabarang.setBackground(new java.awt.Color(237, 231, 228));
        txtnamabarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnamabarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 240, 70));

        buttongradient2.setForeground(new java.awt.Color(51, 51, 51));
        buttongradient2.setColor1(new java.awt.Color(153, 153, 0));
        buttongradient2.setColor2(new java.awt.Color(204, 204, 0));
        buttongradient2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttongradient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttongradient2ActionPerformed(evt);
            }
        });
        add(buttongradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 60, 60));

        buttongradient1.setForeground(new java.awt.Color(51, 51, 51));
        buttongradient1.setColor1(new java.awt.Color(204, 204, 204));
        buttongradient1.setColor2(new java.awt.Color(102, 102, 102));
        buttongradient1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttongradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttongradient1ActionPerformed(evt);
            }
        });
        add(buttongradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 140, 60, 60));

        txtstok.setBackground(new java.awt.Color(237, 231, 228));
        txtstok.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtstok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 120, 160, 70));

        txtnopembelian.setBackground(new java.awt.Color(237, 231, 228));
        txtnopembelian.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnopembelian.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnopembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopembelianActionPerformed(evt);
            }
        });
        add(txtnopembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 260, 70));

        txthargabarang.setBackground(new java.awt.Color(237, 231, 228));
        txthargabarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txthargabarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txthargabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargabarangActionPerformed(evt);
            }
        });
        add(txthargabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, 250, 70));

        txttanggal.setBackground(new java.awt.Color(237, 231, 228));
        txttanggal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttanggal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });
        add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 260, 70));

        txtnamasupplier.setBackground(new java.awt.Color(237, 231, 228));
        txtnamasupplier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnamasupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnamasupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamasupplierActionPerformed(evt);
            }
        });
        add(txtnamasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 240, 70));

        myButton1.setBackground(new java.awt.Color(51, 255, 51));
        myButton1.setText("Tambah Pemaoskan");
        myButton1.setBorderColor(new java.awt.Color(51, 255, 51));
        myButton1.setColor(new java.awt.Color(51, 255, 51));
        myButton1.setColorClick(new java.awt.Color(51, 255, 51));
        myButton1.setColorOver(new java.awt.Color(51, 206, 43));
        myButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 180, 50));

        myButton2.setBackground(new java.awt.Color(0, 215, 255));
        myButton2.setText("Tambah");
        myButton2.setBorderColor(new java.awt.Color(0, 215, 255));
        myButton2.setColor(new java.awt.Color(0, 215, 255));
        myButton2.setColorClick(new java.awt.Color(0, 201, 235));
        myButton2.setColorOver(new java.awt.Color(0, 158, 195));
        myButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 90, 50));

        myButton3.setBackground(new java.awt.Color(255, 30, 30));
        myButton3.setText("Hapus");
        myButton3.setBorderColor(new java.awt.Color(255, 30, 30));
        myButton3.setColor(new java.awt.Color(255, 30, 30));
        myButton3.setColorClick(new java.awt.Color(255, 10, 11));
        myButton3.setColorOver(new java.awt.Color(255, 33, 0));
        myButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 90, 50));

        txtnamapetugas.setBackground(new java.awt.Color(237, 231, 228));
        txtnamapetugas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnamapetugas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtnamapetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapetugasActionPerformed(evt);
            }
        });
        add(txtnamapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 260, 70));

        myButton4.setBackground(new java.awt.Color(232, 126, 231));
        myButton4.setText("Tambah");
        myButton4.setBorderColor(new java.awt.Color(232, 126, 231));
        myButton4.setColor(new java.awt.Color(232, 126, 231));
        myButton4.setColorClick(new java.awt.Color(232, 126, 231));
        myButton4.setColorOver(new java.awt.Color(232, 126, 231));
        myButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 210, 110, 80));

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jTable1.setBackground(new java.awt.Color(173, 172, 172));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
    jTable1.setFocusable(false);
    jTable1.setGridColor(new java.awt.Color(0, 0, 0));
    jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
    jTable1.setRowHeight(25);
    jTable1.setSelectionBackground(new java.awt.Color(241, 175, 9));
    jTable1.getTableHeader().setResizingAllowed(false);
    jTable1.getTableHeader().setReorderingAllowed(false);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jTable1MouseEntered(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 1440, 380));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/Barang (15).png"))); // NOI18N
    jLabel1.setText("jLabel1");
    jLabel1.setPreferredSize(new java.awt.Dimension(1571, 965));
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1616, -1));

    txtkodepetugas.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtkodepetugasActionPerformed(evt);
        }
    });
    add(txtkodepetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 260, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void buttongradient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttongradient2ActionPerformed
        // TODO add your handling code here:
        data_barang db = new data_barang();
        db.setVisible(true);
    }//GEN-LAST:event_buttongradient2ActionPerformed

    private void buttongradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttongradient1ActionPerformed
        data_supplier ds = new data_supplier();
        ds.setVisible(true);
    }//GEN-LAST:event_buttongradient1ActionPerformed

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

    private void txtnamapetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamapetugasActionPerformed

    private void txtnopembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnopembelianActionPerformed

    private void txthargabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargabarangActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttanggalActionPerformed

    private void txtnamasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamasupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamasupplierActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object []{
            txtnopembelian.getText(),
            txtnamasupplier.getText(),
            txtnamabarang.getText(),
            txthargabarang.getText(),
            txtstok.getText()
        });
        clear();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        /*String id_pembelian =  txtnopembelian.getText();
        String tanggal = txttanggal.getText();
        String id_supplier = txtnamasupplier.getText();
        String kode = txtkodepetugas.getText();*/

        try{
            String sql = "insert into pemasokan (id_pemasokan, tanggal, id_supplier, nik) values "+"('"+txtnopembelian.getText()+"',now(),'"+txtidsupplier.getText()+"','"+txtkodepetugas.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            /*pst.setString(1, id_pembelian);
            pst.setString(2, tanggal);
            pst.setString(3, id_supplier);
            pst.setString(4, kode);*/
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
        }

        try{
            java.sql.Connection conn = (Connection)koneksi.configDB();
            int baris = jTable1.getRowCount();

            for(int i = 0; i < baris; i++){
                String sql = "insert into detail_pemasokan (id_pemasokan, harga_baru, id_barang, qty) values ('" + jTable1.getValueAt(i, 0) + "','"
                + jTable1.getValueAt(i, 3) + "','" + txtidbarang.getText() + "','" + jTable1.getValueAt(i, 4) + "')";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(null, "Berhasil");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
        }
        clear();
        utama();
        autocode();
        kosong();
        tampilkanTabel();
        tampilkanTabel1();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void txtkodepetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodepetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodepetugasActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
    }//GEN-LAST:event_myButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered

    }//GEN-LAST:event_jTable1MouseEntered

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Dashboard.bt.setVisible(true);

    }//GEN-LAST:event_myButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.buttongradient buttongradient1;
    private Button.buttongradient buttongradient2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private Button.MyButton myButton1;
    private Button.MyButton myButton2;
    private Button.MyButton myButton3;
    private Button.MyButton myButton4;
    private javax.swing.JTextField txthargabarang;
    public static final javax.swing.JTextField txtidbarang = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtidsupplier = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtkodepetugas = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnamabarang = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnamapetugas = new javax.swing.JTextField();
    public static final javax.swing.JTextField txtnamasupplier = new javax.swing.JTextField();
    private javax.swing.JTextField txtnopembelian;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JLabel txtusernamee1;
    // End of variables declaration//GEN-END:variables
}
