/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static panel.Barang.txttotalpemasukan;
import static panel.Barang.tabeldashboard;
import static panel.dashboard.tabelbarang;

/**
 *
 * @author asus
 */
public class Kasir extends javax.swing.JPanel {
    String Tanggal;
    private DefaultTableModel model;
    
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
    
    public void pendapatan(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tanggal = currentDate.format(dateFormatter);
        try{
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("SELECT sum(grand_total) from transaksi where tanggal = '"+tanggal+"'");
            while(rs.next()){
                txttotalpemasukan.setText(rs.getString("sum(grand_total)"));
            }
        }catch(Exception e){
            
        }
    }

    
    public void grandtotal(){
        int jumlahbaris = jTable1.getRowCount();
        int grandtotal = 0;
        int jumlahbarang, hargabarang;
        for (int i = 0; i < jumlahbaris; i++){
            jumlahbarang = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            hargabarang = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            grandtotal = grandtotal + (jumlahbarang * hargabarang);
        }
        txtgrandtotal.setText(String.valueOf(grandtotal));
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object []{
            txtnotransaksi.getText(),
            txtkodebarang.getText(),
            txtnamabarang.getText(),
            txthargabarang.getText(),
            txtjumlah.getText(),
            txttotal.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    public void utama(){
            txtnotransaksi.setText("");
            txtkodebarang.setText("");
            txtnamabarang.setText("");
            txthargabarang.setText("");
            txtjumlah.setText("");
            txttotal.setText("");
            txtgrandtotal.setText("0");
            txtbayar.setText("");
            txtkembali.setText("0");
            autonumber();
            
    }
    
    public void clear(){
            txtkodebarang.setText("");
            txtnamabarang.setText("");
            txthargabarang.setText("");
            txtjumlah.setText("");
            txttotal.setText("");
            txtstok.setText("");
            
            
            
            
    }
    
    private void autonumber(){
        try{
            String sql = "select * from transaksi order by id_transaksi desc";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()){
                String NoTrans = rs.getString("id_transaksi").substring(2);
                String TR = "" + (Integer.parseInt(NoTrans)+1);
                String Nol = "";
                
                if (TR.length()==1){
                    Nol = "000";
                }else if (TR.length()==2){
                    Nol = "00";
                }else if (TR.length()==3){
                    Nol = "0";
                }else if(TR.length()==4){
                    Nol = "";
                }txtnotransaksi.setText("TR" +  Nol + TR);
            }else{
                txtnotransaksi.setText("TR0001");
            }
            
        }catch(Exception e){
            System.out.println("auto number error");
            
        }
    }
    
    public void tambahtransaksi(){
        int jumlah, harga, total;
        
        jumlah = Integer.valueOf(txtjumlah.getText());
        harga = Integer.valueOf((txthargabarang.getText()));
        total = jumlah * harga;
        
        txttotal.setText((String.valueOf(total)));
        
        loadData();
        
    }
    
    public Kasir() {
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
        jTable1.getTableHeader().setFont(new Font("Fredoka One", Font.CENTER_BASELINE, 16));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(241,175,9));
        jTable1.getTableHeader().setForeground(new Color(0, 0, 0));
        jTable1.setRowHeight(25);
       
      
//        txt_namaKasir.setText(Session.get_username());
//        txt_namaKasir.setEchoChar('*');
        
        model = new DefaultTableModel();
        
        jTable1.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga Barang");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        
        txttanggal.setText(s.format(date));
        txtgrandtotal.setText("0");
        txtbayar.setText("");
        txtkembali.setText("0");
        txtkodebarang.requestFocus();
        
        utama();
        jam();
        autonumber();
        pendapatan();
    }
    
