package lotto.domain.statistics;

import java.util.Objects;

public class Count {
    private int value;

    public Count() {}

    public Count(int value) {
        this.value = value;
    }

    public void increase() {
        value++;
    }

    public int value() {
        return this.value;
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
}
