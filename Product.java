abstract class Product {
    // Attributes
    protected String nama; // Merupakan nama produk
    protected int price; // Merupakan harga produk
    protected int stock; // Merupakan jumlah stok dari produk (dalam satuan kg)

    // Constructor
    public Product(String nama, int price, int stock) {
        this.nama = nama;
        this.price = price;
        this.stock = stock;
    }

    // Abstract method to calculate discount
    public abstract int checkDiscount(int quantity);

    // Getters and Setters
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
