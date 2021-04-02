package step4;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_LAST = 45;
    private final int number;

    public LottoNumber(String text) {
        this.number = Integer.parseInt(text);
    }

    public LottoNumber(int number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_LAST) {
            throw new IllegalArgumentException("로또 번호가 올바르지 않습니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        return new LottoNumber(number);
    }

    public static LottoNumber of(String text) {
        return new LottoNumber(text);
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

    @Override
    public String toString() {
        return number + "";
    }
}
