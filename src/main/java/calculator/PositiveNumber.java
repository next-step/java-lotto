package calculator;

/**
 * @author han
 */
public class PositiveNumber {

    private final int number;

    public PositiveNumber(int number) {
        this.number = number;
    }

    public PositiveNumber(String input) {
        this.number = stringToInt(input);
    }

    public int getNumber() {
        return number;
    }

    public PositiveNumber add(PositiveNumber number) {
        return new PositiveNumber(this.number + number.getNumber());
    }

    private int stringToInt(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
