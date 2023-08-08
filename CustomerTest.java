import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCalculateTotalPriceNoPremium() {
        Customer customer = new Customer("John Doe", false);

        Product product1 = new Fruit("Mangga", 8000, 10, false);
        OrderItem orderItem1 = new OrderItem(product1, 2);

        Product product2 = new Veggie("Brokoli", 12000, 10, true);
        OrderItem orderItem2 = new OrderItem(product2, 3);

        OrderItem[] items = {orderItem1, orderItem2};

        int totalPrice = customer.calculateTotalPrice(items);
        assertEquals(48400, totalPrice);
    }

    @Test
    public void testCalculateTotalPricePremiumDiscount() {
        Customer customer = new Customer("Alice Johnson", true);

        Product product1 = new Fruit("Apel", 5000, 10, true);
        OrderItem orderItem1 = new OrderItem(product1, 4);

        Product product2 = new Veggie("Bayam", 6000, 10, false);
        OrderItem orderItem2 = new OrderItem(product2, 5);

        OrderItem[] items = {orderItem1, orderItem2};

        int totalPrice = customer.calculateTotalPrice(items);
        assertEquals(38500, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceNoDiscount() {
        Customer customer = new Customer("Bob Brown", true);

        Product product1 = new Fruit("Jeruk", 4000, 10, false);
        OrderItem orderItem1 = new OrderItem(product1, 3);

        Product product2 = new Veggie("Wortel", 3000, 10, true);
        OrderItem orderItem2 = new OrderItem(product2, 4);

        OrderItem[] items = {orderItem1, orderItem2};

        int totalPrice = customer.calculateTotalPrice(items);
        assertEquals(21000, totalPrice);
    }
}
