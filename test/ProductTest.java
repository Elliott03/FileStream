import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1;
    // name desc id cost
    @BeforeEach
    void setUp() {
        p1 = new Product("Table", "Its a table", "000001", 100.0);
    }


    @Test
    void setName() {
        p1.setName("Chair");
        assertEquals("Chair", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Its a Chair");
        assertEquals("Its a Chair", p1.getDescription());
    }

    @Test
    void setId() {
        p1.setId("000002");
        assertEquals("000002", p1.getId());
    }

    @Test
    void setCost() {
        p1.setCost(101);
        assertEquals(101, p1.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001,Table,Its a table,100.0", p1.toCSVDataRecord());
    }
}