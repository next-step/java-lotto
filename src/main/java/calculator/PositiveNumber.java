package calculator;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < 0) {
            throw new RuntimeException("0보다 큰 값을 입력해야합니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    public PositiveNumber sum(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

}
