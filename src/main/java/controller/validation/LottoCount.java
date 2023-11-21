package controller.validation;

import java.util.Objects;

/**
 * 로또 장수를 나타내는 타입입니다.
 * 불변 타입입니다.
 */
public class LottoCount {
    private final int value;

    public LottoCount(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("0 또는 그 이상의 값을 원하나 입력된 값이 " + value + "입니다.");
        }

        this.value = value;
    }

    public LottoCount subtractionBy(LottoCount count) {
        if (this.value < count.value) {
            throw new IllegalArgumentException(this.value + "장을 나타내는 로도 장수에서 " + count.value + "장을 빼려고 시도했습니다.");
        }

        return new LottoCount(this.value - count.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
