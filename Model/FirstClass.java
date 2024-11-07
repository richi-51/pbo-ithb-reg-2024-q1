package Model;

public class FirstClass extends Maskapai{
    private boolean isInsurance;
    private String menuMakanan;
    
    // Constructors
    public FirstClass(double km, boolean isInsurance, String menuMakanan) {
        super(km);
        this.isInsurance  = isInsurance;
        this.menuMakanan = menuMakanan;
    }

    @Override
    public String printReceipt() {
        return super.printReceipt() + "Jenis maskapai: First Class\nApakah Asuransi: " + isInsurance + "\nMenu makanan yang Anda pilih: " + menuMakanan + "\n";
    }

    @Override
    public double hitungBiayaTiket(){
        double price = getKm() * 15000;


        if (isInsurance) {
            price = price * 1.1;
        }

        return price;
    }
    
    // getter and setter
    public boolean isInsurance() {
        return isInsurance;
    }

    public void setInsurance(boolean isInsurance) {
        this.isInsurance = isInsurance;
    }
}
