public class Veggie extends Product {
    // Atribut spesifik untuk kelas Veggie
    private boolean isOrganic; // Merupakan sebuah penanda apakah sayuran tersebut merupakan produk organik atau bukan.

    // Konstruktor untuk kelas Veggie
    public Veggie(String nama, int price, int stock, boolean isOrganic) {
        super(nama, price, stock);
        this.isOrganic = isOrganic;
    }

    // Method untuk memeriksa dan memberikan diskon berdasarkan kuantitas dan status organik atau non-organik
    @Override
    public int checkDiscount(int quantity) {
        if (isOrganic) {
            if (quantity >= 5) {
                return 20; // Diskon 20% untuk pembelian sayuran organik minimal 5 kg
            } else if (quantity >= 3) {
                return 10; // Diskon 10% untuk pembelian sayuran organik minimal 3 kg
            }
        } else {
            if (quantity >= 5) {
                return 25; // Diskon 25% untuk pembelian sayuran non-organik minimal 5 kg
            } else if (quantity >= 3) {
                return 20; // Diskon 20% untuk pembelian sayuran non-organik minimal 3 kg
            }
        }
        return 0; // Tidak ada diskon jika kuantitas tidak mencukupi
    }

    // Getter dan Setter untuk atribut isOrganic
    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }
}
