package step1;

public class UserInput {

    private final String item;

    public UserInput(String item) {
        this.item = item;
    }

    public boolean isNullOrEmpty() {
        return this.item == null || this.item.isEmpty();
    }
}
