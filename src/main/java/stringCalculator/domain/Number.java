package stringCalculator.domain;

public class Number {
    private final int number;

    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    private static void validate(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
