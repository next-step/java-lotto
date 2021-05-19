package study;

public class Splitter {
    private final String input;

    public Splitter(String input) {
        this.input = input;
    }

    public boolean isUsable() {
        return !isNull() && !isEmpty();
    }

    private boolean isEmpty() {
        return input.isEmpty();
    }

    private boolean isNull() {
        return input == null;
    }
}
