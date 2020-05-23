package calculator.domain.calculator;

public class Number {

    private final int number;

    public Number(int number) {
        validateNegative(number);
        this.number = number;
    }

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new NegativeInputException();
        }
    }

    public int getNumber() {
        return number;
    }
}
