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

public class ReturnListController implements Initializable {
    
    private DBconnector con;
    
    @FXML
    private TableView<Return> myTableView;
    @FXML
    private TableColumn<Return, Integer> Nr_zwrotu;
    @FXML
    private TableColumn<Return, Integer> Nr_pracownika;
    @FXML
    private TableColumn<Return, String> Data_zwrotu;
    @FXML
    private TableColumn<Return, Integer> Nr_samochodu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Nr_zwrotu.setCellValueFactory(new PropertyValueFactory<Return, Integer>("Nr_zwrotu"));
        Nr_pracownika.setCellValueFactory(new PropertyValueFactory<Return, Integer>("Nr_pracownika"));
        Data_zwrotu.setCellValueFactory(new PropertyValueFactory<Return, String>("Data_zwrotu"));
        Nr_samochodu.setCellValueFactory(new PropertyValueFactory<Return, Integer>("Nr_samochodu"));
        
        try {
            myTableView.getItems().setAll(getReturns());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public ObservableList<Return> getReturns() throws SQLException {
        
        ObservableList<Return> ret = FXCollections.observableArrayList();
        con = new DBconnector();
        ResultSet r = con.populateTableReturns();
        while (r.next()) {
            ret.add(new Return(r.getInt("Nr_zwrotu"), r.getInt("Nr_pracownika"), r.getString("Data_zwrotu"), r.getInt("Nr_samochodu")));
            
        }
        return ret;
    }
    
}
