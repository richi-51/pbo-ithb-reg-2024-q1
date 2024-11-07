package Model;

public abstract class Maskapai {
    private double km;

    public String printReceipt() {
        
        return "Total jarak tempuh: " + km + "km\n" ;
    }

    // Constructors
    public Maskapai(double km) {
        this.km = km;
    }

    public abstract double hitungBiayaTiket();

    // Getter and Setter
    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
    
}
