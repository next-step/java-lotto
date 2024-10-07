package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static int MIN_NUMBER = 1;
    public static int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "사이의 숫자만 포함될 수 있습니다.");
        }

        this.number = number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final LottoNumber lottoNumber = (LottoNumber) obj;
        return number == lottoNumber.number;
    }
}
