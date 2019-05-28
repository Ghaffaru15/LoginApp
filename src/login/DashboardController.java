package login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
    @FXML private Label message;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getUser(String user)
    {
        message.setText(user);
    }

    public void signout(ActionEvent event) throws IOException
    {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        ( (Node)event.getSource()).getScene().getWindow().hide();
        Pane root = loader.load(getClass().getResource("LoginView.fxml").openStream());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
    }
}
