package lotto.domain;

import java.util.Objects;
import java.util.stream.LongStream;

public class Count {

    public static final int MIN_VALUE = 0;
    private final long value;

    public Count(long value) {
        validatePositive(value);
        this.value = value;
    }

    private void validatePositive(long value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("개수가 음수일 수 없습니다.");
        }
    }

    public LongStream stream() {
        return LongStream.range(0, value);
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Count{" +
                "value=" + value +
                '}';
    }
}
