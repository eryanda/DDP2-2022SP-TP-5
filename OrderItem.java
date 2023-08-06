public class OrderItem {
    private Product product;
    private int quantity;

    // Konstruktor untuk kelas OrderItem
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

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

    public int getQuantity(){
        return quantity;
    }

    public Product getProduct(){
        return product;
    }

}
