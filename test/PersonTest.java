import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p1;

    @BeforeEach
    void setUp() {
        p1 = new Person("first1", "last1", "000001", "Mr.", 2000);

    }

    @Test
    void setFirstName() {
        p1.setFirstName("John");
        assertEquals("John", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    void setId() {
        p1.setId("000002");
        assertEquals("000002", p1.getId());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mrs.");
        assertEquals("Mrs.", p1.getTitle());
    }

    @Test
    void setYob() {
        p1.setYob(2001);
        assertEquals(2001, p1.getYob());
    }


    @Test
    void fullName() {
        assertEquals("first1 last1", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. first1 last1", p1.formalName());
    }

    @Test
    void getAge() {
        assertEquals("22", p1.getAge());
    }



    @Test
    void toCSVDataRecord() {
        assertEquals("000001,first1,last1,Mr.,2000", p1.toCSVDataRecord());
    }
}