public class Main {
    public static void main(String[] args) {
        Pembayaran siti = new Pembayaran("Siti", 3500000, "Kartu Kredit");
        siti.tampilkanDetailPembayaran();

        System.out.println();

        Pembayaran ciciripi = new Pembayaran("Ciciripi", 10000000, "Voucher", 15);
        ciciripi.tampilkanDetailPembayaran();

        System.out.println();

        Pembayaran asnawi = new Pembayaran("Asnawi", 1200000, "Transfer Bank");
        asnawi.tampilkanDetailPembayaran();
    }
}