package soal1;

import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

public class Perusahaan {
    public Map<Integer, Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new HashMap<>();
    }

    public void tambahKaryawan(int id, Karyawan karyawan) {
        if(karyawan.getGaji() >= 0) { // memastikan gaji tidak negatif
            daftarKaryawan.put(id++, karyawan);
            System.out.println("Karyawan baru berhasil ditambahkan.");
        } else {
            System.out.println("Gaji yang anda masukkan tidak valid (negatif).");
        }

        System.out.println();
    }

    public void hapusKaryawan(int id) {
        if(daftarKaryawan.get(id) != null) {
            daftarKaryawan.remove(id);
            System.out.println("Karyawan dengan ID " + id + " berhasil dihapus.");
        } else {
            System.out.println("Tidak ada karyawan dengan ID " + id + ".");
        }

        System.out.println();
    }

    public void ubahPosisiKaryawan(int id, String posisiBaru) {
        if(daftarKaryawan.get(id) != null) {
            // memperbarui posisi karyawan berdasarkan ID
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

    public void ubahGajiKaryawan(int id, float gajiBaru) {
        if(daftarKaryawan.get(id) != null) {
            if(gajiBaru >= 0) {
                // memperbarui gaji karyawan berdasarkan ID
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

    public void tampilkanSemuaKaryawan() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
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
