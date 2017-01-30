package rentcar;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ClientsController implements Initializable {

    private DBconnector con;
    
    @FXML
    private TableView<Client> myTableView;
    @FXML
    private TableColumn<Client, Integer> Nr_klienta;
    @FXML
    private TableColumn<Client, String> Imie;
    @FXML
    private TableColumn<Client, String> Nazwisko;
    @FXML
    private TableColumn<Client, String> Ulica;
    @FXML
    private TableColumn<Client, String> Numer;
    @FXML
    private TableColumn<Client, String> Miasto;
    @FXML
    private TableColumn<Client, Integer> PESEL;
    @FXML
    private TableColumn<Client, String> Nr_dowodu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Nr_klienta.setCellValueFactory(new PropertyValueFactory<Client, Integer>("Nr_klienta"));
        Imie.setCellValueFactory(new PropertyValueFactory<Client, String>("Imie"));
        Nazwisko.setCellValueFactory(new PropertyValueFactory<Client, String>("Nazwisko"));
        Ulica.setCellValueFactory(new PropertyValueFactory<Client, String>("Ulica"));
        Numer.setCellValueFactory(new PropertyValueFactory<Client, String>("Numer"));
        Miasto.setCellValueFactory(new PropertyValueFactory<Client, String>("Miasto"));
        PESEL.setCellValueFactory(new PropertyValueFactory<Client, Integer>("PESEL"));
        Nr_dowodu.setCellValueFactory(new PropertyValueFactory<Client,String>("Nr_dowodu"));
        
        try {
            myTableView.getItems().setAll(getClients());
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       
    }    
    
     public ObservableList<Client> getClients() throws SQLException {

        ObservableList<Client> client = FXCollections.observableArrayList();
        con = new DBconnector();
        ResultSet r = con.populateTableViewClients();
        while (r.next()) {
            client.add(new Client(r.getInt("Nr_klienta"),r.getString("Imie"), r.getString("Nazwisko"), r.getString("Ulica"), r.getString("Numer"), r.getString("Miasto"), r.getInt("PESEL"), r.getString("Nr_dowodu")));
            
        }
        return client;
    }
    
}
