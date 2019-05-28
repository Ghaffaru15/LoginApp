package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable
{
    @FXML private Label status;
    @FXML private TextField username;
    @FXML private TextField password;

    LoginModel login = new LoginModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

//            if (login.isConnected())
//                status.setText("Connected");
//            else
//                status.setText("Not connected");

            status.setText(login.getName());

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void login(ActionEvent event) throws SQLException, IOException
    {
        if (login.authenticate(username.getText(),password.getText()))
        {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            ( (Node)event.getSource()).getScene().getWindow().hide();
            Pane root = loader.load(getClass().getResource("dashboard.fxml").openStream());
            DashboardController dashboardController = (DashboardController)loader.getController();
            dashboardController.getUser(username.getText());
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 600, 275));
            primaryStage.show();
        }else
        {
            status.setText("Incorrect password");
        }
    }

}

