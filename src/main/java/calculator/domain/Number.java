package calculator.domain;

public class Number {
    private final int Number;

    public Number(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수를 입력 할 수 없습니다.");
        }
        Number = number;
    }

    public int getNumber() {
        return Number;
    }
}
