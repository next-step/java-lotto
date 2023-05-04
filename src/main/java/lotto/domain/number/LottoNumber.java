package lotto.domain.number;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String ILLEGAL_LOTTO_NUMBER = "로또 번호는 1이상 45이하여야 합니다.";

    private final int number;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER);
        }
    }
}
