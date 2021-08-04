package lotto.step1;

public class Validation {
    private String text;

    public Validation(String text) {
        this.text = text;
    }
    public boolean checkEmptyAndNull() {
        if (text.equals("") || text.equals(" ") || text.isEmpty() || text == null) {
            return true;
        }
        return false;
    }

    public boolean checkOnlyNumber() {
        return text.matches("[0-9]");
    }

}
