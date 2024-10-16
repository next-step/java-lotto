package model;

public class LottoNumberValidator {
    public static void checkLottoNumberRange(Integer number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Bonus number must be between 1 and 45");
        }
    }
}
