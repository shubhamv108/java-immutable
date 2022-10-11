```
public final class PersonImmutable {

    private final String name;
    private final HashMap<String, String> info;

    public PersonImmutable(String name, HashMap<String, String> info) {
        this.name = name; // String is immutable for security & concurrency.
        this.info = new HashMap<>(info);
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getInfo() {
        return new HashMap<>(info);
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
```

<br/>
<br/>
<br/>

```
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
```