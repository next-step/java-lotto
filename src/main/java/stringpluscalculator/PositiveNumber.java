package stringpluscalculator;

public class PositiveNumber {
    private int positiveNumber;

    public PositiveNumber(int input) {
        validatePositiveOrZero(input);
        this.positiveNumber = input;
    }

    public PositiveNumber(String input) {
        this(changeToNumber(input));
    }

    public int getPositiveNumber() {
        return this.positiveNumber;
    }

    private static int changeToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validatePositiveOrZero(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("양수만 사용할 수 있습니다.");
        }
    }
}
