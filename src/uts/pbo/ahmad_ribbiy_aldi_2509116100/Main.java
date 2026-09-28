package uts.pbo.ahmad_ribbiy_aldi_2509116100;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Kendaraan> daftar = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Data awal
        daftar.add(new Mobil("KT 1234 AB", "Toyota Avanza", 350000, 7));
        daftar.add(new Mobil("KT 5678 CD", "Honda Brio", 300000, 5));
        daftar.add(new Motor("KT 1111 EF", "Honda Beat", 80000, 110));
        daftar.add(new Motor("KT 2222 GH", "Yamaha NMAX", 150000, 155));

        int pilihan;
        do {
            System.out.println("\n=== RENTAL KENDARAAN ===");
            System.out.println("1. Lihat daftar kendaraan");
            System.out.println("2. Sewa kendaraan");
            System.out.println("3. Kembalikan kendaraan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = bacaAngka();

            switch (pilihan) {
                case 1 -> tampilkanDaftar();
                case 2 -> sewa();
                case 3 -> kembalikan();
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanDaftar() {
        System.out.println("\n--- Daftar Kendaraan ---");
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println((i + 1) + ". " + daftar.get(i));
        }
    }

    private static void sewa() {
        tampilkanDaftar();
        System.out.print("Nomor kendaraan: ");
        int no = bacaAngka();
        if (no < 1 || no > daftar.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }
        Kendaraan k = daftar.get(no - 1);
        if (!k.isTersedia()) {
            System.out.println("Kendaraan sedang disewa.");
            return;
        }
        System.out.print("Lama sewa (hari): ");
        int hari = bacaAngka();
        if (hari < 1) {
            System.out.println("Lama sewa tidak valid.");
            return;
        }
        k.setTersedia(false);
        System.out.printf("Berhasil! Total biaya: Rp%.0f%n", k.hitungBiaya(hari));
    }

    private static void kembalikan() {
        tampilkanDaftar();
        System.out.print("Nomor kendaraan: ");
        int no = bacaAngka();
        if (no < 1 || no > daftar.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }
        daftar.get(no - 1).setTersedia(true);
        System.out.println("Kendaraan sudah dikembalikan.");
    }

    private static int bacaAngka() {
        try {
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
