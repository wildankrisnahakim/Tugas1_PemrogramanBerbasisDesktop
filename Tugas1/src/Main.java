import java.util.Scanner;

class Menu {
    private String nama;
    private double harga;
    private String kategori;

    public Menu(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNama(){
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }
}

public class Main {

    public static void tampilkanMenu(Menu[] daftarMenu) {
        System.out.println("---------------------------------");
        System.out.println("          Menu Restoran          ");
        System.out.println("---------------------------------");

        System.out.println("\n--- Makanan ---");
        if (daftarMenu[0].getKategori().equals("Makanan")) {
            System.out.println("1. " + daftarMenu[0].getNama() + "- Rp." + (int)daftarMenu[0].getHarga());
        }
        if (daftarMenu[1].getKategori().equals("Makanan")) {
            System.out.println("2. " + daftarMenu[1].getNama() + "- Rp." + (int)daftarMenu[1].getHarga());
        }
        if (daftarMenu[2].getKategori().equals("Makanan")) {
            System.out.println("3. " + daftarMenu[2].getNama() + "- Rp." + (int)daftarMenu[2].getHarga());
        }
        if (daftarMenu[3].getKategori().equals("Makanan")) {
            System.out.println("4. " + daftarMenu[3].getNama() + "- Rp." + (int)daftarMenu[3].getHarga());
        }

        System.out.println("\n--- Minuman ---");
        if (daftarMenu[4].getKategori().equals("Minuman")) {
            System.out.println("5. " + daftarMenu[4].getNama() + "- Rp." + (int)daftarMenu[4].getHarga());
        }
        if (daftarMenu[5].getKategori().equals("Minuman")) {
            System.out.println("6. " + daftarMenu[5].getNama() + "- Rp." + (int)daftarMenu[5].getHarga());
        }
        if (daftarMenu[6].getKategori().equals("Minuman")) {
            System.out.println("7. " + daftarMenu[6].getNama() + "- Rp." + (int)daftarMenu[6].getHarga());
        }
        if (daftarMenu[7].getKategori().equals("Minuman")) {
            System.out.println("8. " + daftarMenu[7].getNama() + "- Rp." + (int)daftarMenu[7].getHarga());
        }

        System.out.println("\n---------------------------------");
    }

