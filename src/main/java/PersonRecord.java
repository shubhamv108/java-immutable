import java.util.HashMap;

public record PersonRecord(String name, HashMap<String, String> info, Address address) {

    public PersonRecord(final String name, final HashMap<String, String> info, final Address address) {
        this.name = name; // String is immutable for security & concurrency.
        this.info = new HashMap<>(info);
        this.address = address;
    }

    @Override
    public HashMap<String, String> info() {
        return new HashMap<>(info);
    }

    public Address address() {
        return this.address.clone();
    }
}