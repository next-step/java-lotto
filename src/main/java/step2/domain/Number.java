package step2.domain;

public class Number {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
        }
    }

}
