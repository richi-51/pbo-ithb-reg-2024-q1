package Model;

public class Bisnis extends Maskapai {
    private double berat;
    private boolean isAfirmasi;
    private String menuMakanan;

    
    // Constructor
    public Bisnis(double km, double berat, boolean isAfirmasi, String menuMakanan){
        super(km);
        this.berat = berat;
        this.isAfirmasi = isAfirmasi;
        this.menuMakanan = menuMakanan;
    }

    @Override
    public String printReceipt() {
        return super.printReceipt() + "Jenis maskapai: Bisnis\nBerat bawaan: " + berat + "kg\nApakah Afirmasi: " + isAfirmasi + "\nMenu makanan yang Anda pilih: " + menuMakanan + "\n";
    }
    
    @Override
    public double hitungBiayaTiket(){
        double price = getKm() * 10000;

        if (!isUnder5()) {
            price += this.berat * 2500;
        }

        if (isAfirmasi) {
            price = price * 1.1;
        }

        return price;
    }

    public boolean isUnder5(){
        return berat <= 5;

    }
    // getter and setter
    public double getBerat() {
        return berat;
    }
    
    public void setBerat(double berat) {
        this.berat = berat;
    }
    
    public boolean isAfirmasi() {
        return isAfirmasi;
    }
    
    public void setAfirmasi(boolean isAfirmasi) {
        this.isAfirmasi = isAfirmasi;
    }
}

