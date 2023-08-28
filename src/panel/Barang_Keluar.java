/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import koneksi.Session;
import koneksi.koneksi;

/**
 *
 * @author asus
 */
public class Barang_Keluar extends javax.swing.JPanel {

    /**
     * Creates new form Barang_Keluar
     */
    public void showdata(){
        DefaultTableModel model = new DefaultTableModel();
        
        tablebarangkeluar.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("Tanggal");
        model.addColumn("Kasir");
        model.addColumn("Nama Barang");
        model.addColumn("Keuntungan");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        
        
       try {
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("SELECT transaksi.id_transaksi,transaksi.tanggal, user.nama_lengkap, barang.nama_barang, "
                    + "barang.keuntungan, detail_transaksi.jumlah, "
                    + "detail_transaksi.total_harga "
                + "FROM user JOIN transaksi ON transaksi.nik = user.nik "
                + "JOIN detail_transaksi ON transaksi.id_transaksi = detail_transaksi.id_transaksi "
                + "JOIN barang ON barang.id_barang = detail_transaksi.id_barang order by transaksi.id_transaksi");
            
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getString("id_transaksi"),
                    rs.getString("tanggal"),
                    rs.getString("nama_lengkap"),
                    rs.getString("nama_barang"),
                    rs.getString("keuntungan"),
                    rs.getString("jumlah"),
                    rs.getString("total_harga"),
                    
                });
                tablebarangkeluar.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    
    public void tanggal(){
        String getDate = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(getDate);
        String tanggal = String.valueOf(fm.format(jDate2.getDate()));
        
        DefaultTableModel model = new DefaultTableModel();
        
        tablebarangkeluar.setModel(model);
        
        model.addColumn("No Transaksi");
        model.addColumn("Tanggal");
        model.addColumn("Kasir");
        model.addColumn("Nama Barang");
        model.addColumn("Keuntungan");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        
        
       try {
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("SELECT transaksi.id_transaksi,transaksi.tanggal, user.nama_lengkap, barang.nama_barang, "
                    + "barang.keuntungan, detail_transaksi.jumlah, "
                    + "detail_transaksi.total_harga "
                + "FROM user JOIN transaksi ON transaksi.nik = user.nik "
                + "JOIN detail_transaksi ON transaksi.id_transaksi = detail_transaksi.id_transaksi "
                + "JOIN barang ON barang.id_barang = detail_transaksi.id_barang where transaksi.tanggal = '"+tanggal+"'");
            
            while(rs.next())
            {
                model.addRow(new Object[] {
                    rs.getString("id_transaksi"),
                    rs.getString("tanggal"),
                    rs.getString("nama_lengkap"),
                    rs.getString("nama_barang"),
                    rs.getString("keuntungan"),
                    rs.getString("jumlah"),
                    rs.getString("total_harga"),
                    
                });
                tablebarangkeluar.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal"+e.getMessage());
        }
    }
    
    public void keuntungan(){
        int jumlahBaris = tablebarangkeluar.getRowCount();
        int untung = 0;
        int keuntungan;
        int jumlah;
        for (int i = 0; i<jumlahBaris; i++){
        keuntungan = Integer.parseInt(tablebarangkeluar.getValueAt(i, 4).toString());
        jumlah = Integer.parseInt(tablebarangkeluar.getValueAt(i, 5).toString());
        untung = untung + (keuntungan * jumlah);
    }
        txtuntung.setText(String.valueOf(untung));
    }
    
    public Barang_Keluar() {
        try{
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if ("".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception ex){
            
        }
        initComponents();
        tablebarangkeluar.getTableHeader().setFont(new Font("Fredoka One", Font.CENTER_BASELINE, 16));
        tablebarangkeluar.getTableHeader().setOpaque(false);
        tablebarangkeluar.getTableHeader().setBackground(new Color(241,175,9));
        tablebarangkeluar.getTableHeader().setForeground(new Color(0, 0, 0));
        tablebarangkeluar.setRowHeight(25);
        
        txtusernamee1.setText(Session.get_username());
        showdata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusernamee1 = new javax.swing.JLabel();
        jDate2 = new com.toedter.calendar.JDateChooser();
        buttongradient1 = new Button.buttongradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebarangkeluar = new javax.swing.JTable();
        txtuntung = new javax.swing.JLabel();
        txtpendapat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1571, 965));
        setPreferredSize(new java.awt.Dimension(1571, 965));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusernamee1.setFont(new java.awt.Font("YouYuan", 1, 18)); // NOI18N
        txtusernamee1.setText("jLabel2");
        add(txtusernamee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 60, 150, 30));
        add(jDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 370, 60));

        buttongradient1.setText("buttongradient1");
        buttongradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttongradient1ActionPerformed(evt);
            }
        });
        add(buttongradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 70, 70));

        tablebarangkeluar = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablebarangkeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebarangkeluar.getTableHeader().setResizingAllowed(false);
        tablebarangkeluar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablebarangkeluar);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 1440, 600));
        add(txtuntung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 870, 240, 50));
        add(txtpendapat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 880, 270, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/barg keluar.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void buttongradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttongradient1ActionPerformed
        // TODO add your handling code here:
        tanggal();
        keuntungan();
        String getDate = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(getDate);
        String tanggal = String.valueOf(fm.format(jDate2.getDate()));
        try{
            Statement s = koneksi.configDB().createStatement();
            ResultSet rs = s.executeQuery("select sum(grand_total) from transaksi where tanggal = '"+tanggal+"'");
            while(rs.next()){
                txtpendapat.setText(rs.getString("sum(grand_total)"));
            }
        }catch(Exception e){
            System.out.println("gagal"+e.getMessage());
        }
    }//GEN-LAST:event_buttongradient1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Button.buttongradient buttongradient1;
    private com.toedter.calendar.JDateChooser jDate2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablebarangkeluar;
    private javax.swing.JLabel txtpendapat;
    private javax.swing.JLabel txtuntung;
    private javax.swing.JLabel txtusernamee1;
    // End of variables declaration//GEN-END:variables
}