    public static Menu cariMenu(String namaMenu, Menu[] daftarMenu) {
        if (daftarMenu[0].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[0];
        if (daftarMenu[1].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[1];
        if (daftarMenu[2].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[2];
        if (daftarMenu[3].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[3];
        if (daftarMenu[4].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[4];
        if (daftarMenu[5].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[5];
        if (daftarMenu[6].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[6];
        if (daftarMenu[7].getNama().equalsIgnoreCase(namaMenu)) return daftarMenu[7];
        return null;
    }

    public static void main(String[] args) {
        Menu[] daftarMenu = new Menu[8];
        daftarMenu[0] = new Menu("Nasi Padang", 20000,  "Makanan");
        daftarMenu[1] = new Menu("Nasi Goreng", 18000, "Makanan");
        daftarMenu[2] = new Menu("Soto Banjar", 20000, "Makanan");
        daftarMenu[3] = new Menu("Sate Ayam", 25000, "Makanan");
        daftarMenu[4] = new Menu("Es Teh", 5000, "Minuman");
        daftarMenu[5] = new Menu("Teh Panas", 4000, "Minuman");
        daftarMenu[6] = new Menu("Es Jeruk", 6000, "Minuman");
        daftarMenu[7] = new Menu("Jeruk Panas", 5000, "Minuman");

        tampilkanMenu(daftarMenu);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Silahkan Masukkan Pesanan Anda (Maksimal 4 menu)");
        System.out.println("Contoh format input : Nasi Goreng = 3");
        System.out.println("Tekan Enter jika telah selesai memesan");

        String[] inputPesanan = new String[4];
        Menu[] menuDipesan = new Menu[4];
        int[] jumlahPesanan = new int[4];

        System.out.println("Pesanan 1 : ");
        inputPesanan[0] = scanner.nextLine();

        System.out.println("Pesanan 2 : ");
        inputPesanan[1] = scanner.nextLine();

        System.out.print("\nApakah Anda ingin memesan lagi? (Y/N)");
        String jawaban = scanner.nextLine();

        if (jawaban.equalsIgnoreCase("Y")) {
            System.out.println("Pesanan 3 : ");
            inputPesanan[2] = scanner.nextLine();
            System.out.println("Pesanan 4 : ");
            inputPesanan[3] = scanner.nextLine();
        } else {
            inputPesanan[2] = "";
            inputPesanan[3] = "";
        }

        prosesPesanan(inputPesanan, menuDipesan, jumlahPesanan, daftarMenu);

        hitungDanCetakStruk(menuDipesan, jumlahPesanan);
        scanner.close();
    }

    public static void prosesPesanan(String[] inputPesanan, Menu[] menuDipesan, int[] jumlahPesanan, Menu[] daftarMenu) {
        // Pesanan 1
        if (inputPesanan[0] != null && !inputPesanan[0].isEmpty()) {
            String[] parts = inputPesanan[0].split("=");
            if (parts.length == 2){
                String namaMenu = parts[0].trim();
                int jumlah = Integer.parseInt(parts[1].trim());
                menuDipesan[0] = cariMenu(namaMenu, daftarMenu);
                jumlahPesanan[0] = jumlah;
            }else {
                System.out.println("Format pesanan 1 salah. Gunakan format : Menu = jumlah");
            }
        }

        // Pesanan 2
        if (inputPesanan[1] != null && !inputPesanan[1].isEmpty()) {
            String[] parts = inputPesanan[1].split("=");
            if (parts.length == 2){
                String namaMenu = parts[0].trim();
                int jumlah = Integer.parseInt(parts[1].trim());
                menuDipesan[1] = cariMenu(namaMenu, daftarMenu);
                jumlahPesanan[1] = jumlah;
            }else {
                System.out.println("Format pesanan 2 salah. Gunakan format : Menu = jumlah");
            }
        }

        //Pesanan 3
        if (inputPesanan[2] != null && !inputPesanan[2].isEmpty()) {
            String[] parts = inputPesanan[2].split("=");
            if (parts.length == 2){
                String namaMenu = parts[0].trim();
                int jumlah = Integer.parseInt(parts[1].trim());
                menuDipesan[2] = cariMenu(namaMenu, daftarMenu);
                jumlahPesanan[2] = jumlah;
            }else {
                System.out.println("Format pesanan 3 salah. Gunakan format : Menu = jumlah");
            }
        }

        //Pesanan 4
        if (inputPesanan[3] != null && !inputPesanan[3].isEmpty()) {
            String[] parts = inputPesanan[3].split("=");
            if (parts.length == 2){
                String namaMenu = parts[0].trim();
                int jumlah = Integer.parseInt(parts[1].trim());
                menuDipesan[3] = cariMenu(namaMenu, daftarMenu);
                jumlahPesanan[3] = jumlah;
            }else {
                System.out.println("Format pesanan 4 salah. Gunakan format : Menu = jumlah");
            }
        }
    }

    public static void hitungDanCetakStruk(Menu[] menuDipesan, int[] jumlahPesanan) {
        double totalBiaya = 0;
        double totalItem1 = 0, totalItem2 = 0, totalItem3 = 0, totalItem4 = 0;

        System.out.println("----------------------------------");
        System.out.println("         Struk Pembayaran         ");
        System.out.println("----------------------------------");


        if (menuDipesan[0] != null) {
            totalItem1 = menuDipesan[0].getHarga() * jumlahPesanan[0];
            System.out.printf("%-15s %2d x Rp.%7d = Rp.%7d\n",
                    menuDipesan[0].getNama(), jumlahPesanan[0],
                    (int) menuDipesan[0].getHarga(), (int) totalItem1);
            totalBiaya += totalItem1;
        }
        if (menuDipesan[1] != null) {
            totalItem2 = menuDipesan[1].getHarga() * jumlahPesanan[1];
            System.out.printf("%-15s %2d x Rp.%7d = Rp.%7d\n",
                    menuDipesan[1].getNama(), jumlahPesanan[1],
                    (int) menuDipesan[1].getHarga(), (int) totalItem2);
            totalBiaya += totalItem2;
        }
        if (menuDipesan[2] != null) {
            totalItem3 = menuDipesan[2].getHarga() * jumlahPesanan[2];
            System.out.printf("%-15s %2d x Rp.%7d = Rp.%7d\n",
                    menuDipesan[2].getNama(), jumlahPesanan[2],
                    (int) menuDipesan[2].getHarga(), (int) totalItem3);
            totalBiaya += totalItem3;
        }
        if (menuDipesan[3] != null) {
            totalItem4 = menuDipesan[3].getHarga() * jumlahPesanan[3];
            System.out.printf("%-15s %2d x Rp.%7d = Rp.%7d\n",
                    menuDipesan[3].getNama(), jumlahPesanan[3],
                    (int) menuDipesan[3].getHarga(), (int) totalItem4);
            totalBiaya += totalItem4;
        }

        System.out.println("----------------------------------");


        double diskon = 0;
        if (totalBiaya > 100000) {
            diskon = totalBiaya * 0.10;
        }
        double pajak = (totalBiaya - diskon) * 0.10;
        int layanan = 20000;
        double totalAkhir = totalBiaya - diskon + pajak + layanan;


        System.out.printf("%-25s Rp %10d\n", "Subtotal:", (int) totalBiaya);
        if (diskon > 0) {
            System.out.printf("%-25s -Rp %10d\n", "Diskon (10%):", (int) diskon);
        } else {
            System.out.printf("%-25s Rp %10s\n", "Diskon (10%):", "-");
        }
        System.out.printf("%-25s Rp %10d\n", "Pajak (10%):", (int) pajak);
        System.out.printf("%-25s Rp %10d\n", "Biaya Pelayanan:", (int) layanan);
        System.out.println("----------------------------------");
        System.out.printf("%-25s Rp %10d\n", "Total Bayar:", (int) totalAkhir);
        System.out.println("----------------------------------");

        // Promo Buy1 Get 1 diakhir struk
        if (totalBiaya > 50000) {
            String minumanGratis = "";
            if (menuDipesan[0] != null && menuDipesan[0].getKategori().equals("Minuman")) minumanGratis = menuDipesan[0].getNama();
            else if (menuDipesan[1] != null && menuDipesan[1].getKategori().equals("Minuman")) minumanGratis = menuDipesan[1].getNama();
            else if (menuDipesan[2] != null && menuDipesan[2].getKategori().equals("Minuman")) minumanGratis = menuDipesan[2].getNama();
            else if (menuDipesan[3] != null && menuDipesan[3].getKategori().equals("Minuman")) minumanGratis = menuDipesan[3].getNama();

            System.out.println("\n=== PROMO ===");
            if (!minumanGratis.isEmpty()) {
                System.out.println("Selamat!!! Anda mendapatkan promo Buy 1 Get 1 untuk : " + minumanGratis);
            } else {
                System.out.println("Selamat!!! Anda berhak promo Buy 1 Get 1 untuk pemesanan minuman berikutnya");
            }
        }

        System.out.println("\nTerimakasih atas Kunjungan Anda");
    }

}
