package lotto.domain;

public class LottoNumber {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final String NUMBER_IS_INVALID = "유효하지 않은 번호 입니다.";

    private int number;

    public LottoNumber(int number) {
        validateMinMaxNumber(number);
        this.number = number;
    }

    private void validateMinMaxNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_IS_INVALID);
        }
    }

    public int getNumber() {
        return number;
    }
}
