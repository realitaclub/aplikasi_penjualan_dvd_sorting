import service.Menu;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=========================================");
            System.out.println("===      Aplikasi Transaksi DVD       ===");
            System.out.println("=========================================");
            System.out.println("1. Lihat Daftar DVD");
            System.out.println("2. Tambah Data DVD");
            System.out.println("3. Cari DVD");
            System.out.println("4. Transaksi Pembelian");
            System.out.println("5. Urutkan Daftar DVD");
            System.out.println("6. Lihat History Transaksi");
            System.out.println("7. Keluar");
            System.out.println("=========================================");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            Menu menu = new Menu(scanner);

            switch (pilihan) {
                case 1:
                    menu.lihatDaftarDVD();
                    break;
                case 2:
                    menu.tambahDataDVD();
                    break;
                case 3:
                    menu.cariDVD();
                    break;
                case 4:
                    menu.transaksiPembelian();
                    break;
                case 5:
                    menu.urutkanDVD();
                    break;
                case 6:
                    menu.lihatHistoryTransaksi();
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);
    }

}
