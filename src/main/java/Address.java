import java.util.Objects;

public class Address {
    private String line;

    public Address(final String line) {
        this.line = line;
    }

    @Override
    protected Address clone() {
        return new Address(this.line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(line, address.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
