package lotto.step1;

public class Validation {

    private String text;
    private static final String DELIMITER = ",|:";

    public Validation(String text) {
        this.text = text;
    }

    public boolean checkEmptyAndNull() {
        if (text.equals("") || text.equals(" ") || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkNotNegativeNumber() {
        String[] numbers = text.split(DELIMITER);
        for (String number : numbers){
            isNegativeNumber(number);
        }
        return true;
    }

    public void isNegativeNumber(String number){
        if (Integer.valueOf(number) < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
