package login;

import java.sql.Connection;

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

    public void isConnected()
    {

    }
}
