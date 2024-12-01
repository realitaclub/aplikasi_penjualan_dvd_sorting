package model;

public class Dvd {
    int id;
    String judul;
    String genre;
    double harga;
    int stok;


    public int getId() {
        return id;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Dvd(int id, String judul, String genre, double harga, int stok) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanDetail() {
        System.out.printf("| %-5d | %-20s | %-10s | %-10.2f | %-5d |\n", id, judul, genre, harga, stok);
    }
}