    Timer t;
    SimpleDateFormat st;
    public void jam(){
            t = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            Date dt = new Date();
            st = new SimpleDateFormat("hh:mm:ss");
            String waktu = st.format(dt);
            txt_waktu.setText(waktu);
            }
            
        }
        );
        t.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new Button.MyButton();
        myButton4 = new Button.MyButton();
        myButton3 = new Button.MyButton();
        myButton2 = new Button.MyButton();
        txtkembali = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtgrandtotal = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        txthargabarang = new javax.swing.JTextField();
        txtnamabarang = new javax.swing.JTextField();
        txtkodebarang = new javax.swing.JTextField();
        txtnotransaksi = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_waktu = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1571, 965));
        setPreferredSize(new java.awt.Dimension(1571, 965));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton1.setText("Hapus");
        myButton1.setBorderColor(new java.awt.Color(255, 30, 30));
        myButton1.setColor(new java.awt.Color(255, 30, 30));
        myButton1.setColorClick(new java.awt.Color(255, 10, 11));
        myButton1.setColorOver(new java.awt.Color(255, 33, 0));
        myButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton1.setRadius(20);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 400, 175, 70));

        myButton4.setText("Tambah");
        myButton4.setBorderColor(new java.awt.Color(0, 215, 255));
        myButton4.setColor(new java.awt.Color(0, 215, 255));
        myButton4.setColorClick(new java.awt.Color(0, 201, 235));
        myButton4.setColorOver(new java.awt.Color(0, 158, 195));
        myButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton4.setRadius(20);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 400, 175, 70));

        myButton3.setForeground(new java.awt.Color(245, 245, 245));
        myButton3.setText("Cetak");
        myButton3.setBorderColor(new java.awt.Color(13, 23, 49));
        myButton3.setColor(new java.awt.Color(13, 23, 49));
        myButton3.setColorClick(new java.awt.Color(13, 46, 69));
        myButton3.setColorOver(new java.awt.Color(204, 204, 204));
        myButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton3.setRadius(20);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 810, 180, 70));

        myButton2.setText("Bayar");
        myButton2.setBorderColor(new java.awt.Color(179, 250, 160));
        myButton2.setColor(new java.awt.Color(179, 250, 160));
        myButton2.setColorClick(new java.awt.Color(179, 250, 160));
        myButton2.setColorOver(new java.awt.Color(152, 184, 144));
        myButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton2.setRadius(20);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 810, 175, 70));

        txtkembali.setBackground(new java.awt.Color(237, 231, 228));
        txtkembali.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtkembali.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        add(txtkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 690, 210, 70));

        txtbayar.setBackground(new java.awt.Color(237, 231, 228));
        txtbayar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtbayar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 600, 210, 70));

        txtgrandtotal.setBackground(new java.awt.Color(237, 231, 228));
        txtgrandtotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtgrandtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        add(txtgrandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 510, 210, 70));

        txttotal.setBackground(new java.awt.Color(237, 231, 228));
        txttotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 300, 290, 70));

        txtjumlah.setBackground(new java.awt.Color(237, 231, 228));
        txtjumlah.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtjumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        add(txtjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 210, 280, 70));

        txtstok.setBackground(new java.awt.Color(237, 231, 228));
        txtstok.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtstok.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        txtstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstokActionPerformed(evt);
            }
        });
        add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 120, 280, 70));

        txthargabarang.setBackground(new java.awt.Color(237, 231, 228));
        txthargabarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txthargabarang.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        add(txthargabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 300, 280, 70));

        txtnamabarang.setBackground(new java.awt.Color(237, 231, 228));
        txtnamabarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnamabarang.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });
        add(txtnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 280, 70));

        txtkodebarang.setBackground(new java.awt.Color(237, 231, 228));
        txtkodebarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtkodebarang.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        txtkodebarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtkodebarangMouseEntered(evt);
            }
        });
        txtkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodebarangActionPerformed(evt);
            }
        });
        add(txtkodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 280, 70));

        txtnotransaksi.setBackground(new java.awt.Color(237, 231, 228));
        txtnotransaksi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtnotransaksi.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        txtnotransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnotransaksiActionPerformed(evt);
            }
        });
        add(txtnotransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 340, 70));

        txt_namaKasirA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_namaKasirA.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        add(txt_namaKasirA, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 340, 70));

        txttanggal.setBackground(new java.awt.Color(237, 231, 228));
        txttanggal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txttanggal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 340, 70));

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

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 1040, 470));

    jPanel1.setBackground(new java.awt.Color(237, 231, 228));
    add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 30, 100, 80));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/Kasirr.png"))); // NOI18N
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    txt_waktu.setBackground(new java.awt.Color(237, 231, 228));
    txt_waktu.setForeground(new java.awt.Color(237, 231, 228));
    txt_waktu.setBorder(null);
    add(txt_waktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 120, -1));

    txtnikA.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtnikAActionPerformed(evt);
        }
    });
    add(txtnikA, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 340, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtnotransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnotransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnotransaksiActionPerformed

    private void txtnikAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnikAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnikAActionPerformed

    private void txtkodebarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtkodebarangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodebarangMouseEntered

    private void txtkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodebarangActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "select * from barang where id_barang = '"+txtkodebarang.getText()+"'";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while(rs.next()){
                txtnamabarang.setText(rs.getString("nama_barang"));
                txthargabarang.setText(rs.getString("harga_jual"));
                txtstok.setText(rs.getString("stok"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        txtjumlah.requestFocus();
    }//GEN-LAST:event_txtkodebarangActionPerformed

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "select * from barang where nama_barang = '"+txtnamabarang.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while(rs.next()){
                txthargabarang.setText(rs.getString("harga_jual"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        txtjumlah.requestFocus();
    }//GEN-LAST:event_txtnamabarangActionPerformed

    private void txtstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstokActionPerformed

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        // TODO add your handling code here:
        int jumlah, harga, total;

        jumlah = Integer.valueOf(txtjumlah.getText());
        harga = Integer.valueOf((txthargabarang.getText()));
        total = jumlah * harga;

        txttotal.setText((String.valueOf(total)));
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
        int total, bayar, kembalian;

        total = Integer.valueOf(txtgrandtotal.getText());
        bayar = Integer.valueOf(txtbayar.getText());

        if (total > bayar){
            JOptionPane.showMessageDialog(null, "Uang Tidak Cukup Untuk Melakukan Pembayaran");
        }else{
            kembalian = bayar - total;
            txtkembali.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txtbayarActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        /*String id_transaksi =  txtnotransaksi.getText();
        String  tanggal = txttanggal.getText();
        String grand_total = txtgrandtotal.getText();
        String bayar = txtbayar.getText();
        String kembali = txtkembali.getText();
               String Kasir = txt_namaKasir.getText();
        String nik = txtnikA.getText();
        String waktu = txt_waktu.getText();*/

        try{
            String sql = "insert into transaksi (id_transaksi, tanggal, waktu, grand_total, bayar, kembali, nik) values "+"('"+txtnotransaksi.getText()+"',now(),'"
                    +txt_waktu.getText()+"','"+txtgrandtotal.getText()+"','"+txtbayar.getText()+"','"+txtkembali.getText()+"','"+txtnikA.getText()+"')";
            //String sql = "insert into transaksi values (?,?,?,?,?,?,?)";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            /*pst.setString(1, id_transaksi);
            pst.setString(2, tanggal);
            pst.setString(3, waktu);
            pst.setString(4, grand_total);
            pst.setString(5, bayar);
            pst.setString(6, kembali);
            pst.setString(7, nik);*/
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
                String sql = "insert into detail_transaksi (id_transaksi, id_barang, jumlah, total_harga) values ('" + jTable1.getValueAt(i, 0) + "','"
                + jTable1.getValueAt(i, 1) + "','" + jTable1.getValueAt(i, 4) + "','" + jTable1.getValueAt(i, 5) + "')";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                pst.close();

                //JOptionPane.showMessageDialog(null, "Berhasil");
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal" + e.getMessage());
        }
        clear();
        pendapatan();
        tampilkanTabel();
        tampilkanTabel1();
        //utama();
        //autonumber();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        try{
            Connection c =koneksi.configDB();
            Statement s =c.createStatement();
            String report ="C:\\Users\\asus\\OneDrive\\Documents\\NetBeansProjects\\Raja\\src\\panel\\report1.jrxml";
            HashMap hash = new HashMap();

            hash.put("no", txtnotransaksi.getText());
            JasperReport JRpt = JasperCompileManager.compileReport(report);
            JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, c);
            JasperViewer.viewReport(JPrint, false);
        }catch(Exception rptexcpt){
            JOptionPane.showMessageDialog(null, "Gagal"+rptexcpt);

        }
        clear();
        autonumber();
        utama();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        tambahtransaksi();
        grandtotal();
        //utama();
        clear();
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        grandtotal();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
      
    }//GEN-LAST:event_jTable1MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable jTable1 = new javax.swing.JTable();
    private Button.MyButton myButton1;
    private Button.MyButton myButton2;
    private Button.MyButton myButton3;
    private Button.MyButton myButton4;
    public static final javax.swing.JLabel txt_namaKasirA = new javax.swing.JLabel();
    private javax.swing.JTextField txt_waktu;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtgrandtotal;
    private javax.swing.JTextField txthargabarang;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtkodebarang;
    private javax.swing.JTextField txtnamabarang;
    public static final javax.swing.JTextField txtnikA = new javax.swing.JTextField();
    private javax.swing.JTextField txtnotransaksi;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
