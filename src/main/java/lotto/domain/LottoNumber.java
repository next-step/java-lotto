package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class LottoNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private static final LottoNumber memorization[] = new LottoNumber[MAXIMUM_NUMBER + 1];

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            memorization[i] = new LottoNumber(i);
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(format("로또의 번호는 %d 이상 %d 이하입니다.", MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        return memorization[number];
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
