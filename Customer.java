/**
 * Representasi dari seorang pelanggan (customer) yang dapat melakukan pembelian.
 */
public class Customer {
    private String name; // Nama dari customer
    private boolean isPremium; // Penanda apakah customer merupakan premium member

    /**
     * Konstruktor untuk membuat objek Customer.
     *
     * @param name Nama dari customer.
     * @param isPremium Status apakah customer merupakan premium member.
     */
    public Customer(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    /**
     * Mendapatkan nama dari customer.
     *
     * @return Nama dari customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengubah nama dari customer.
     *
     * @param name Nama baru untuk customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mengecek apakah customer merupakan premium member.
     *
     * @return True jika customer merupakan premium member, false jika tidak.
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Mengatur status premium member dari customer.
     *
     * @param premium True jika ingin menjadikan customer sebagai premium member, false jika sebaliknya.
     */
    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    /**
     * Menghitung total harga belanja customer dengan mempertimbangkan diskon premium.
     *
     * @param items Array dari OrderItem yang dibeli oleh customer.
     * @return Total harga belanja setelah mempertimbangkan diskon premium.
     */
    public int calculateTotalPrice(OrderItem[] items) {
        int totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getFinalPrice();
        }

        // Jika customer merupakan premium member dan total harga belanja minimal Rp300.000,00
        if (isPremium && totalPrice >= 300000) {
            int discount = (totalPrice * 10) / 100; // Hitung diskon 10%
            totalPrice -= discount; // Kurangi total harga dengan diskon
        }

        return totalPrice;
    }

    /**
     * Representasi dalam bentuk string dari objek Customer.
     *
     * @return String yang merepresentasikan objek Customer.
     */
    @Override
    public String toString() {
        return "Customer [name=" + name + ", isPremium=" + isPremium + "]";
    }
}
