/**
 * Kelas abstrak yang merepresentasikan sebuah produk yang dapat dibeli.
 */
public abstract class Product {
    // Atribut
    protected String nama; // Nama produk
    protected int price; // Harga produk
    protected int stock; // Jumlah stok produk (dalam kg)

    /**
     * Konstruktor untuk membuat objek Product.
     *
     * @param nama Nama produk.
     * @param price Harga produk.
     * @param stock Jumlah stok produk (dalam kg).
     */
    public Product(String nama, int price, int stock) {
        this.nama = nama;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Metode abstrak untuk menghitung diskon produk.
     *
     * @param quantity Jumlah produk yang dibeli.
     * @return Persentase diskon berdasarkan jumlah pembelian.
     */
    public abstract int checkDiscount(int quantity);

    /**
     * Mendapatkan nama produk.
     *
     * @return Nama produk.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengatur nama produk.
     *
     * @param nama Nama baru untuk produk.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mendapatkan harga produk.
     *
     * @return Harga produk.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Mengatur harga produk.
     *
     * @param price Harga baru untuk produk.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Mendapatkan jumlah stok produk.
     *
     * @return Jumlah stok produk.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Mengatur jumlah stok produk.
     *
     * @param stock Jumlah stok baru untuk produk.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
