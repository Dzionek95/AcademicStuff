package rentcar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    ObservableList<String> view = FXCollections.observableArrayList("Samochody", 
            "Klienci", "Warsztat", "Zwroty", "Wypożyczenia");

    @FXML
    ComboBox comboView;

    @FXML
    Button button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboView.setValue("Samochody");
        comboView.setItems(view);
    }

    public void createWindow(String title, String fxmlFile){
    
        try {
            Stage window = new Stage();
            window.setTitle(title);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = (Parent) loader.load();
            window.setScene(new Scene(root));
            window.show();

        } catch (IOException ex) {
            ex.printStackTrace() ;
            System.err.println(ex.getMessage()+ " ");
        }
        
    }
    
    @FXML
    public void handleFirstButton() {
     createWindow("Wypozycz/zwroc", "RenReturnCar.fxml");
    }

    @FXML
    public void handleSecondButton() {
        createWindow("Dodaj/Usuń", "AddDelete.fxml");
    }

    @FXML
    public void handleThirdButton() {
       createWindow("Warsztat", "CarRepair.fxml");
    }

    @FXML
    public void handleFourthButton() {
        String source = comboView.getValue().toString();
        String fxmlFile="";
        String title="";
        if(source.equals("Samochody")){ fxmlFile="Cars.fxml"; title="Samochody";}
        else if(source.equals("Klienci")){ fxmlFile="Clientss.fxml"; title="Klienci";}
        else if(source.equals("Warsztat")){ fxmlFile="RepairList.fxml"; title="Warsztat";}
        else if(source.equals("Zwroty")){ fxmlFile="ReturnList.fxml"; title="Zwroty";}
        else {fxmlFile="RentList.fxml"; title="Wypozyczenia";}
              
            createWindow(title, fxmlFile);
            
    }

}
