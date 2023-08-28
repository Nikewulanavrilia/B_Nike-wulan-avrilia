/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import Admin.Dashboard;
import static panel.Brg_edt.txt_kodebarang;
import static panel.Brg_edt.txt_namabarang;
import static panel.Brg_edt.txt_hargabeli;
import static panel.Brg_edt.txt_keuntungan;
import static panel.Brg_edt.txt_stok;
import com.barcodelib.barcode.Linear;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import koneksi.Session;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static panel.Barang.tabeldashboard;
import static panel.Brg_edt.txt_hargajual;


/**
 *
 * @author asus
 */
public class dashboard extends javax.swing.JPanel {
  
    JasperReport JasRep;
JasperPrint JasPri;
Map param = new HashMap();
JasperDesign JasDes;
    public static brg_tmbh bt;
    public static Brg_edt be;
    

    /**
     * Creates new form dashboard
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
    
    public dashboard() {
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
        tabelbarang.getTableHeader().setFont(new Font("Fredoka One", Font.CENTER_BASELINE, 16));
        tabelbarang.getTableHeader().setOpaque(false);
        tabelbarang.getTableHeader().setBackground(new Color(241,175,9));
        tabelbarang.getTableHeader().setForeground(new Color(0, 0, 0));
        tabelbarang.setRowHeight(25);
        
        txtusernamee1.setText(Session.get_username());
        btnedit.setVisible(false);
        btnhapus.setVisible(false);
        tampilkanTabel();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnedit = new Button.MyButton();
        myButton4 = new Button.MyButton();
        btnhapus = new Button.MyButton();
        txtusernamee1 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(1571, 965));
        setMinimumSize(new java.awt.Dimension(1571, 965));
        setPreferredSize(new java.awt.Dimension(1571, 965));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnedit.setBackground(new java.awt.Color(255, 228, 0));
        btnedit.setText("Edit");
        btnedit.setBorderColor(new java.awt.Color(255, 228, 0));
        btnedit.setColor(new java.awt.Color(255, 228, 0));
        btnedit.setColorClick(new java.awt.Color(255, 228, 0));
        btnedit.setColorOver(new java.awt.Color(255, 196, 0));
        btnedit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, 80));

        myButton4.setBackground(new java.awt.Color(13, 23, 49));
        myButton4.setForeground(new java.awt.Color(204, 204, 204));
        myButton4.setText("Cetak");
        myButton4.setBorderColor(new java.awt.Color(13, 23, 49));
        myButton4.setColor(new java.awt.Color(13, 23, 49));
        myButton4.setColorClick(new java.awt.Color(13, 23, 49));
        myButton4.setColorOver(new java.awt.Color(13, 23, 29));
        myButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 160, 110, 80));

        btnhapus.setBackground(new java.awt.Color(255, 30, 30));
        btnhapus.setText("Hapus");
        btnhapus.setBorderColor(new java.awt.Color(255, 30, 30));
        btnhapus.setColor(new java.awt.Color(255, 30, 30));
        btnhapus.setColorClick(new java.awt.Color(255, 10, 11));
        btnhapus.setColorOver(new java.awt.Color(255, 33, 0));
        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 110, 80));

        txtusernamee1.setFont(new java.awt.Font("YouYuan", 1, 18)); // NOI18N
        txtusernamee1.setText("jLabel2");
        add(txtusernamee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 60, 150, 30));

        txtidbarang.setBackground(new java.awt.Color(28, 24, 18));
        txtidbarang.setForeground(new java.awt.Color(28, 24, 18));
        txtidbarang.setBorder(null);
        txtidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidbarangActionPerformed(evt);
            }
        });
        add(txtidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 270, 110, 30));

        tabelbarang = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabelbarang.setBackground(new java.awt.Color(173, 172, 172));
        tabelbarang.setModel(new javax.swing.table.DefaultTableModel(
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
    tabelbarang.setFocusable(false);
    tabelbarang.setGridColor(new java.awt.Color(0, 0, 0));
    tabelbarang.setIntercellSpacing(new java.awt.Dimension(0, 0));
    tabelbarang.setRowHeight(25);
    tabelbarang.setSelectionBackground(new java.awt.Color(241, 175, 9));
    tabelbarang.getTableHeader().setResizingAllowed(false);
    tabelbarang.getTableHeader().setReorderingAllowed(false);
    tabelbarang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelbarangMouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            tabelbarangMouseEntered(evt);
        }
    });
    jScrollPane1.setViewportView(tabelbarang);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 1440, 590));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/Barang (13)_1.png"))); // NOI18N
    add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 960));
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Dashboard.be.setVisible(true);
        
        int i = tabelbarang.getSelectedRow();
        TableModel model = tabelbarang.getModel();
        String kode = model.getValueAt(i, 0).toString();
        String nama = model.getValueAt(i, 1).toString();
        String hargabeli = model.getValueAt(i, 2).toString();
        String keuntungan = model.getValueAt(i, 5).toString();
        String hargajual = model.getValueAt(i, 3).toString();
        String stok = model.getValueAt(i, 4).toString();
        
        txtidbarang.setText(kode);
        
        txt_kodebarang.setText(kode);
        txt_namabarang.setText(nama);
        txt_hargabeli.setText(hargabeli);
        txt_stok.setText(stok);
        txt_keuntungan.setText(keuntungan);
        txt_hargajual.setText(hargajual);
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE from barang where id_barang='"+txtidbarang.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkanTabel();
        tampilkanTabel1();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        String sql =" select * from barang where id_barang='"+txtidbarang.getText()+"'";
        try{
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            //st.setString(1, txt_kodebarang.getText());
            //st.setString(2, txt_namabarang.getText());
            pst.execute();
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128A);
            barcode.setData(txtidbarang.getText());
            barcode.setI(11.0f);
            String fname= txtidbarang.getText();
            barcode.renderBarcode("src/images_barcode/" + fname + ".png");

            File file = new File("src\\report\\cetakbarcode.jrxml");
            JasDes =JRXmlLoader.load(file);
            param.put("id_barang", txtidbarang.getText());
            param.put("realPath", "src/images_barcode/"+txtidbarang.getText()+".png");
            JasRep = JasperCompileManager.compileReport(JasDes);
            JasPri = JasperFillManager.fillReport(JasRep, param, conn);
            JasperViewer jasperviewer = new JasperViewer(JasPri,false);
            jasperviewer.setExtendedState(jasperviewer.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
            jasperviewer.setVisible(true);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mencetak barcode"+ e);
        }
    }//GEN-LAST:event_myButton4ActionPerformed

    private void txtidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidbarangActionPerformed

    private void tabelbarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tabelbarangMouseEntered

    private void tabelbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbarangMouseClicked
        // TODO add your handling code here:
         btnedit.setVisible(true);
        btnhapus.setVisible(true);
        int i = tabelbarang.getSelectedRow();
        TableModel model = tabelbarang.getModel();
        String kode = model.getValueAt(i, 0).toString();
        String nama = model.getValueAt(i, 1).toString();
        String hargabeli = model.getValueAt(i, 2).toString();
        String keuntungan = model.getValueAt(i, 5).toString();
        String hargajual = model.getValueAt(i, 3).toString();
        String stok = model.getValueAt(i, 4).toString();

        txtidbarang.setText(kode);

        txt_kodebarang.setText(kode);
        txt_namabarang.setText(nama);
        txt_hargabeli.setText(hargabeli);
        txt_stok.setText(stok);
        txt_keuntungan.setText(keuntungan);
        txt_hargajual.setText(hargajual);
    }//GEN-LAST:event_tabelbarangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static Button.MyButton btnedit;
    public static Button.MyButton btnhapus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private Button.MyButton myButton4;
    public static javax.swing.JTable tabelbarang;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JLabel txtusernamee1;
    // End of variables declaration//GEN-END:variables
}
