package lotto.domain;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number > MAX_LOTTO_NUMBER | number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1에서 45까지의 숫자만 사용가능합니다.");
        }
    }
}
