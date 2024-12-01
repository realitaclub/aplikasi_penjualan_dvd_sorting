package model;

public class Transaksi {
    int idDVD;
    String judulDVD;
    int jumlah;
    double totalHarga;

    public Transaksi(int idDVD, String judulDVD, int jumlah, double totalHarga) {
        this.idDVD = idDVD;
        this.judulDVD = judulDVD;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public void tampilkanDetail() {
        System.out.printf("| %-5d | %-20s | %-10d | %-10.2f |\n", idDVD, judulDVD, jumlah, totalHarga);
    }
}
