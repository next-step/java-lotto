package stringcalculator;

public class Number {
    private static final int DEFAULT_NUMBER = 0;
    private final int number;

    public Number(String numberString) {
        this(Integer.parseInt(numberString));
    }

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < DEFAULT_NUMBER) {
            throw new IllegalArgumentException("기본값은 음수가 될 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }
}
