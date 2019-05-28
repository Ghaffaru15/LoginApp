package login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            LoginModel login = new LoginModel();
//            if (login.isConnected())
//                status.setText("Connected");
//            else
//                status.setText("Not connected");

            status.setText(login.getName());

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}

