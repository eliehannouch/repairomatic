import java.sql.*;
import javax.swing.JOptionPane;  // is a class used to display dialog box, ex: message dialog, ...

public class connectDatabase {

    Connection conn = null;  // session between java application and database

    public static Connection ConnectDb() {

        try {
            Class.forName("org.sqlite.JDBC");  // is a statment to make sure  that the class implement the JDBC driver for sqlite is loaded and registered
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\elieh\\OneDrive\\Documents\\NetBeansProjects\\Repair_Managment_System\\Repair_Managment_System.db");
           
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
