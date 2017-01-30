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

public class RentListController implements Initializable {

    private DBconnector con;

    @FXML
    private TableView<Rent> myTableView;
    @FXML
    private TableColumn<Rent, Integer> Nr_wypozyczenia;
    @FXML
    private TableColumn<Rent, Integer> Nr_samochodu;
    @FXML
    private TableColumn<Rent, String> Data_wypozyczenia;
    @FXML
    private TableColumn<Rent, Integer> Nr_pracownika;
    @FXML
    private TableColumn<Rent,Integer> Nr_klienta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Nr_wypozyczenia.setCellValueFactory(new PropertyValueFactory<Rent, Integer>("Nr_wypozyczenia"));
            Nr_samochodu.setCellValueFactory(new PropertyValueFactory<Rent, Integer>("Nr_samochodu"));
            Data_wypozyczenia.setCellValueFactory(new PropertyValueFactory<Rent, String>("Data_wypozyczenia"));
            Nr_pracownika.setCellValueFactory(new PropertyValueFactory<Rent, Integer>("Nr_pracownika"));
            Nr_klienta.setCellValueFactory(new PropertyValueFactory<Rent, Integer>("Nr_klienta"));
            
            myTableView.getItems().setAll(getRent());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ObservableList<Rent> getRent() throws SQLException {

        ObservableList<Rent> rent = FXCollections.observableArrayList();
        con = new DBconnector();
        ResultSet r = con.populateTableRent();
        while (r.next()) {
            rent.add(new Rent(r.getInt("Nr_wypozyczenia"), r.getInt("Nr_pracownika"), r.getString("Data_wypozyczenia"), r.getInt("Nr_samochodu"), r.getInt("Nr_klienta")));

        }
        return rent;
    }

}
