package rentcar;


public class Client {
    private int Nr_klienta;
    private String Imie;
    private String Nazwisko;
    private String Ulica;
    private String Numer;
    private String Miasto;
    private int PESEL;
    private String Nr_dowodu;

    public Client(int Nr_klienta, String Imie, String Nazwisko, String Ulica, String Numer, String Miasto, int PESEL, String Nr_dowodu) {
        this.Nr_klienta = Nr_klienta;
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.Ulica = Ulica;
        this.Numer = Numer;
        this.Miasto = Miasto;
        this.PESEL = PESEL;
        this.Nr_dowodu = Nr_dowodu;
    }

    public int getNr_klienta() {
        return Nr_klienta;
    }

    public void setNr_klienta(int Nr_klienta) {
        this.Nr_klienta = Nr_klienta;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String Ulica) {
        this.Ulica = Ulica;
    }

    public String getNumer() {
        return Numer;
    }

    public void setNumer(String Numer) {
        this.Numer = Numer;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String Miasto) {
        this.Miasto = Miasto;
    }

    public int getPESEL() {
        return PESEL;
    }

    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }

    public String getNr_dowodu() {
        return Nr_dowodu;
    }

    public void setNr_dowodu(String Nr_dowodu) {
        this.Nr_dowodu = Nr_dowodu;
    }
    
    
}
