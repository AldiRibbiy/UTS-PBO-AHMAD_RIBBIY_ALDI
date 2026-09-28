# UTS PBO - Aplikasi Rental Kendaraan (Java CLI)

| | |
|---|---|
| **Nama** | Ahmad Ribbiy Aldi |
| **NIM** | 2509116100 |
| **Mata Kuliah** | Pemrograman Berorientasi Objek |
| **Tugas** | UTS |

## Deskripsi Proyek
Aplikasi rental kendaraan berbasis konsol yang dibuat dengan Java. Program ini
membantu mencatat kendaraan yang tersedia, memproses penyewaan lengkap dengan
perhitungan total biaya, dan menerima pengembalian kendaraan. Kendaraan yang
disediakan ada dua jenis, yaitu mobil dan motor, dan tiap jenis punya cara
hitung biaya sendiri.

### Konsep OOP yang Dipakai
| Konsep | Penerapan |
|---|---|
| Inheritance | `Mobil` dan `Motor` adalah subclass dari `Kendaraan` (2 tipe) |
| Polymorphism | Method `hitungBiaya()`, `getJenis()`, dan `toString()` di-override di subclass |
| Condition | `if`/`else` untuk validasi input, cek ketersediaan, dan diskon motor |
| Looping | `do-while` pada menu utama dan `for` saat menampilkan daftar kendaraan |

### Struktur Project
```
src/uts/pbo/ahmad_ribbiy_aldi_2509116100/
├── Kendaraan.java   (superclass)
├── Mobil.java       (subclass)
├── Motor.java       (subclass)
└── Main.java        (menu utama)
```

### Hierarki Class
```
        Kendaraan
         /     \
      Mobil    Motor
```

| Class | Atribut Tambahan | Aturan Biaya |
|---|---|---|
| `Kendaraan` | plat, merk, tarifPerHari, tersedia | tarif x jumlah hari |
| `Mobil` | jumlahKursi | tarif x hari + asuransi Rp50.000 |
| `Motor` | kapasitasCC | tarif x hari, diskon 10% bila sewa 3 hari atau lebih |

## Alur Program

### Petunjuk Eksekusi
**Lewat NetBeans:** buka project, klik kanan `Main.java`, lalu pilih **Run File** (Shift+F6).

**Lewat terminal** (dari folder utama project, JDK 14+):
```bash
javac -d out src/uts/pbo/ahmad_ribbiy_aldi_2509116100/*.java
java -cp out uts.pbo.ahmad_ribbiy_aldi_2509116100.Main
```

### Cara Kerja Sistem
1. Saat dijalankan, `Main` mengisi data awal berupa 2 mobil dan 2 motor.
2. Menu utama tampil terus-menerus sampai pengguna memilih menu `0`.
3. **Menu 1 (Lihat daftar):** menampilkan seluruh kendaraan dan statusnya, Tersedia atau Disewa.
4. **Menu 2 (Sewa):** pengguna memilih nomor kendaraan dan lama sewa. Bila kendaraan tersedia, statusnya menjadi Disewa dan total biaya dihitung oleh `hitungBiaya()` sesuai jenis kendaraan. Bila kendaraan sedang disewa atau input tidak valid, muncul pesan kesalahan.
5. **Menu 3 (Kembalikan):** pengguna memilih nomor kendaraan, dan statusnya kembali menjadi Tersedia.
6. **Menu 0 (Keluar):** program selesai.

## Penjelasan Gambar
<img width="678" height="820" alt="image" src="https://github.com/user-attachments/assets/c4ff7c03-2c3b-4026-a9ab-7bc539f006e9" />

Gambar di atas adalah hasil program saat dijalankan lewat NetBeans, yang
memperlihatkan tiga alur utama:

1. **Lihat daftar kendaraan (menu 1)**
   Program menampilkan 4 kendaraan, yaitu 2 mobil dan 2 motor, lengkap dengan
   plat, merk, tarif per hari, status, serta data khusus tiap jenis (jumlah
   kursi untuk mobil, kapasitas cc untuk motor). Semua kendaraan berstatus
   *Tersedia* karena belum ada yang disewa.

2. **Sewa kendaraan (menu 2)**
   Pengguna memilih kendaraan nomor 3 (Honda Beat, tarif Rp80.000/hari) dengan
   lama sewa 2 hari. Program menghitung total biaya Rp160.000 lewat method
   `hitungBiaya()` milik class `Motor`. Diskon 10% belum berlaku karena
   sewanya kurang dari 3 hari. Setelah berhasil, status Honda Beat berubah
   menjadi *Disewa*, seperti terlihat pada daftar di menu berikutnya.

3. **Kembalikan kendaraan (menu 3)**
   Pengguna memilih kendaraan nomor 3 untuk dikembalikan. Program menampilkan
   pesan "Kendaraan sudah dikembalikan" dan status Honda Beat kembali menjadi
   *Tersedia*.

Menu utama ditampilkan berulang lewat perulangan `do-while` sampai pengguna
memilih menu `0`.
