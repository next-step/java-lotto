package calculator;

public class Number {
    private final int number;

    public Number(int number) {
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

    public Number sum(Number number) {
        return new Number(this.number + number.number);
    }

}
