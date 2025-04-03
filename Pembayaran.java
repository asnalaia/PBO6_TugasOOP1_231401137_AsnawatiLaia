import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

class Pembayaran {
    private double totalHarga;
    private String metodePembayaran;
    private String statusPembayaran;
    private double persentaseDiskon;
    private String namaPelanggan;

    public Pembayaran(String namaPelanggan, double totalHarga, String metodePembayaran) {
        this.namaPelanggan = namaPelanggan;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
        this.persentaseDiskon = 0;
        prosesPembayaran();
    }

    public Pembayaran(String namaPelanggan, double totalHarga, String metodePembayaran, double persentaseDiskon) {
        this.namaPelanggan = namaPelanggan;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
        this.persentaseDiskon = persentaseDiskon;
        this.totalHarga = terapkanVoucher();
        prosesPembayaran();
    }

    private void prosesPembayaran() {
        if (metodePembayaran.equalsIgnoreCase("Kartu Kredit")) {
            statusPembayaran = "Pembayaran Berhasil dengan Kartu Kredit";
        } else if (metodePembayaran.equalsIgnoreCase("Transfer Bank")) {
            statusPembayaran = "Pembayaran Berhasil dengan Transfer Bank";
        } else if (metodePembayaran.equalsIgnoreCase("Voucher")) {
            statusPembayaran = "Pembayaran Berhasil dengan Voucher Diskon";
        } else {
            statusPembayaran = "Metode pembayaran tidak valid";
        }
    }

    private double terapkanVoucher() {
        return totalHarga - (totalHarga * persentaseDiskon / 100);
    }

    private String formatRupiah(double jumlah) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setGroupingSeparator('.');
        DecimalFormat formatRupiah = new DecimalFormat("#,###", simbol);
        return "Rp" + formatRupiah.format(jumlah);
    }

    public void tampilkanDetailPembayaran() {
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Total Harga Sebelum Diskon: " + formatRupiah(persentaseDiskon > 0 ? totalHarga / (1 - persentaseDiskon / 100) : totalHarga));
        if (persentaseDiskon > 0) {
            System.out.println("Voucher Diskon: " + persentaseDiskon + "%");
            System.out.println("Total Harga Setelah Diskon: " + formatRupiah(totalHarga));
        }
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("Status Pembayaran: " + statusPembayaran);
    }
}