package login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        status.setText(new LoginModel());
    }
}

