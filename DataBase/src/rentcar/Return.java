
package rentcar;


public class Return {
    
    private int Nr_zwrotu;
    private int Nr_pracownika;
    private String Data_zwrotu;
    private int Nr_samochodu;

    public Return(int Nr_zwrotu, int Nr_pracownika, String Data_zwrotu, int Nr_samochodu) {
        this.Nr_zwrotu = Nr_zwrotu;
        this.Nr_pracownika = Nr_pracownika;
        this.Data_zwrotu = Data_zwrotu;
        this.Nr_samochodu = Nr_samochodu;
    }
    
    public int getNr_zwrotu() {
        return Nr_zwrotu;
    }

    public void setNr_zwrotu(int Nr_zwrotu) {
        this.Nr_zwrotu = Nr_zwrotu;
    }

    public int getNr_pracownika() {
        return Nr_pracownika;
    }

    public void setNr_pracownika(int Nr_pracownika) {
        this.Nr_pracownika = Nr_pracownika;
    }

    public String getData_zwrotu() {
        return Data_zwrotu;
    }

    public void setData_zwrotu(String Data_zwrotu) {
        this.Data_zwrotu = Data_zwrotu;
    }

    public int getNr_samochodu() {
        return Nr_samochodu;
    }

    public void setNr_samochodu(int Nr_samochodu) {
        this.Nr_samochodu = Nr_samochodu;
    }

    
    
}
