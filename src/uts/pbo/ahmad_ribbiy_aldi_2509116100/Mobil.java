package uts.pbo.ahmad_ribbiy_aldi_2509116100;

// Subclass dari Kendaraan
public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String plat, String merk, double tarifPerHari, int jumlahKursi) {
        super(plat, merk, tarifPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public double hitungBiaya(int hari) {
        // Biaya asuransi tetap Rp50.000 per rental
        return super.hitungBiaya(hari) + 50000;
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + jumlahKursi + " kursi";
    }
}
