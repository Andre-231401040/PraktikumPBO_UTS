package soal1;

// deklarasi class Karyawan
public class Karyawan {
    // deklarasi atribut class Karyawan
    private int id;
    private float gaji;
    private String nama;
    private String posisi;
    private String divisi;

    // constructor class Karyawan untuk menginisialisasi id, gaji, nama, posisi, divisi
    public Karyawan(int id, float gaji, String nama, String posisi, String divisi) {
        setId(id);
        setGaji(gaji);
        setNama(nama);
        setPosisi(posisi);
        setDivisi(divisi);
    }

    // fungsi untuk mengambil nilai dari atribut id
    public int getId() {
        return id;
    }

    // fungsi untuk mengatur nilai dari atribut id
    public void setId(int id) {
        this.id = id;
    }

    // fungsi untuk mengambil nilai dari atribut gaji
    public float getGaji() {
        return gaji;
    }

    // fungsi untuk mengatur nilai dari atribut gaji
    public void setGaji(float gaji) {
        this.gaji = gaji;
    }

    // fungsi untuk mengambil nilai dari atribut nama
    public String getNama() {
        return nama;
    }

    // fungsi untuk mengatur nilai dari atribut nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // fungsi untuk mengambil nilai dari atribut posisi
    public String getPosisi() {
        return posisi;
    }

    // fungsi untuk mengatur nilai dari atribut posisi
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    // fungsi untuk mengambil nilai dari atribut divisi
    public String getDivisi() {
        return divisi;
    }

    // fungsi untuk mengatur nilai dari atribut divisi
    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}
