package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    //connection variable
    //Connection conn;

    public static Connection connect()
    {
        try
        {

            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:company.sqlite");

            return conn;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e)
        {
               System.out.println(e);
               return null;
        }

    }
}
