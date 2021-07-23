package lotto.domain.number;

public class LottoNumber {
    public static final int MAX_OF_LOTTO_NUMBER = 45;
    public static final int MIN_OF_LOTTO_NUMBER = 1;

    private final int number;

    private LottoNumber(int number) {
        validate(number);

        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_OF_LOTTO_NUMBER || number > MAX_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "Lotto number must be greater than " + MIN_OF_LOTTO_NUMBER + " and less than " + MAX_OF_LOTTO_NUMBER
            );
        }
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }
}
