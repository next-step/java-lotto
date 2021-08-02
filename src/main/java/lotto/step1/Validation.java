package lotto.step1;


public class Validation {

    private String text;
    private static final String DELIMITER = ",|:";

    public Validation(String text) {
        this.text = text;
    }

    public boolean checkEmptyAndNull() {
        return text == null || text.isEmpty();
    }

    public boolean checkOnlyNumber() {
        return text.matches("[0-9]");
    }
}
