import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class PersonRecordTest {

    private PersonRecord person;
    private HashMap<String, String> info;

    @BeforeEach
    void setUp() {
        this.info = this.getNewInfo();
        this.person = new PersonRecord("shubham", info);
    }

    @Test
    void test_contructor() {
        Assertions.assertTrue(this.person.info().equals(this.info));

        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.person.info().equals(this.info));
    }

    @Test
    void test_name() {
        Assertions.assertTrue("shubham" == this.person.name()); // String is immutable
        Assertions.assertEquals("shubham", this.person.name());
    }

    @Test
    void test_attributes() {
        Assertions.assertFalse(this.info == this.person.info());
        Assertions.assertTrue(this.info.equals(this.person.info()));

        HashMap<String, String> info = this.person.info();
        info.put("TestKey", "TestValue");
        Assertions.assertFalse(info == this.person.info());
        Assertions.assertFalse(info.equals(this.person.info()));

        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.info == this.person.info());
        Assertions.assertFalse(this.info.equals(this.person.info()));
    }

    @Test
    void test_equals() {
        PersonRecord personRecord = new PersonRecord("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.equals(personRecord));

        this.info.put("TestKey", "TestValue");
        personRecord = new PersonRecord("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.equals(personRecord));
    }

    @Test
    void test_hashCode() {
        PersonRecord personRecord = new PersonRecord("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.hashCode() == personRecord.hashCode());

        this.info.put("TestKey", "TestValue");
        personRecord = new PersonRecord("shubham", this.getNewInfo());
        Assertions.assertTrue(this.person.hashCode() == personRecord.hashCode());
    }

    @Test
    void test_toString() {
        PersonRecord personRecord = new PersonRecord("shubham", this.getNewInfo());
        System.out.println(this.person.toString());
        Assertions.assertFalse(this.person.toString() == personRecord.toString());
        Assertions.assertTrue(this.person.toString().equals(personRecord.toString()));

        this.info.put("TestKey", "TestValue");
        Assertions.assertFalse(this.person.toString() == personRecord.toString());
        Assertions.assertTrue(this.person.toString().equals(personRecord.toString()));
    }

    private HashMap<String, String> getNewInfo() {
        return new HashMap<>() {{
            put("email", "testEmail");
        }};
    }
}