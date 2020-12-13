package calculator;

public class InputText {
    private final String text;

    public InputText(String text) {
        this.text = text;
    }

    public boolean isEmpty() {
        return text == null || text.isEmpty();
    }

    @Override
    public String toString() {
        return this.text;
    }
}
