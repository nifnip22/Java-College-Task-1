import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float harga_A = 500000;
        float harga_B = 400000;
        float harga_C = 300000;

        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("------------------------------------------------\n");
            System.out.printf("                    LIST PRODUK                 \n");
            System.out.printf("------------------------------------------------\n");
            System.out.printf("| Kode Produk |   Nama Produk   | Harga Satuan |\n");
            System.out.printf("------------------------------------------------\n");

            System.out.printf("|      A      | Levis           | Rp. 500.000  |\n");
            System.out.printf("|      B      | Uniqlo          | Rp. 400.000  |\n");
            System.out.printf("|      C      | 3second         | Rp. 300.000  |\n");

            System.out.printf("------------------------------------------------\n");
            System.out.println("");

            System.out.print("Masukkan Kode Barang : ");
            String kodeBarang = input.nextLine().trim().toUpperCase();
            System.out.println("");

            switch (kodeBarang) {
                case "A":
                    cetakDetail(kodeBarang, "Levis", harga_A, input);
                    break;
                case "B":
                    cetakDetail(kodeBarang, "Uniqlo", harga_B, input);
                    break;
                case "C":
                    cetakDetail(kodeBarang, "3second", harga_C, input);
                    break;
                default:
                    System.out.println("Kode Barang Tidak Ditemukan, Silahkan Coba Lagi!");
                    System.out.println("");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cetakDetail(String kode, String nama, float harga, Scanner input) {
        try {
            System.out.print("Masukkan Quantity atau Jumlah Barang : ");
            int quantity = input.nextInt();
            input.nextLine();
            System.out.println("");

            float totalHarga = harga * quantity;
            String discountDisplay = "0%";
            float discount = 0, jumlahBiaya = totalHarga;

            if (totalHarga >= 1000000) {
                discountDisplay = "20%";
                discount = totalHarga * 20 / 100;
                jumlahBiaya = totalHarga - discount;
            } else if (totalHarga >= 500000) {
                discountDisplay = "10%";
                discount = totalHarga * 10 / 100;
                jumlahBiaya = totalHarga - discount;
            }

            System.out.printf("-----------------------------------------------\n");
            System.out.printf("            DETAIL SETELAH PERHITUNGAN         \n");
            System.out.printf("-----------------------------------------------\n");
            System.out.printf("  %-30s : %-12s  \n", "Kode Produk (Nama Produk)", kode + " (" + nama + ")");
            System.out.printf("  %-30s : %-12s  \n", "Harga Satuan Produk", "Rp. " + String.format("%,.2f", harga));
            System.out.printf("  %-30s : %-12d  \n", "Quantity yang diinputkan", quantity);
            System.out.printf("-----------------------------------------------\n");
            System.out.printf("  %-30s : %-12s  \n", "Total Harga Produk", "Rp. " + String.format("%,.2f", totalHarga));
            System.out.printf("  %-30s : %-12s  \n", "Discount", discountDisplay);
            System.out.printf("  %-30s : %-12s  \n", "Jumlah Biaya Setelah Diskon",
                    "Rp. " + String.format("%,.2f", jumlahBiaya));
            System.out.printf("-----------------------------------------------\n");
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            input.nextLine();
        }

    }
}