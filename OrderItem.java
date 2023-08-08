/**
 * Kelas OrderItem merepresentasikan item dalam keranjang belanja.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    /**
     * Konstruktor untuk kelas OrderItem.
     *
     * @param product  Produk yang dibeli.
     * @param quantity Kuantitas produk yang dibeli.
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Menghitung harga akhir (final price) dari OrderItem setelah diperhitungkan diskon.
     *
     * @return Harga akhir setelah diskon.
     */
    // Method untuk menghitung harga akhir (final price) dari OrderItem
    public int getFinalPrice() {
        // Menghitung harga produk sebelum diskon
        int originalPrice = product.getPrice() * quantity;

        // Mengambil diskon dari kelas produk terkait
        int discount = product.checkDiscount(quantity);

        // Menghitung harga setelah diskon
        int discountedPrice = originalPrice - (originalPrice * discount / 100);

        return discountedPrice;
    }

    /**
     * Mendapatkan kuantitas produk yang dibeli.
     *
     * @return Kuantitas produk yang dibeli.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Mendapatkan objek produk yang dibeli.
     *
     * @return Objek produk yang dibeli.
     */
    public Product getProduct() {
        return product;
    }
}
