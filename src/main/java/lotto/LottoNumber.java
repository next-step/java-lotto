package lotto;

import static lotto.LottoConstant.*;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자입니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
