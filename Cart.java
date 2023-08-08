import java.util.ArrayList;
import java.util.List;

/**
 * Representasi dari keranjang belanja yang berisi daftar order item.
 */
public class Cart {
    private Customer customer; // Customer pemilik keranjang
    private ArrayList<OrderItem> orderList; // Daftar order pada keranjang

    /**
     * Konstruktor untuk membuat objek Cart.
     *
     * @param customer Pemilik keranjang.
     */
    public Cart(Customer customer) {
        this.customer = customer;
        this.orderList = new ArrayList<>();
    }

    /**
     * Menambahkan OrderItem ke dalam keranjang.
     *
     * @param orderItem OrderItem yang akan ditambahkan.
     */
    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    /**
     * Menghitung total harga seluruh order pada keranjang sebelum diskon.
     *
     * @return Total harga sebelum diskon.
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem item : orderList) {
            totalPrice += item.getFinalPrice();
        }
        return totalPrice;
    }

    /**
     * Mendapatkan daftar order pada keranjang.
     *
     * @return Daftar order pada keranjang.
     */
    public List<OrderItem> getOrderList() {
        return orderList;
    }

    /**
     * Mendapatkan customer pemilik keranjang.
     *
     * @return Customer pemilik keranjang.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Menghitung total harga seluruh order pada keranjang setelah diskon.
     * Jika customer merupakan premium member dan total harga belanja >= Rp300.000,00,
     * maka akan diberikan diskon 10%.
     *
     * @return Total harga setelah diskon.
     */
    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getFinalPrice();
        }

        if (customer.isPremium() && totalPrice >= 300000) {
            int discount = (totalPrice * 10) / 100; // Hitung diskon 10%
            totalPrice -= discount; // Kurangi total harga dengan diskon
        }

        return totalPrice;
    }
}
