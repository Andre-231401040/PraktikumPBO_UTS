package soal2;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        float totalPengeluaran = 0;
        String jenisKendaraan, tipeInput;
        int durasi, waktuMasuk, waktuKeluar, totalHarga;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        String addAnotherVehicle = "y";
        System.out.println("=============== Selamat Datang di ParkingChan ===============");
        while(addAnotherVehicle.equals("y") || addAnotherVehicle.equals("Y")) {
            System.out.println();
            System.out.print("Masukkan Jenis Kendaraan (Motor/Mobil/Truk) : ");
            jenisKendaraan = scanner.nextLine();
            jenisKendaraan = jenisKendaraan.toLowerCase();

            if(jenisKendaraan.equals("motor") || jenisKendaraan.equals("mobil") || jenisKendaraan.equals("truk")) {
                System.out.print("Masukkan Tipe Input (Durasi/Waktu) : ");
                tipeInput = scanner.nextLine();

                if(tipeInput.equals("durasi") || tipeInput.equals("Durasi")) {
                    try {
                        System.out.print("Masukkan Durasi (Jam) : ");
                        durasi = Integer.parseInt(scanner.nextLine());

                        if(durasi >= 0) {
                            Kendaraan kendaraan = new Kendaraan(jenisKendaraan);
                            kendaraan.setDurasiParkir(durasi);
                            kendaraan.setHarga();

                            totalHarga = kendaraan.getHarga() * durasi;
                            kendaraan.setTotalHarga(totalHarga);

                            kendaraan.tampilkanRingkasanParkir();

                            daftarKendaraan.add(kendaraan);
                        } else {
                            System.out.println("Durasi yang anda masukkan tidak valid.");
                        }
                    } catch(NumberFormatException e) {
                        System.out.println("Durasi yang anda masukkan tidak valid.");
                    }
                } else if(tipeInput.equals("waktu") || tipeInput.equals("Waktu")) {
                    try {
                        System.out.print("Masukkan Waktu Masuk : ");
                        waktuMasuk = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Waktu Keluar : ");
                        waktuKeluar = Integer.parseInt(scanner.nextLine());

                        if(waktuMasuk >= 1 && waktuMasuk <= 24 && waktuKeluar >= 1 && waktuKeluar <= 24) {
                            Kendaraan kendaraan = new Kendaraan(jenisKendaraan);
                            kendaraan.setDurasiParkir(waktuMasuk, waktuKeluar);
                            kendaraan.setHarga();

                            durasi = kendaraan.getDurasiParkir();
                            totalHarga = kendaraan.getHarga() * durasi;
                            kendaraan.setTotalHarga(totalHarga);

                            kendaraan.tampilkanRingkasanParkir();

                            daftarKendaraan.add(kendaraan);
                        } else {
                            System.out.println("Waktu yang anda masukkan tidak valid.");
                        }
                    } catch(NumberFormatException e) {
                        System.out.println("Waktu yang anda masukkan tidak valid.");
                    }
                } else {
                    System.out.println("Tipe input yang anda masukkan tidak valid.");
                }
            } else {
                System.out.println("Jenis kendaraan yang anda masukkan tidak valid.");
            }

            System.out.println();
            System.out.print("Apakah anda ingin menambah kendaraan lain? (y/n) : ");
            addAnotherVehicle = scanner.nextLine();
        }
        System.out.println();
        System.out.println("==============================================================");

        for (Kendaraan kendaraan : daftarKendaraan) {
            totalPengeluaran += kendaraan.getTotalHarga();
        }

        System.out.println();
        System.out.println("======================== FINAL REPORT =========================");
        System.out.println();
        System.out.println("Jumlah Kendaraan : " + daftarKendaraan.size());
        System.out.println("Total Harga      : " + decimalFormat.format(totalPengeluaran));
        System.out.println("Terima kasih telah menggunakan ParkingChan.");
        System.out.println();
        System.out.println("==============================================================");
    }
}
