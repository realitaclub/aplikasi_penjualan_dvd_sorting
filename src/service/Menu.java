package service;

import model.Dvd;
import model.Transaksi;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static ArrayList<Dvd> daftarDVD = new ArrayList<>();
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    static Scanner scanner;


    public Menu(Scanner scanner) {
        daftarDVD.add(new Dvd(1, "Avengers", "Action", 50000, 10));
        daftarDVD.add(new Dvd(2, "Frozen", "Animation", 40000, 5));
        daftarDVD.add(new Dvd(3, "Inception", "Sci-Fi", 60000, 7));
        daftarDVD.add(new Dvd(4, "Interstellar", "Sci-Fi", 70000, 4));
        daftarDVD.add(new Dvd(5, "Coco", "Animation", 35000, 15));
        this.scanner = scanner;
    }

    public void lihatDaftarDVD() {
        System.out.println("\n=========================================");
        System.out.println("===             Daftar DVD            ===");
        System.out.println("=========================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-5s |\n", "ID", "Judul", "Genre", "Harga", "Stok");
        System.out.println("------------------------------------------------------------");
        for (Dvd dvd : daftarDVD) {
            dvd.tampilkanDetail();
        }
        System.out.println("------------------------------------------------------------");
    }

    public void tambahDataDVD() {
        System.out.println("\n=== Tambah Data DVD ===");
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan Stok: ");
        int stok = scanner.nextInt();

        daftarDVD.add(new Dvd(id, judul, genre, harga, stok));
        System.out.println("\nDVD berhasil ditambahkan!");
    }

    public void cariDVD() {
        System.out.println("\n=== Cari DVD ===");
        System.out.print("Masukkan judul atau genre yang ingin dicari: ");
        scanner.nextLine();
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n=========================================");
        System.out.println("===         Hasil Pencarian           ===");
        System.out.println("=========================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-5s |\n", "ID", "Judul", "Genre", "Harga", "Stok");
        System.out.println("------------------------------------------------------------");
        boolean ditemukan = false;
        for (Dvd dvd : daftarDVD) {
            if (dvd.getJudul().toLowerCase().contains(keyword) || dvd.getGenre().toLowerCase().contains(keyword)) {
                dvd.tampilkanDetail();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada DVD yang cocok dengan pencarian Anda!");
        }
        System.out.println("------------------------------------------------------------");
    }


    public void transaksiPembelian() {
        System.out.println("\n=== Transaksi Pembelian ===");
        System.out.print("Masukkan ID DVD yang ingin dibeli: ");
        int id = scanner.nextInt();
        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int jumlah = scanner.nextInt();

        for (Dvd dvd : daftarDVD) {
            if (dvd.getId() == id) {
                if (dvd.getStok() >= jumlah) {
                    double totalHarga = dvd.getHarga() * jumlah;
                    dvd.kurangiStok(jumlah);
                    daftarTransaksi.add(new Transaksi(dvd.getId(), dvd.getJudul(), jumlah, totalHarga));
                    System.out.printf("\nTransaksi berhasil! Total harga: Rp%.2f\n", totalHarga);
                } else {
                    System.out.println("\nStok tidak mencukupi!");
                }
                return;
            }
        }
        System.out.println("\nDVD dengan ID tersebut tidak ditemukan!");
    }

    public void urutkanDVD() {
        System.out.println("\n=== Urutkan Daftar DVD ===");
        System.out.println("1. Berdasarkan stok (Bubble Sort)");
        System.out.println("2. Berdasarkan harga (Quick Sort)");
        System.out.print("Pilih: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                bubbleSort();
                System.out.println("\nDaftar DVD berhasil diurutkan berdasarkan stok!");
                break;
            case 2:
                quickSort(0, daftarDVD.size() - 1);
                System.out.println("\nDaftar DVD berhasil diurutkan berdasarkan harga!");
                break;
            default:
                System.out.println("\nPilihan tidak valid!");
        }
    }

    void bubbleSort() {
        int n = daftarDVD.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (daftarDVD.get(j).getStok() > daftarDVD.get(j + 1).getStok()) {
                    Dvd temp = daftarDVD.get(j);
                    daftarDVD.set(j, daftarDVD.get(j + 1));
                    daftarDVD.set(j + 1, temp);
                }
            }
        }
    }

    void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    int partition(int low, int high) {
        double pivot = daftarDVD.get(high).getHarga();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (daftarDVD.get(j).getHarga() < pivot) {
                i++;
                Dvd temp = daftarDVD.get(i);
                daftarDVD.set(i, daftarDVD.get(j));
                daftarDVD.set(j, temp);
            }
        }

        Dvd temp = daftarDVD.get(i + 1);
        daftarDVD.set(i + 1, daftarDVD.get(high));
        daftarDVD.set(high, temp);

        return i + 1;
    }

    public void lihatHistoryTransaksi() {
        System.out.println("\n=========================================");
        System.out.println("===         History Transaksi          ===");
        System.out.println("=========================================");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi yang tercatat!");
        } else {
            System.out.printf("| %-5s | %-20s | %-10s | %-10s |\n", "ID", "Judul", "Jumlah", "Total Harga");
            System.out.println("------------------------------------------------------------");
            for (Transaksi transaksi : daftarTransaksi) {
                transaksi.tampilkanDetail();
            }
            System.out.println("------------------------------------------------------------");
        }
    }

}
