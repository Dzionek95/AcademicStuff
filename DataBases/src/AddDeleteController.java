package rentcar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddDeleteController implements Initializable {

    private DBconnector con;

    @FXML
    TextField brand;
    @FXML
    TextField type;
    @FXML
    TextField productionYear;
    @FXML
    TextField engineCapacity;
    @FXML
    TextField carNumber;
    @FXML
    TextField engineType;
    @FXML
    TextField bail;
    @FXML
    TextField dayPrice;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void add() {
        con = new DBconnector();
        try {
            con.insertIntoAddCarTable(brand.getText(), type.getText(), productionYear.getText(), engineType.getText(), Double.valueOf(engineCapacity.getText()), Double.valueOf(bail.getText()), Double.valueOf(dayPrice.getText()));
        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        brand.clear();
        type.clear();
        productionYear.clear();
        engineType.clear();
        engineCapacity.clear();
        bail.clear();
        dayPrice.clear();
    }

    public void delete() {
        try {
            con = new DBconnector();
            con.deleteFromCarTable(Integer.valueOf(carNumber.getText()));

        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        carNumber.clear();
    }

}
