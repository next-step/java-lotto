package lotto.domain.ticket;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    LottoNumber(int number) {
        if (!isLottoNumber(number)) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }

        this.number = number;
    }

    int getNumber() {
        return number;
    }

    private boolean isLottoNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    boolean isEqualTo(LottoNumber lottoNumber) {
        return this.number == lottoNumber.number;
    }
}
