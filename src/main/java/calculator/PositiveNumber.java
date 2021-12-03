package calculator;

/**
 * @author han
 */
public class PositiveNumber {

    private final int number;

    public PositiveNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public PositiveNumber(String input) {
        this(stringToInt(input));
    }

    public int getNumber() {
        return number;
    }

    public PositiveNumber add(PositiveNumber number) {
        return new PositiveNumber(this.number + number.getNumber());
    }

    private static int stringToInt(String input) {
        int number = Integer.parseInt(input);
        validateNumber(number);
        return number;
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(number);
        return sb.toString();
    }
}
