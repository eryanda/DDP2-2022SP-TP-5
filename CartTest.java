import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void testAddOrderItem() {
        Customer customer = new Customer("John Doe", true);
        Cart cart = new Cart(customer);

        Product product = new Fruit("Mangga", 8000, 10, false);
        OrderItem orderItem = new OrderItem(product, 2);

        cart.addOrderItem(orderItem);
        assertEquals(1, cart.getOrderList().size());
    }

    @Test
    public void testGetTotalPriceNoDiscount() {
        Customer customer = new Customer("Jane Smith", false);
        Cart cart = new Cart(customer);

        Product product1 = new Veggie("Brokoli", 12000, 10, true);
        OrderItem orderItem1 = new OrderItem(product1, 3);

        Product product2 = new Fruit("Anggur", 15000, 10, false);
        OrderItem orderItem2 = new OrderItem(product2, 2);

        cart.addOrderItem(orderItem1);
        cart.addOrderItem(orderItem2);

        int totalPrice = cart.getTotalPrice();
        assertEquals(62400, totalPrice);
    }

    @Test
    public void testCalculateTotalPricePremiumDiscount() {
        Customer customer = new Customer("Alice Johnson", true);
        Cart cart = new Cart(customer);

        Product product1 = new Fruit("Jeruk", 5000, 10, true);
        OrderItem orderItem1 = new OrderItem(product1, 4);

        Product product2 = new Veggie("Bayam", 6000, 10, false);
        OrderItem orderItem2 = new OrderItem(product2, 5);

        cart.addOrderItem(orderItem1);
        cart.addOrderItem(orderItem2);

        int totalPrice = cart.calculateTotalPrice();
        assertEquals(38500, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceNoDiscount() {
        Customer customer = new Customer("Bob Brown", false);
        Cart cart = new Cart(customer);

        Product product1 = new Fruit("Apel", 4000, 10, true);
        OrderItem orderItem1 = new OrderItem(product1, 3);

        Product product2 = new Veggie("Wortel", 3000, 10, true);
        OrderItem orderItem2 = new OrderItem(product2, 4);

        cart.addOrderItem(orderItem1);
        cart.addOrderItem(orderItem2);

        int totalPrice = cart.calculateTotalPrice();
        assertEquals(20400, totalPrice);
    }
}
