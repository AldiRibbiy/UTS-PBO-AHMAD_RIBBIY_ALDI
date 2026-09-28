package uts.pbo.ahmad_ribbiy_aldi_2509116100;

// Superclass
public class Kendaraan {
    private String plat;
    private String merk;
    private double tarifPerHari;
    private boolean tersedia;

    public Kendaraan(String plat, String merk, double tarifPerHari) {
        this.plat = plat;
        this.merk = merk;
        this.tarifPerHari = tarifPerHari;
        this.tersedia = true;
    }

    public String getPlat() { return plat; }
    public String getMerk() { return merk; }
    public double getTarifPerHari() { return tarifPerHari; }
    public boolean isTersedia() { return tersedia; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    // Dapat di-override oleh subclass
    public double hitungBiaya(int hari) {
        return tarifPerHari * hari;
    }

    public String getJenis() {
        return "Kendaraan";
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s - Rp%.0f/hari - %s",
                getJenis(), plat, merk, tarifPerHari,
                tersedia ? "Tersedia" : "Disewa");
    }
}
