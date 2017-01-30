
package rentcar;


public class Rent {
    
    private int Nr_wypozyczenia;
    private int Nr_pracownika;
    private String Data_wypozyczenia;
    private int Nr_samochodu;
    private int Nr_klienta;

    public Rent(int Nr_wypozyczenia, int Nr_pracownika, String Data_wypozyczenia, int Nr_samochodu, int Nr_klienta) {
        this.Nr_wypozyczenia = Nr_wypozyczenia;
        this.Nr_pracownika = Nr_pracownika;
        this.Data_wypozyczenia = Data_wypozyczenia;
        this.Nr_samochodu = Nr_samochodu;
        this.Nr_klienta = Nr_klienta;
    }

    public int getNr_wypozyczenia() {
        return Nr_wypozyczenia;
    }

    public void setNr_wypozyczenia(int Nr_wypozyczenia) {
        this.Nr_wypozyczenia = Nr_wypozyczenia;
    }

    public int getNr_pracownika() {
        return Nr_pracownika;
    }

    public void setNr_pracownika(int Nr_pracownika) {
        this.Nr_pracownika = Nr_pracownika;
    }

    public String getData_wypozyczenia() {
        return Data_wypozyczenia;
    }

    public void setData_wypozyczenia(String Data_wypozyczenia) {
        this.Data_wypozyczenia = Data_wypozyczenia;
    }

    public int getNr_samochodu() {
        return Nr_samochodu;
    }

    public void setNr_samochodu(int Nr_samochodu) {
        this.Nr_samochodu = Nr_samochodu;
    }

    public int getNr_klienta() {
        return Nr_klienta;
    }

    public void setNr_klienta(int Nr_klienta) {
        this.Nr_klienta = Nr_klienta;
    }



  
    
}
