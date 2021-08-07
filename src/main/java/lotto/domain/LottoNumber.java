package lotto.domain;

public class LottoNumber {

    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "로또 숫자는 1에서 45 사이의 값이어야 합니다. number: %d";

    private final int number;

    private LottoNumber(int number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, number));
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }
}
