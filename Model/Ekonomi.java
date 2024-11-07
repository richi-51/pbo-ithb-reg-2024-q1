package Model;

public class Ekonomi extends Maskapai {
    private double berat;
    
    // Constructor
    public Ekonomi(double km, double berat){
        super(km);
        this.berat = berat;
    }
    
    @Override
    public String printReceipt() {
        return super.printReceipt() + "Jenis maskapai: Ekonomi\nBerat bawaan: " + berat + "kg\n";
    }

    @Override
    public double hitungBiayaTiket(){
        double price = getKm() * 7500;

        if (!isUnder5()) {
            price += this.berat * 1500;
        }

        return price + 5000;
    }

    public boolean isUnder5(){
        return berat <= 5;
    }
    
    // Getter and setter
    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
}
