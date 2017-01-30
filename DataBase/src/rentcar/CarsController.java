package rentcar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class CarsController implements Initializable {

    @FXML
    private TableView<Car> myTableView;

    @FXML
    private TableColumn<Car, String> Marka;
    @FXML
    private TableColumn<Car, String> Typ;
    @FXML
    private TableColumn<Car, String> Rok_produkcji;
    @FXML
    private TableColumn<Car, Double> Pojemnosc_silnika;
    @FXML
    private TableColumn<Car, String> Rodzaj_silnika;
    @FXML
    private TableColumn<Car, Double> Kaucja;
    @FXML
    private TableColumn<Car, Double> Cena_dzien;
    @FXML
    private TableColumn<Car, Integer> dostepny;
    @FXML
    private TableColumn<Car, Integer> Nr_samochodu;

    private DBconnector con;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Marka.setCellValueFactory(new PropertyValueFactory<Car, String>("Marka"));
        Typ.setCellValueFactory(new PropertyValueFactory<Car, String>("Typ"));
        Rok_produkcji.setCellValueFactory(new PropertyValueFactory<Car, String>("Rok_produkcji"));
        Pojemnosc_silnika.setCellValueFactory(new PropertyValueFactory<Car, Double>("Pojemnosc_silnika"));
        Rodzaj_silnika.setCellValueFactory(new PropertyValueFactory<Car, String>("Rodzaj_silnika"));
        Kaucja.setCellValueFactory(new PropertyValueFactory<Car, Double>("Kaucja"));
        Cena_dzien.setCellValueFactory(new PropertyValueFactory<Car, Double>("Cena_dzien"));
        dostepny.setCellValueFactory(new PropertyValueFactory<Car, Integer>("dostepny"));
        Nr_samochodu.setCellValueFactory(new PropertyValueFactory<Car, Integer>("Nr_samochodu"));

        try {
            myTableView.getItems().setAll(getCars());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ObservableList<Car> getCars() throws SQLException {

        ObservableList<Car> cars = FXCollections.observableArrayList();
        con = new DBconnector();
        ResultSet r = con.populateTableViewCars();
        while (r.next()) {
            cars.add(new Car(r.getInt("Nr_samochodu"),r.getString("Marka"), r.getString("Typ"), r.getString("Rok_produkcji"), r.getDouble("Pojemnosc_silnika"), r.getString("Rodzaj_silnika"), r.getDouble("Kaucja"), r.getDouble("Cena_dzien"), r.getInt("dostepny")));
            
        }
        return cars;
    }

}
