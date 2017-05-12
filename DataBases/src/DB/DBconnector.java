package rentcar;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnector {

    private Connection con;
    private Statement state;
    private ResultSet result;

    DBconnector() {

        try {
            Class.forName("com.mysql.jdbc.Driver");//Set driver
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wypozyczalnia", "root", "");
            state = con.createStatement();
            System.out.println("connected to DB");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    //RenReturnCarController
    public void insertIntoRentTable(String name, String surname, String street, String houseNumber, String city, String peselNumber, String idNumber, String carNumber, String rentDate, String workerNumber) throws SQLException {

        String id = "";
        String sql = "INSERT INTO `klienci`(`Imie`, `Nazwisko`, `Ulica`, `Numer`, `Miasto`, `PESEL`, `Nr_dowodu` ) VALUES (' " + name + " ' , ' " + surname + " ', ' " + street + " ',' " + houseNumber + " ',' " + city + " ',' " + peselNumber + " ',' " + idNumber + " ')";
        state.executeUpdate(sql);
        String sqlQuery = "select * from klienci WHERE Imie = ' " + name + " '";
        String sqlUpdate = "UPDATE `samochody` SET `dostepny` = '0' WHERE `samochody`.`Nr_samochodu` = '" + carNumber + "';";
        state.executeUpdate(sqlUpdate);
        result = state.executeQuery(sqlQuery);
        while (result.next()) {
            id = result.getString("Nr_klienta");
        }
        String sql2 = "INSERT INTO `wypozyczenia` ( `Nr_klienta`, `Nr_pracownika`, `Nr_samochodu`, `Data_wypozyczenia`) VALUES ('" + id + "', '" + workerNumber + "', '" + carNumber + "', '" + rentDate + "')";
        state.executeUpdate(sql2);
        System.out.println("Insert complete");

    }

    public void insertIntoReturnTable(String carNumber2, String workerNumber2, String returnDate) throws SQLException {
        String sqlInsert = "INSERT INTO `zwroty` (`Nr_pracownika`, `Data_zwrotu`, `Nr_samochodu`) VALUES ('" + workerNumber2 + "', '" + returnDate + "', '" + carNumber2 + "')";
        String sqlUpdate = "UPDATE `samochody` SET `dostepny` = '1' WHERE `samochody`.`Nr_samochodu` = '" + carNumber2 + "';";
        state.executeUpdate(sqlUpdate);
        state.executeUpdate(sqlInsert);

    }

    //AddDeleteController
    public void insertIntoAddCarTable(String brand, String type, String productionYear, String engineType, double engineCapacity, double bail, double dayPrice) throws SQLException {

        String sqlInsert = "INSERT INTO `samochody` (`Marka`, `Typ`, `Rok_produkcji`, `Pojemnosc_silnika`, `Rodzaj_silnika`, `Kaucja`, `Cena_dzien`, `dostepny`) VALUES ('" + brand + "', '" + type + "', '" + productionYear + "', '" + engineCapacity + "', '" + engineType + "', '" + bail + "', '" + dayPrice + "', '1')";

        state.executeUpdate(sqlInsert);

    }

    public void deleteFromCarTable(int id) throws SQLException {
        String sqlDelete = "DELETE FROM `samochody` WHERE `samochody`.`Nr_samochodu` = '" + id + "'";
        state.executeUpdate(sqlDelete);    
    }

    //CarRepairController
    public void insertToRepairTable(int id, String problem) throws SQLException {
        String sqlInsert = "INSERT INTO `warsztat` ( `Nr_samochodu`, `Krotki_Opis`) VALUES ('" + id + "', '" + problem + "')";
        state.executeUpdate(sqlInsert);
        String sqlUpdate = "UPDATE `samochody` SET `dostepny` = '0' WHERE `samochody`.`Nr_samochodu` = '" + id + "';";
        state.executeUpdate(sqlUpdate);
    }
    
    public void deleteFromRepairTable(int id) throws SQLException{
        String sqlDelete = "DELETE FROM `warsztat` WHERE `warsztat`.`Nr_samochodu` = '" + id + "'";
        state.executeUpdate(sqlDelete);
        String sqlUpdate = "UPDATE `samochody` SET `dostepny` = '1' WHERE `samochody`.`Nr_samochodu` = '" + id + "';";
        state.executeUpdate(sqlUpdate);
    }
    
    public ResultSet populateTableViewCars() throws SQLException{
        String sqlQuery="SELECT * FROM `samochody`";
        return state.executeQuery(sqlQuery);        
    }
    
    public ResultSet populateTableViewClients() throws SQLException{
        String sqlQuery="SELECT * FROM `klienci`";
        return state.executeQuery(sqlQuery);        
    }
    
    public ResultSet populateTableRepair() throws SQLException{
        String sqlQuery="SELECT * FROM `warsztat`";
        return state.executeQuery(sqlQuery);        
    }
    
     public ResultSet populateTableReturns() throws SQLException{
        String sqlQuery="SELECT * FROM `zwroty`";
        return state.executeQuery(sqlQuery);        
    }
     public ResultSet populateTableRent() throws SQLException{
        String sqlQuery="SELECT * FROM `wypozyczenia`";
        return state.executeQuery(sqlQuery);        
    }
}
