//This is just a comment
import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/userProjDB?verifyServerCertificate=false&useSSL=true", "root", "12345678");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }
}
