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

public class RepairListController implements Initializable {

    private DBconnector con;

    @FXML
    private TableView<Repair> myTableView;
    @FXML
    private TableColumn<Repair, Integer> Nr_awarii;
    @FXML
    private TableColumn<Repair, Integer> Nr_samochodu;
    @FXML
    private TableColumn<Repair,String> Krotki_Opis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nr_awarii.setCellValueFactory(new PropertyValueFactory<Repair, Integer>("Nr_awarii"));
        Nr_samochodu.setCellValueFactory(new PropertyValueFactory<Repair, Integer>("Nr_samochodu"));
        Krotki_Opis.setCellValueFactory(new PropertyValueFactory<Repair, String>("Krotki_Opis"));
        
        try {
            myTableView.getItems().setAll(getRepair());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ObservableList<Repair> getRepair() throws SQLException {

        ObservableList<Repair> repair = FXCollections.observableArrayList();
        con = new DBconnector();
        ResultSet r = con.populateTableRepair();
        while (r.next()) {
            repair.add(new Repair(r.getInt("Nr_awarii"), r.getInt("Nr_samochodu"), r.getString("Krotki_Opis")));

        }
        return repair;
    }

}
