package lotto.model;

import java.util.Objects;

public class Count {
    private final int count;

    public Count(int count) {
        if (isNegative(count)) {
            throw new IllegalArgumentException("로또 개수는 0 이상이어야 합니다.");
        }
        this.count = count;
    }

    private boolean isNegative(int count) {
        return count < 0;
    }

    public int value() {
        return count;
    }

    public Count add(Count count) {
        return new Count(this.count + count.count);
    }

    public Count subtract(Count count) {
        return new Count(this.count - count.count);
    }

    public boolean isBiggerThan(Count count) {
        return this.count > count.count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Count that = (Count) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
