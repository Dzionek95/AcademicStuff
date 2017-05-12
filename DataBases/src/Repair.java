package rentcar;


public class Repair {
    
    private int Nr_awarii;
    private int Nr_samochodu;
    private String Krotki_Opis;

    public Repair(int Nr_awarii, int Nr_samochodu, String Krotki_Opis) {
        this.Nr_awarii = Nr_awarii;
        this.Nr_samochodu = Nr_samochodu;
        this.Krotki_Opis = Krotki_Opis;
    }

    public int getNr_awarii() {
        return Nr_awarii;
    }

    public void setNr_awarii(int Nr_awarii) {
        this.Nr_awarii = Nr_awarii;
    }

    public int getNr_samochodu() {
        return Nr_samochodu;
    }

    public void setNr_samochodu(int Nr_samochodu) {
        this.Nr_samochodu = Nr_samochodu;
    }

    public String getKrotki_Opis() {
        return Krotki_Opis;
    }

    public void setKrotki_Opis(String Krotki_Opis) {
        this.Krotki_Opis = Krotki_Opis;
    }
    
    
    
}
