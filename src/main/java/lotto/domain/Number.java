package lotto.domain;

public class Number {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1보다 작은 값은 로또 번호가 될 수 없습니다.");
        }
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 45를 넘어갈 수 없습니다.");
        }
    }
}
