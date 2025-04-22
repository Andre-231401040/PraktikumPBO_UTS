package soal1;

import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

// deklarasi class Perusahaan
public class Perusahaan {
    // menggunakan map untuk menyimpan daftar karyawan
    public Map<Integer, Karyawan> daftarKaryawan;

    // constructor class Perusahaan untuk menginisialisasi daftarKaryawan
    public Perusahaan() {
        daftarKaryawan = new HashMap<>();
    }

    // fungsi untuk menambah karyawan ke dalam map dengan id sebagai key dan objek karyawan sebagai value
    public void tambahKaryawan(int id, Karyawan karyawan) {
        if(karyawan.getGaji() >= 0) { // memastikan gaji tidak negatif
            daftarKaryawan.put(id++, karyawan);
            System.out.println("Karyawan baru berhasil ditambahkan.");
        } else {
            System.out.println("Gaji yang anda masukkan tidak valid (negatif).");
        }

        System.out.println();
    }

    // fungsi untuk menghapus data karyawan dari map berdasarkan id
    public void hapusKaryawan(int id) {
        if(daftarKaryawan.get(id) != null) {
            daftarKaryawan.remove(id);
            System.out.println("Karyawan dengan ID " + id + " berhasil dihapus.");
        } else {
            System.out.println("Tidak ada karyawan dengan ID " + id + ".");
        }

        System.out.println();
    }

    // fungsi untuk mengubah posisi karyawan berdasarkan id
    public void ubahPosisiKaryawan(int id, String posisiBaru) {
        if(daftarKaryawan.get(id) != null) {
            // mengubah posisi karyawan
            Karyawan karyawan = daftarKaryawan.get(id);
            daftarKaryawan.remove(id);
            karyawan.setPosisi(posisiBaru);
            daftarKaryawan.put(id, karyawan);
            System.out.println("Posisi karyawan dengan ID " + id + " berhasil diubah");
        } else {
            System.out.println("Tidak ada karyawan dengan ID " + id + ".");
        }

        System.out.println();
    }

    // fungsi untuk mengubah gaji karyawan berdasarkan id
    public void ubahGajiKaryawan(int id, float gajiBaru) {
        if(daftarKaryawan.get(id) != null) {
            if(gajiBaru >= 0) {
                // mengubah gaji karyawan
                Karyawan karyawan = daftarKaryawan.get(id);
                daftarKaryawan.remove(id);
                karyawan.setGaji(gajiBaru);
                daftarKaryawan.put(id, karyawan);
                System.out.println("Gaji karyawan dengan ID " + id + " berhasil diubah");
            } else {
                System.out.println("Gaji yang anda masukkan tidak valid (negatif).");
            }
        } else {
            System.out.println("Tidak ada karyawan dengan ID " + id + ".");
        }

        System.out.println();
    }

    // fungsi untuk menampilkan semua data karyawan
    public void tampilkanSemuaKaryawan() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        // %-angkas untuk mengatur panjang karakter setiap kolom
        System.out.printf("%-3s %-40s %-20s %-40s %-10s\n", "No", "Nama", "Divisi", "Posisi", "Gaji");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        int nomor = 1;
        float gaji;
        String nama, divisi, posisi;
        for(Karyawan karyawan : daftarKaryawan.values()) {
            gaji = karyawan.getGaji();
            nama = karyawan.getNama();
            divisi = karyawan.getDivisi();
            posisi = karyawan.getPosisi();

            DecimalFormat decimalFormat = new DecimalFormat("#");
            System.out.printf("%-3s %-40s %-20s %-40s %-10s\n", nomor++, nama, divisi, posisi, "Rp" + decimalFormat.format(gaji));
        }

        System.out.println();
    }

    // fungsi untuk mencari karyawan berdasarkan id
    public void cariKaryawan(int id) {
        if(daftarKaryawan.get(id) != null) {
            Karyawan karyawan = daftarKaryawan.get(id);
            DecimalFormat decimalFormat = new DecimalFormat("#");

            System.out.println("ID     : " + karyawan.getId());
            System.out.println("Nama   : " + karyawan.getNama());
            System.out.println("Divisi : " + karyawan.getDivisi());
            System.out.println("Posisi : " + karyawan.getPosisi());
            System.out.println("Gaji   : Rp" + decimalFormat.format(karyawan.getGaji()));
        } else {
            System.out.println("Tidak ada karyawan dengan ID " + id + ".");
        }

        System.out.println();
    }
}
