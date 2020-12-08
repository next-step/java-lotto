package calculator.domain;

public class Number {
    private final int value;

    public Number(String num) {
        this.value = convertToValue(num);
    }

    private int convertToValue(String num) {
        try{
            int value = Integer.parseInt(num);
            validate(value);
            return value;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수입니다.");
        }
    }
}
