package Controller;
import Model.*;

public class MaskapaiController {
    private Maskapai paketMaskapai[];
    
    public MaskapaiController(Maskapai[] paketMaskapai) {
        this.paketMaskapai = paketMaskapai;
    }
    
    public Maskapai[] getPaketMaskapai() {
        return paketMaskapai;
    }

    public String printFinalReceipt() {
        double total;
        double grandTotal = 0;
        String result = "======RUDILINES======\n";

        for (Maskapai maskapai2 : paketMaskapai) {
            
            if (maskapai2 instanceof Ekonomi) {
                Ekonomi ekonomi = (Ekonomi) maskapai2;
                total = ekonomi.hitungBiayaTiket();
                grandTotal += total;
                result += ekonomi.printReceipt() + "\nTotal biaya: " + total+ "\n\n";
            } else if (maskapai2 instanceof Bisnis) {
                Bisnis bisnis = (Bisnis) maskapai2;
                total = bisnis.hitungBiayaTiket();
                grandTotal += total;
                result += bisnis.printReceipt() + "\nTotal biaya: " + total+ "\n\n";
            } else if (maskapai2 instanceof FirstClass) {
                FirstClass fc = (FirstClass) maskapai2;
                total = fc.hitungBiayaTiket();
                grandTotal += total;
                result += fc.printReceipt() + "\nTotal biaya: " + total + "\n\n";
            } else {
                result += "Maaf jenis maskapai tidak tersedia" + "\n\n";
            }
        }


        return result + "\nGrand Total: " + grandTotal;
    }
}
