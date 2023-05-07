package lotto.model;

public class LottoNumber {
    public static final int LOTTO_MINIMUM_NUMBER = 1;
    public static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1보다 작을 수 없습니다.");
        }

        if (number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("로또번호는 45보다 클 수 없습니다.");
        }
    }
}
