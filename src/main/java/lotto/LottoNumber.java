package lotto;

import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int VALUE_MIN = 1;
    private static final int VALUE_MAX = 45;

    private final int value;

    public LottoNumber() {
        this(getRandomNumber());
    }

    public LottoNumber(int value) {
        if (value < VALUE_MIN || value > VALUE_MAX) {
            throw new IllegalArgumentException("잘못된 로또 숫자입니다.");
        }
        this.value = value;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static int getRandomNumber() {
        return new Random().nextInt(VALUE_MAX) + 1;
    }
}
