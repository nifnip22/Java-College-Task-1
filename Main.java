import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int harga_A = 500000;
        int harga_B = 400000;
        int harga_C = 300000;

        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("--------------------------------------------\n");
            System.out.printf("                  LIST BARANG               \n");
            System.out.printf("--------------------------------------------\n");
            System.out.printf("| Kode Barang | Nama Barang | Harga Satuan |\n");
            System.out.printf("--------------------------------------------\n");

            System.out.printf("|      A      | Levis       | Rp. 500.000  |\n");
            System.out.printf("|      B      | LEA         | Rp. 400.000  |\n");
            System.out.printf("|      C      | LEE         | Rp. 300.000  |\n");

            System.out.printf("--------------------------------------------\n");
            System.out.println("");

            System.out.print("Masukkan Kode Barang : ");
            String kodeBarang = input.nextLine().trim().toUpperCase();
            System.out.println("");

            System.out.print("Masukkan Quantity atau Jumlah Barang : ");
            int quantity = input.nextInt();
            System.out.println("");

            switch (kodeBarang) {
                case "A":
                    cetakDetail(kodeBarang, "Levis", harga_A, quantity);
                    break;
                case "B":
                    cetakDetail(kodeBarang, "LEA", harga_B, quantity);
                    break;
                case "C":
                    cetakDetail(kodeBarang, "LEE", harga_C, quantity);
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

    public static void cetakDetail(String kode, String nama, int harga, int quantity) {
        int totalHarga = harga * quantity;
        System.out.printf("|-----------------------------------------------|\n");
        System.out.printf("|            DETAIL SETELAH PERHITUNGAN         |\n");
        System.out.printf("|-----------------------------------------------|\n");
        System.out.printf("| %-30s : %-12s |\n", "Kode Barang (Nama Barang)", kode + " (" + nama + ")");
        System.out.printf("| %-30s : %-12s |\n", "Harga Satuan Barang", "Rp. " + String.format("%,d", harga));
        System.out.printf("| %-30s : %-12d |\n", "Quantity yang diinputkan", quantity);
        System.out.printf("|-----------------------------------------------|\n");
        System.out.printf("  %-30s : %-12s  \n", "Total Harga Barang", "Rp. " + String.format("%,d", totalHarga));
        System.out.printf("|-----------------------------------------------|\n");
        System.out.println("");
    }
}