package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    //connection variable
    Connection conn;

    public static Connection connect()
    {
        try
        {

            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:company.db");

        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
               System.out.println(e);
        }
    }
}
