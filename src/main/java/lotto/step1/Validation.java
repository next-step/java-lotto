package lotto.step1;

public class Validation {

    private String text;

    public Validation(String text) {
        this.text = text;
    }

    public boolean checkEmptyAndNull() {
        if (text.equals("") || text.equals(" ") || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
