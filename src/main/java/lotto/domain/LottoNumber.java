package lotto.domain;

public class LottoNumber {
    private static final int LOTTO_NUMBER_UNDER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < LOTTO_NUMBER_UNDER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 값이어야 합니다. - " + number);
        }
    }
}
