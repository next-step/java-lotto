package step2step3.lotto;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        extracted(number);
        this.number = number;
    }

    private void extracted(int number) {
        if (number < 1 || 45 < number) {
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
}
