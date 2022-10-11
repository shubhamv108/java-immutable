import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonImmutableTest {

    private PersonImmutable person;
    private HashMap<String, String> info;

    @BeforeEach
    void setUp() {
        this.info = this.getNewInfo();
        this.person = new PersonImmutable("shubham", info);
    }

    @Test
    void test_contructor() {
        Assertions.assertTrue(this.person.getInfo().equals(this.info));

        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.person.getInfo().equals(this.info));
    }

    @Test
    void test_name() {
        Assertions.assertTrue("shubham" == this.person.getName()); // String is immutable
        Assertions.assertEquals("shubham", this.person.getName());
    }

    @Test
    void test_attributes() {
        Assertions.assertFalse(this.info == this.person.getInfo());
        Assertions.assertTrue(this.info.equals(this.person.getInfo()));

        HashMap<String, String> info = this.person.getInfo();
        info.put("TestKey", "TestValue");
        Assertions.assertFalse(info == this.person.getInfo());
        Assertions.assertFalse(info.equals(this.person.getInfo()));


        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.info == this.person.getInfo());
        Assertions.assertFalse(this.info.equals(this.person.getInfo()));
    }

    @Test
    void test_equals() {
        PersonImmutable personImmutable = new PersonImmutable("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.equals(personImmutable));

        this.info.put("TestKey", "TestValue");
        personImmutable = new PersonImmutable("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.equals(personImmutable));
    }

    @Test
    void test_hashCode() {
        PersonImmutable personImmutable = new PersonImmutable("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.hashCode() == personImmutable.hashCode());

        this.info.put("TestKey", "TestValue");
        personImmutable = new PersonImmutable("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.hashCode() == personImmutable.hashCode());
    }

    @Test
    void test_toString() {
        PersonImmutable personImmutable = new PersonImmutable("shubham", this.getNewInfo());
        System.out.println(this.person.toString());
        Assertions.assertFalse(this.person.toString() == personImmutable.toString());
        Assertions.assertTrue(this.person.toString().equals(personImmutable.toString()));

        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.person.toString() == personImmutable.toString());
        Assertions.assertTrue(this.person.toString().equals(personImmutable.toString()));
    }

    private HashMap<String, String> getNewInfo() {
        return new HashMap<>() {{
            put("email", "testEmail");
        }};
    }
}