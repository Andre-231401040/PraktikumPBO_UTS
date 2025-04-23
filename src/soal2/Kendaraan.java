package soal2;

import java.text.DecimalFormat;

public class Kendaraan {
    private String jenis;
    private int durasiParkir;
    private int harga;
    private float totalHarga;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public Kendaraan(String jenis) {
        setJenis(jenis);
    }

    public String getJenis() {
        return jenis;
    }

    private void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getDurasiParkir() {
        return durasiParkir;
    }

    public void setDurasiParkir(int durasiParkir) {
        this.durasiParkir = durasiParkir;
    }

    public void setDurasiParkir(int waktuMasuk, int waktuKeluar) {
        if(waktuKeluar < waktuMasuk) {
            this.durasiParkir = waktuKeluar - waktuMasuk + 24;
        } else {
            this.durasiParkir = waktuKeluar - waktuMasuk;
        }
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga() {
        if(this.jenis.equals("motor")) {
            this.harga = 3000;
        } else if(this.jenis.equals("mobil")) {
            this.harga = 5000;
        } else {
            this.harga = 7000;
        }
    }

    public float getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        if(this.durasiParkir > 5) {
            this.totalHarga = totalHarga * 0.9f;
        } else {
            this.totalHarga = totalHarga;
        }
    }

    public void tampilkanRingkasanParkir() {
        System.out.println();
        System.out.println("--------------- Ringkasan Parkir ---------------");
        System.out.println("Jenis Kendaraan : " + this.jenis.substring(0, 1).toUpperCase() + this.jenis.substring(1));
        System.out.println("Durasi Parkir   : " + this.durasiParkir + " jam");
        System.out.println("Total Harga     : " + "Rp" + decimalFormat.format(this.totalHarga));
        System.out.println("------------------------------------------------");
    }
}
