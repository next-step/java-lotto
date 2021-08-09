package step2.domain;

public class LottoNumber {
    private final int number;
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 당첨번호는 1과 45 사이의 정수이어야 합니다.";
    private static final int MIN_OF_LOTTO_NUMBER = 1;
    private static final int MAX_OF_LOTTO_NUMBER = 45;

    public LottoNumber(int number) {
        checkRange();
        this.number = number;
    }

    private void checkRange() {
        if (number > MAX_OF_LOTTO_NUMBER || number < MIN_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
