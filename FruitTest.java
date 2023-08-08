import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {

    @Test
    public void testCheckDiscountLocalQuantity5() {
        Fruit fruit = new Fruit("Apel", 10000, 10, true);
        int discount = fruit.checkDiscount(5);
        assertEquals(30, discount);
    }

    @Test
    public void testCheckDiscountLocalQuantity3() {
        Fruit fruit = new Fruit("Apel", 10000, 10, true);
        int discount = fruit.checkDiscount(3);
        assertEquals(20, discount);
    }

    @Test
    public void testCheckDiscountImportedQuantity5() {
        Fruit fruit = new Fruit("Mango", 15000, 10, false);
        int discount = fruit.checkDiscount(5);
        assertEquals(20, discount);
    }

    @Test
    public void testCheckDiscountImportedQuantity3() {
        Fruit fruit = new Fruit("Mango", 15000, 10, false);
        int discount = fruit.checkDiscount(3);
        assertEquals(15, discount);
    }

    @Test
    public void testCheckDiscountLowQuantity() {
        Fruit fruit = new Fruit("Apel", 10000, 10, true);
        int discount = fruit.checkDiscount(2);
        assertEquals(0, discount);
    }

    @Test
    public void testIsLocalTrue() {
        Fruit fruit = new Fruit("Apel", 10000, 10, true);
        assertTrue(fruit.isLocal());
    }

    @Test
    public void testIsLocalFalse() {
        Fruit fruit = new Fruit("Mango", 15000, 10, false);
        assertFalse(fruit.isLocal());
    }

    @Test
    public void testSetLocal() {
        Fruit fruit = new Fruit("Apel", 10000, 10, true);
        fruit.setLocal(false);
        assertFalse(fruit.isLocal());
    }
}
