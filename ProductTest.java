import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testGetNama() {
        Product product = new Fruit("Mangga", 8000, 10, false);
        assertEquals("Mangga", product.getNama());
    }

    @Test
    public void testSetNama() {
        Product product = new Veggie("Brokoli", 12000, 10, true);
        product.setNama("Kubis");
        assertEquals("Kubis", product.getNama());
    }

    @Test
    public void testGetPrice() {
        Product product = new Fruit("Apel", 5000, 10, true);
        assertEquals(5000, product.getPrice());
    }

    @Test
    public void testSetPrice() {
        Product product = new Veggie("Bayam", 6000, 10, false);
        product.setPrice(7000);
        assertEquals(7000, product.getPrice());
    }

    @Test
    public void testGetStock() {
        Product product = new Fruit("Jeruk", 4000, 10, false);
        assertEquals(10, product.getStock());
    }

    @Test
    public void testSetStock() {
        Product product = new Veggie("Wortel", 3000, 10, true);
        product.setStock(8);
        assertEquals(8, product.getStock());
    }
}
