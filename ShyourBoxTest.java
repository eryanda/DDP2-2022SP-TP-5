import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShyourBoxTest {


    @Test
    public void testFindCustomerNotFound() {
        ShyourBox shyourBox = new ShyourBox();
        shyourBox.addCustomer("input/daftarCustomer.txt");
        Customer customer = shyourBox.findCustomer("Basyira Artoprawiro");
        assertNull(customer);
    }

    @Test
    public void testSearchProductNotFound() {
        ShyourBox shyourBox = new ShyourBox();
        shyourBox.addProduct("input/daftarProduk.txt");
        Product product = shyourBox.searchProduct("Mangga", 1);
        assertNull(product);
    }

    // Unit tests for other methods can be added similarly.
}
