package lotto;

public class LottoNumber {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또 숫자는 1 ~ 45 사이의 숫자만 가능합니다.";
    private final int lottoNumber;

    public LottoNumber(int number) {
        validation(number);
        lottoNumber = number;
    }

    private void validation(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "LottoNumber{" + lottoNumber + '}';
    }
}
