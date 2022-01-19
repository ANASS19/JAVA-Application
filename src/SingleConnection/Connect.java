package SingleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private static Connection con;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb","hr","hr");
        }
        catch (ClassNotFoundException e){
            System.out.println("Problem au niveau de pilot");
        }
        catch (SQLException e){
            System.out.println("Problem au niveau de base ou acces au donnes");
        }

    }
    public static Connection getCon(){
        return  con;
    }
}
