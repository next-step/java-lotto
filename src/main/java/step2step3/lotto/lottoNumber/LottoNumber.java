package step2step3.lotto.lottoNumber;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number) {
        verifyNumber(number);
        this.number = number;
    }

    private void verifyNumber(int number) {
        final int lottoNumberMin = 1;
        final int lottoNumberMax = 45;

        if (number < lottoNumberMin || lottoNumberMax < number) {
            throw new IllegalArgumentException("숫자는 1이상 46이하이어야 합니다.");
        }
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

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int number() {
        return number;
    }
}
