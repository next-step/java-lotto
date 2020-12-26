package lotto.domain;

import static lotto.util.LottoNumberGenerator.LOTTO_MAX_NUMBER;
import static lotto.util.LottoNumberGenerator.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("0보다 크고 46보다 적은 수만 허용합니다.");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
