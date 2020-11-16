package humbledude.lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(Integer number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("로또는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + "까지의 숫자만 쓸 수 있어요");
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
}
