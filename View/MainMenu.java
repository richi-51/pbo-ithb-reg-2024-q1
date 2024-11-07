package View;

import Model.*;
import Controller.MaskapaiController;

import javax.swing.JOptionPane;

public class MainMenu {
    private MaskapaiController ctrl;

    // Constructor
    public MainMenu(MaskapaiController ctrl) {
        this.ctrl = ctrl;
    }

    public MainMenu(){

    }

    // Getter and Setter
    public MaskapaiController getCtrl() {
        return ctrl;
    }

    public void showMenu() {
        while (true) {
            String[] options = {
                    "Pesan 1 maskapai",
                    "Pesan paket maskapai",
                    "Exit"
            };

            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Pilih fungsi:",
                    "Maskapai Controller",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == null || choice.equals("Exit")) {
                JOptionPane.showMessageDialog(null, "Program selesai");
                System.exit(0);
            }

            Maskapai paketMaskapai [];
            switch (choice) {
                case "Pesan 1 maskapai":
                    paketMaskapai = new Maskapai[1];
                    paketMaskapai[0] = inputData();
                    ctrl = new MaskapaiController(paketMaskapai);
                    JOptionPane.showMessageDialog(null, ctrl.printFinalReceipt());
                    break;

                case "Pesan paket maskapai":
                    int jmlhMaskapai = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah maskapai yang ingin dipesan: "));

                    paketMaskapai = new Maskapai[jmlhMaskapai];
                    for (int i = 0; i < jmlhMaskapai; i++) {
                        paketMaskapai[i] = inputData();
                    }
                    
                    ctrl = new MaskapaiController(paketMaskapai);
                    JOptionPane.showMessageDialog(null, ctrl.printFinalReceipt());
                    break;

            }
        }

    }

    public Maskapai inputData() {
        String jenis = JOptionPane.showInputDialog("Masukkan jenis maskapai (Ekonomi, Bisnis, First Class): ");

        if (jenis.equalsIgnoreCase("Ekonomi")) {
            double jarak = Double.parseDouble(JOptionPane.showInputDialog("Masukkan jarak tempuh (km): "));
            double berat = Double.parseDouble(JOptionPane.showInputDialog("Masukkan berat barang (kg): "));

            Ekonomi ekonomi = new Ekonomi(jarak, berat);
            return ekonomi;

        } else if (jenis.equalsIgnoreCase("Bisnis")) {
            double jarak = Double.parseDouble(JOptionPane.showInputDialog("Masukkan jarak tempuh (km): "));
            double berat = Double.parseDouble(JOptionPane.showInputDialog("Masukkan berat barang (kg): "));
            boolean isAfirmasi = Boolean.parseBoolean(JOptionPane.showInputDialog("Apakah afirmasi? (true/false) "));
            
            String menuMakanan = "Tidak ada";
            if (isAfirmasi) {
                menuMakanan = JOptionPane.showInputDialog("Silahkan pilih 1 menu makanan:\n1. Nasi goreng\n2. Mie goreng\n3. Seafood \nSilahkan masukkan pilihan (nama makanannya): ");
                JOptionPane.showMessageDialog(null, "Anda dapat tambah porsi sebanyak apapun.");
            }

            Bisnis bisnis = new Bisnis(jarak, berat, isAfirmasi, menuMakanan);
            return bisnis;

        } else if (jenis.equalsIgnoreCase("First Class")) {
            double jarak = Double.parseDouble(JOptionPane.showInputDialog("Masukkan jarak tempuh (km): "));
            boolean isInsurance = Boolean.parseBoolean(JOptionPane.showInputDialog("Apakah asuransi perjalanan? (true/false) "));

            String menuMakanan = "Tidak ada";
            menuMakanan = JOptionPane.showInputDialog("Silahkan pilih 2 menu makanan:\n1. Nasi goreng\n2. Mie goreng\n3. Seafood \nSilahkan masukkan pilihan pertama (nama makanannya): ");
            menuMakanan += ", " + JOptionPane.showInputDialog("Silahkan pilih 1 menu makanan:\n1. Nasi goreng\n2. Mie goreng\n3. Seafood \nSilahkan masukkan pilihan kedua (nama makanannya): ");
            JOptionPane.showMessageDialog(null, "Anda dapat tambah porsi sebanyak apapun.");

            FirstClass fc = new FirstClass(jarak, isInsurance, menuMakanan);
            return fc;
        }
        return null;
    }

}
