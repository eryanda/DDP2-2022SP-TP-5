import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeggieTest {

    @Test
    public void testCheckDiscountOrganicQuantity5() {
        Veggie veggie = new Veggie("Brokoli", 12000, 10, true);
        int discount = veggie.checkDiscount(5);
        assertEquals(20, discount);
    }

    @Test
    public void testCheckDiscountOrganicQuantity3() {
        Veggie veggie = new Veggie("Brokoli", 12000, 10, true);
        int discount = veggie.checkDiscount(3);
        assertEquals(10, discount);
    }

    @Test
    public void testCheckDiscountNonOrganicQuantity5() {
        Veggie veggie = new Veggie("Wortel", 8000, 10, false);
        int discount = veggie.checkDiscount(5);
        assertEquals(25, discount);
    }

    @Test
    public void testCheckDiscountNonOrganicQuantity3() {
        Veggie veggie = new Veggie("Wortel", 8000, 10, false);
        int discount = veggie.checkDiscount(3);
        assertEquals(20, discount);
    }

    @Test
    public void testCheckDiscountLowQuantity() {
        Veggie veggie = new Veggie("Brokoli", 12000, 10, true);
        int discount = veggie.checkDiscount(2);
        assertEquals(0, discount);
    }

    @Test
    public void testIsOrganicTrue() {
        Veggie veggie = new Veggie("Brokoli", 12000, 10, true);
        assertTrue(veggie.isOrganic());
    }

    @Test
    public void testIsOrganicFalse() {
        Veggie veggie = new Veggie("Wortel", 8000, 10, false);
        assertFalse(veggie.isOrganic());
    }

    @Test
    public void testSetOrganic() {
        Veggie veggie = new Veggie("Brokoli", 12000, 10, true);
        veggie.setOrganic(false);
        assertFalse(veggie.isOrganic());
    }
}
