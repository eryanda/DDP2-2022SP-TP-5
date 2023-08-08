import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testGetFinalPriceNoDiscount() {
        Product product = new Fruit("Jeruk", 5000, 10, true);
        OrderItem orderItem = new OrderItem(product, 2);
        int finalPrice = orderItem.getFinalPrice();
        assertEquals(10000, finalPrice);
    }

    @Test
    public void testGetFinalPriceWithDiscount() {
        Product product = new Veggie("Brokoli", 12000, 10, true);
        OrderItem orderItem = new OrderItem(product, 5);
        int finalPrice = orderItem.getFinalPrice();
        assertEquals(48000, finalPrice);
    }

    @Test
    public void testGetQuantity() {
        Product product = new Fruit("Mangga", 8000, 10, false);
        OrderItem orderItem = new OrderItem(product, 3);
        int quantity = orderItem.getQuantity();
        assertEquals(3, quantity);
    }

    @Test
    public void testGetProduct() {
        Product product = new Veggie("Bayam", 6000, 10, false);
        OrderItem orderItem = new OrderItem(product, 2);
        Product retrievedProduct = orderItem.getProduct();
        assertEquals(product, retrievedProduct);
    }
}
