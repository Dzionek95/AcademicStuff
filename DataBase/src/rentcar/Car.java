package rentcar;

public class Car {
//polish variables, because of columns names in DB
    
    
    private String Marka;
    private String Typ;
    private String Rok_produkcji;
    private double Pojemnosc_silnika;
    private String Rodzaj_silnika;
    private double Kaucja;
    private double Cena_dzien;
    private int dostepny;
    private int Nr_samochodu;

    public Car(int Nr_samochodu, String Marka, String Typ, String Rok_produkcji, double Pojemnosc_silnika, String Rodzaj_silnika, double Kaucja, double Cena_dzien, int dostepny) {
        this.Marka = Marka;
        this.Typ = Typ;
        this.Rok_produkcji = Rok_produkcji;
        this.Pojemnosc_silnika = Pojemnosc_silnika;
        this.Rodzaj_silnika = Rodzaj_silnika;
        this.Kaucja = Kaucja;
        this.Cena_dzien = Cena_dzien;
        this.dostepny = dostepny;
        this.Nr_samochodu=Nr_samochodu;
    }

    public int getNr_samochodu() {
        return Nr_samochodu;
    }

    public void setNr_samochodu(int Nr_samochodu) {
        this.Nr_samochodu = Nr_samochodu;
    }

    
    public String getMarka() {
        return Marka;
    }

    public void setMarka(String Marka) {
        this.Marka = Marka;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String Typ) {
        this.Typ = Typ;
    }

    public String getRok_produkcji() {
        return Rok_produkcji;
    }

    public void setRok_produkcji(String Rok_produkcji) {
        this.Rok_produkcji = Rok_produkcji;
    }

    public double getPojemnosc_silnika() {
        return Pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(double Pojemnosc_silnika) {
        this.Pojemnosc_silnika = Pojemnosc_silnika;
    }

    public String getRodzaj_silnika() {
        return Rodzaj_silnika;
    }

    public void setRodzaj_silnika(String Rodzaj_silnika) {
        this.Rodzaj_silnika = Rodzaj_silnika;
    }

    public double getKaucja() {
        return Kaucja;
    }

    public void setKaucja(double Kaucja) {
        this.Kaucja = Kaucja;
    }

    public double getCena_dzien() {
        return Cena_dzien;
    }

    public void setCena_dzien(double Cena_dzien) {
        this.Cena_dzien = Cena_dzien;
    }

    public int getDostepny() {
        return dostepny;
    }

    public void setDostepny(int dostepny) {
        this.dostepny = dostepny;
    }

 

  
}
