import java.util.HashMap;

public record PersonRecord(String name, HashMap<String, String> info) {

    public PersonRecord(String name, HashMap<String, String> info) {
        this.name = name; // String is immutable for security & concurrency.
        this.info = new HashMap<>(info);
    }

    @Override
    public HashMap<String, String> info() {
        return new HashMap<>(info);
    }
}