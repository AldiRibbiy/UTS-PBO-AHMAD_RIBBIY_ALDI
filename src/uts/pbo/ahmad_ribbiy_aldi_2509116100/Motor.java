package uts.pbo.ahmad_ribbiy_aldi_2509116100;

// Subclass dari Kendaraan
public class Motor extends Kendaraan {
    private int kapasitasCC;

    public Motor(String plat, String merk, double tarifPerHari, int kapasitasCC) {
        super(plat, merk, tarifPerHari);
        this.kapasitasCC = kapasitasCC;
    }

    @Override
    public double hitungBiaya(int hari) {
        // Diskon 10% jika sewa 3 hari atau lebih
        double total = super.hitungBiaya(hari);
        return hari >= 3 ? total * 0.9 : total;
    }

    @Override
    public String getJenis() {
        return "Motor";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + kapasitasCC + " cc";
    }
}
