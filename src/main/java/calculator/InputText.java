package calculator;

public class InputText {

    private final String text;

    public InputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean isEmpty() {
        return text == null || text.isEmpty();
    }
}
