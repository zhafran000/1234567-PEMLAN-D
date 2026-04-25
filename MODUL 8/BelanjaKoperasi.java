// 1. Interface Payable
interface Payable {
    int getPayableAmount();
}

// 2. Class Invoice
class Invoice implements Payable {
    private String productName;
    private Integer quantity;
    private Integer pricePerItem;

    public Invoice(String productName, Integer quantity, Integer pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    public String toString() {
        return String.format("%-15s | %d x %-7d = Rp %d", 
            productName, quantity, pricePerItem, getPayableAmount());
    }
}

// 3. Class Employee
class Employee implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices;

    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    public int getPayableAmount() {
        int totalHutang = 0;
        for (Invoice inv : invoices) {
            if (inv != null) {
                totalHutang += inv.getPayableAmount();
            }
        }
        return salaryPerMonth - totalHutang;
    }

    public void displayInfo() {
        int totalHutang = 0;
        System.out.println("==========================================");
        System.out.println("        LAPORAN GAJI NV. MENEER           ");
        System.out.println("==========================================");
        System.out.println("No. Registrasi : " + registrationNumber);
        System.out.println("Nama Karyawan  : " + name);
        System.out.println("Gaji Bulanan   : Rp " + salaryPerMonth);
        System.out.println("\n--- Detail Belanja Koperasi ---");
        
        for (Invoice inv : invoices) {
            if (inv != null) {
                System.out.println(inv.toString());
                totalHutang += inv.getPayableAmount();
            }
        }
        
        System.out.println("------------------------------------------");
        System.out.println("Total Potongan : Rp " + totalHutang);
        System.out.println("GAJI BERSIH    : Rp " + getPayableAmount());
        System.out.println("==========================================\n");
    }
}

// 4. Main Class
public class Main {
    public static void main(String[] args) {
        // Data belanjaan karyawan yang sudah diganti (Gula, Kopi, dsb)
        Invoice[] listBelanja = {
            new Invoice("Beras 5kg", 2, 75000),
            new Invoice("Minyak Goreng", 1, 35000),
            new Invoice("Gula Pasir", 3, 17000)
        };

        // Membuat objek Employee
        Employee emp = new Employee(202401, "Andi Wijaya", 4500000, listBelanja);

        // Menampilkan hasil
        emp.displayInfo();
    }
}
