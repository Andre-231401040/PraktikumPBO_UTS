package soal1;

public class Karyawan {
    private int id;
    private float gaji;
    private String nama;
    private String posisi;
    private String divisi;

    public Karyawan(int id, float gaji, String nama, String posisi, String divisi) {
        setId(id);
        setGaji(gaji);
        setNama(nama);
        setPosisi(posisi);
        setDivisi(divisi);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGaji() {
        return gaji;
    }

    public void setGaji(float gaji) {
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}
