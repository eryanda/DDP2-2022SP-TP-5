public class Customer {
    private String name; // Nama dari customer
    private boolean isPremium; // Penanda apakah customer merupakan premium member

    // Konstruktor untuk kelas Customer
    public Customer(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    // Getter dan Setter untuk atribut name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk atribut isPremium
    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    // Method untuk menghitung total harga belanja customer dengan mempertimbangkan diskon premium
    public int calculateTotalPrice(OrderItem[] items) {
        int totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getFinalPrice();
        }

        // Jika customer merupakan premium member dan total harga belanja >= Rp300.000,00
        if (isPremium && totalPrice >= 300000) {
            int discount = (totalPrice * 10) / 100; // Hitung diskon 10%
            totalPrice -= discount; // Kurangi total harga dengan diskon
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", isPremium=" + isPremium + "]";
    }
}
