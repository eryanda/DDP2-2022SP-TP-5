/**
 * Kelas Veggie merepresentasikan produk sayuran.
 */
public class Veggie extends Product {
    // Atribut spesifik untuk kelas Veggie
    private boolean isOrganic; // Merupakan sebuah penanda apakah sayuran tersebut merupakan produk organik atau bukan.

    /**
     * Konstruktor untuk kelas Veggie.
     *
     * @param nama      Nama produk sayuran.
     * @param price     Harga produk sayuran.
     * @param stock     Stok produk sayuran.
     * @param isOrganic Status produk organik atau non-organik.
     */
    public Veggie(String nama, int price, int stock, boolean isOrganic) {
        super(nama, price, stock);
        this.isOrganic = isOrganic;
    }

    /**
     * Memeriksa dan memberikan diskon berdasarkan kuantitas dan status organik atau non-organik.
     *
     * @param quantity Kuantitas pembelian.
     * @return Persentase diskon yang diberikan.
     */
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

    /**
     * Mendapatkan status produk organik atau non-organik.
     *
     * @return True jika produk organik, false jika produk non-organik.
     */
    public boolean isOrganic() {
        return isOrganic;
    }

    /**
     * Mengatur status produk organik atau non-organik.
     *
     * @param organic True jika produk organik, false jika produk non-organik.
     */
    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }
}
