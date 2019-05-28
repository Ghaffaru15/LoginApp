package login;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel
{
    Connection conn;

    public LoginModel()
    {
       conn =  Database.connect();

       if (conn == null) {
           System.exit(1);
       }
    }

    public boolean isConnected() throws SQLException
    {
        if (conn.isClosed())
            return true;
        else
            return false;
    }

    public String getName() throws SQLException
    {
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        preparedStatement = conn.prepareStatement("SELECT name FROM employee WHERE username = ?");

        preparedStatement.setString(1,"ghaffar15");

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
            return resultSet.getString("name");
        else
            return "no";

    }

    public boolean authenticate(String username, String password) throws SQLException
    {
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        preparedStatement = conn.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?");

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
        {
            return true;
        }else
        {
            return false;
        }
    }
}
