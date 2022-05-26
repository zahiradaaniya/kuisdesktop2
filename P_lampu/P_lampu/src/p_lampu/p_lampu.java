package p_lampu;

public class p_lampu {
     private int id;
    private String nama_lampu;
    private String daya;
    private String tanggal;
    private int berat;

    public p_lampu(int id, String nama_lampu, String daya, String tanggal, int berat) {
        this.id = id;
        this.nama_lampu = nama_lampu;
        this.daya = daya;
        this.tanggal = tanggal;
        this.berat = berat;
    }

    public int getId() {
        return id;
    }

    public String getNama_lampu() {
        return nama_lampu;
    }

    public String getDaya() {
        return daya;
    }

    public String getTanggal() {
        return tanggal;
    } 

    public int getBerat() {
        return berat;
    }
}
