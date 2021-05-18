package lotto.domain;

import static java.lang.String.format;

public class LottoNumber {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(format("로또의 번호는 %d 이상 %d 이하입니다.", MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        this.number = number;
    }
}
