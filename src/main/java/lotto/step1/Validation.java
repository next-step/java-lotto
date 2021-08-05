package lotto.step1;


public class Validation {
    private final String text;

    public Validation(String text) {
        this.text = text;
    }

    public boolean checkEmptyAndNull() {
        return text.isEmpty() || text == null;
    }

    public boolean checkOnlyNumber() {
        return text.matches("[0-9]");
    }

}
