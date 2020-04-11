package stringpluscalculator;

public class Operand {
    public static final Operand ZERO = new Operand(0);
    private int positiveNumber;

    public Operand(int input) {
        validatePositiveOrZero(input);
        this.positiveNumber = input;
    }

    public Operand(String input) {
        this(changeToOperand(input));
    }

    public int getPositiveNumber() {
        return this.positiveNumber;
    }

    private static int changeToOperand(String input) {
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
