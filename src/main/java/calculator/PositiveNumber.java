package calculator;

public class PositiveNumber {
    public static final int MIN_NUMBER_INPUT = 0;
    private int number;

    public PositiveNumber(int number) {
        if (number < MIN_NUMBER_INPUT) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
