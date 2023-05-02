package lotto.model;

import java.util.Objects;

public class Count implements Comparable<Count> {

    private final int count;

    public Count(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("should be non negative:" + count);
        }
        this.count = count;
    }

    public static Count of(Price price) {
        int count = price.value() / Lotto.PRICE;
        return new Count(count);
    }

    public int value() {
        return count;
    }

    @Override
    public int compareTo(Count o) {
        return Integer.compare(this.count, o.count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
