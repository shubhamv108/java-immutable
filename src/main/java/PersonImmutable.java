import java.util.HashMap;
import java.util.Objects;

public final class PersonImmutable {

    private final String name;
    private final HashMap<String, String> info;

    private final Address address;

    public PersonImmutable(final String name, final HashMap<String, String> info, final Address address) {
        this.name = name; // String is immutable for security & concurrency.
        this.info = new HashMap<>(info);
        this.address = address.clone();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getInfo() {
        return new HashMap<>(info);
    }

    public Address getAddress() {
        return this.address.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PersonImmutable))
            return false;
        PersonImmutable person = (PersonImmutable) o;
        return Objects.equals(name, person.name) &&
               Objects.equals(info, person.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    @Override
    public String toString() {
        return "PersonImmutable[" +
                "name=" + name + ", " +
                "info=" + info + ']';
    }
}
