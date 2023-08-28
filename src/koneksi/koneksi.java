package koneksi;
import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;


    
public class koneksi {
    private static Connection mysqlconfig; //nm koneksiny mysqlconfig
    public static Connection configDB() throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/rajapakan1";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);
        }catch (Exception e){
            System.err.println("Koneksi Gagal" +e.getMessage());
        }
        return mysqlconfig;
    }

    public Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
