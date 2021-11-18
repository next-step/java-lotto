package calculator;

/**
 * @author han
 */
public class PositiveNumber {

    private final int number;

    private PositiveNumber(String input) {
        this.number = stringToInt(input);
    }

    public static PositiveNumber of(String input) {
        return new PositiveNumber(input);
    }

    public int getNumber() {
        return number;
    }

    private int stringToInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
