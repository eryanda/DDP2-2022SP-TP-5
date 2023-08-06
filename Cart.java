import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer customer; // Customer pemilik keranjang
    private ArrayList<OrderItem> orderList; // Daftar order pada keranjang

    // Konstruktor untuk kelas Cart
    public Cart(Customer customer) {
        this.customer = customer;
        this.orderList = new ArrayList<>();
    }

    // Method untuk menambahkan OrderItem ke dalam keranjang
    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    // Method untuk menghitung total harga seluruh order pada keranjang
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem item : orderList) {
            totalPrice += item.getFinalPrice();
        }

        return totalPrice;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public Customer getCustomer(){
        return customer;
    }
}
