abstract class Kue {
    String nama;
    double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();
    public String toString() {
        return "Nama Kue: " + nama + ", Harga: " + harga;
    }
}

class KuePesanan extends Kue {
    double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double hitungHarga() {
        return harga * berat;
    }

    public double getBerat() {
        return berat;
    }
}

class KueJadi extends Kue {
    double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    public double getJumlah() {
        return jumlah;
    }
}

public class MainKue {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Lumpur", 10000, 2);
        daftarKue[1] = new KueJadi("Donat", 2000, 5);
        daftarKue[2] = new KuePesanan("Brownies Coklat", 15000, 1.5);
        daftarKue[3] = new KueJadi("Klepon", 1000, 10);
        daftarKue[4] = new KuePesanan("Bolu", 12000, 2.5);
        daftarKue[5] = new KueJadi("Risoles", 1500, 8);
        daftarKue[6] = new KuePesanan("Tart", 20000, 1);
        daftarKue[7] = new KueJadi("Onde-onde", 1200, 7);
        daftarKue[8] = new KuePesanan("Redvelvet", 25000, 1.2);
        daftarKue[9] = new KueJadi("Pastel", 1300, 9);
        daftarKue[10] = new KuePesanan("Cupcake", 8000, 3);
        daftarKue[11] = new KueJadi("Lumpia", 2000, 6);
        daftarKue[12] = new KuePesanan("Pie", 9000, 2);
        daftarKue[13] = new KueJadi("Bakpia", 1000, 12);
        daftarKue[14] = new KuePesanan("Muffin", 7000, 2.3);
        daftarKue[15] = new KueJadi("Serabi", 1500, 5);
        daftarKue[16] = new KuePesanan("Pancake", 6000, 1.8);
        daftarKue[17] = new KueJadi("Nagasari", 1700, 4);
        daftarKue[18] = new KuePesanan("Waffle", 11000, 2.1);
        daftarKue[19] = new KueJadi("Putu", 1400, 6);

        double totalHarga = 0;
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;

        Kue kueTermahal = daftarKue[0];

        System.out.println("=== DAFTAR KUE ===");

        for (Kue k : daftarKue) {
            System.out.println(k.toString());
            System.out.println("Jenis: " + k.getClass().getSimpleName());
            System.out.println("Harga Akhir: " + k.hitungHarga());
            System.out.println("---------------------------");

            totalHarga += k.hitungHarga();

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalHargaPesanan += kp.hitungHarga();
                totalBeratPesanan += kp.getBerat();
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalHargaJadi += kj.hitungHarga();
                totalJumlahJadi += kj.getJumlah();
            }

            if (k.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\n=== HASIL ===");
        System.out.println("Total Semua Harga: " + totalHarga);
        System.out.println("Total Harga KuePesanan: " + totalHargaPesanan);
        System.out.println("Total Berat KuePesanan: " + totalBeratPesanan);
        System.out.println("Total Harga KueJadi: " + totalHargaJadi);
        System.out.println("Total Jumlah KueJadi: " + totalJumlahJadi);

        System.out.println("\nKue Termahal:");
        System.out.println(kueTermahal.toString());
        System.out.println("Harga Akhir: " + kueTermahal.hitungHarga());
    }
}
