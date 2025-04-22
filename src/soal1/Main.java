package soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 0, option;
        Perusahaan perusahaan = new Perusahaan();

        do {
            try {
                int idKaryawan;
                Scanner scanner = new Scanner(System.in);

                System.out.println("=== SISTEM MANAJEMEN KARYAWAN ===");
                System.out.println("1. Tambah Karyawan");
                System.out.println("2. Hapus Karyawan");
                System.out.println("3. Ubah Posisi Karyawan");
                System.out.println("4. Ubah Gaji Karyawan");
                System.out.println("5. Tampilkan Semua Karyawan");
                System.out.println("6. Cari Karyawan");
                System.out.println("7. Keluar");
                System.out.println("=================================");
                System.out.print("Masukkan Pilihan : ");
                option = Integer.parseInt(scanner.nextLine());

                switch(option) {
                    case 1:
                        float gaji;
                        String nama, posisi, divisi;

                        try {
                            System.out.print("Masukkan Nama : ");
                            nama = scanner.nextLine();
                            System.out.print("Masukkan Divisi : ");
                            divisi = scanner.nextLine();
                            System.out.print("Masukkan Posisi : ");
                            posisi = scanner.nextLine();
                            System.out.print("Masukkan Gaji : ");
                            gaji = Float.parseFloat(scanner.nextLine());

                            Karyawan karyawan = new Karyawan(id, gaji, nama, posisi, divisi);
                            perusahaan.tambahKaryawan(id, karyawan);
                            id++;
                        } catch(NumberFormatException e) {
                            System.out.println("Gaji yang anda masukkan tidak valid (bukan angka).");
                            System.out.println();
                        }

                        break;
                    case 2:
                        try {
                            System.out.print("Masukkan ID Karyawan : ");
                            idKaryawan = Integer.parseInt(scanner.nextLine());
                            perusahaan.hapusKaryawan(idKaryawan);
                        } catch(NumberFormatException e) {
                            System.out.println("ID yang anda masukkan tidak valid (bukan angka).");
                            System.out.println();
                        }

                        break;
                    case 3:
                        String posisiBaru;

                        try {
                            System.out.print("Masukkan ID Karyawan : ");
                            idKaryawan = Integer.parseInt(scanner.nextLine());
                            System.out.print("Masukkan Posisi Baru : ");
                            posisiBaru = scanner.nextLine();

                            perusahaan.ubahPosisiKaryawan(idKaryawan, posisiBaru);
                        } catch(NumberFormatException e) {
                            System.out.println("ID yang anda masukkan tidak valid (bukan angka).");
                            System.out.println();
                        }

                        break;
                    case 4:
                        float gajiBaru;

                        try {
                            System.out.print("Masukkan ID Karyawan : ");
                            idKaryawan = Integer.parseInt(scanner.nextLine());
                            System.out.print("Masukkan Gaji Baru : ");
                            gajiBaru = Float.parseFloat(scanner.nextLine());

                            perusahaan.ubahGajiKaryawan(idKaryawan, gajiBaru);
                        } catch(NumberFormatException e) {
                            System.out.println("ID atau gaji yang anda masukkan tidak valid (bukan angka).");
                            System.out.println();
                        }

                        break;
                    case 5:
                        perusahaan.tampilkanSemuaKaryawan();
                        break;
                    case 6:
                        try {
                            System.out.print("Masukkan ID Karyawan : ");
                            idKaryawan = Integer.parseInt(scanner.nextLine());
                            perusahaan.cariKaryawan(idKaryawan);
                        } catch(NumberFormatException e) {
                            System.out.println("ID yang anda masukkan tidak valid (bukan angka).");
                            System.out.println();
                        }

                        break;
                    case 7:
                        System.out.println("Terima kasih telah menggunakan sistem.");
                        return;
                    default:
                        System.out.println("Pilihan yang anda masukkan tidak ada di dalam opsi.");
                        System.out.println();
                }
            } catch(NumberFormatException e) {
                System.out.println("Pilihan yang anda masukkan tidak valid (bukan angka).");
                System.out.println();
            }
        } while(true);
    }
}
