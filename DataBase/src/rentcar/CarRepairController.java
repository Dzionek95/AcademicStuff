package rentcar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CarRepairController implements Initializable {

    private DBconnector con;

    @FXML
    TextField carNumber;
    @FXML
    TextField carNumber2;
    @FXML
    TextArea problem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void addRepair() {
        con = new DBconnector();
        try {
            con.insertToRepairTable(Integer.valueOf(carNumber.getText()), problem.getText());
        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        carNumber.clear();
        problem.clear();
    }
    
    public void getFromRepair(){
        try {
            con=new DBconnector();
            con.deleteFromRepairTable(Integer.valueOf(carNumber2.getText()));
        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        carNumber2.clear();
    }

}
