/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentcar;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RenReturnCarController implements Initializable {

    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField street;
    @FXML
    TextField houseNumber;
    @FXML
    TextField city;
    @FXML
    TextField peselNumber;
    @FXML
    TextField idNumber;
    @FXML
    TextField carNumber;
    @FXML
    TextField rentDate;
    @FXML
    TextField workerNumber;
    @FXML
    TextField carNumber2;
    @FXML
    TextField returnDate;
    @FXML
    TextField workerNumber2;

    private DBconnector con;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void insertingByButton() {
        try {
            con = new DBconnector();
            con.insertIntoRentTable(name.getText(), surname.getText(), street.getText(), houseNumber.getText(), city.getText(), peselNumber.getText(), idNumber.getText(), carNumber.getText(), rentDate.getText(), workerNumber.getText());

        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        name.clear();
        surname.clear();
        carNumber.clear();
        street.clear();
        idNumber.clear();
        workerNumber.clear();
        peselNumber.clear();
        rentDate.clear();
        houseNumber.clear();
        idNumber.clear();
        city.clear();
    }

    public void returningByButton() {
        try {
            con = new DBconnector();
            con.insertIntoReturnTable(carNumber2.getText(), workerNumber2.getText(), returnDate.getText());

        } catch (SQLException ex) {
            System.err.println("Something went wrong: " + ex.getMessage());
        }
        carNumber2.clear();
        workerNumber2.clear();
        returnDate.clear();
    }

}
