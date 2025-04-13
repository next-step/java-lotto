package lotto.domain;

import java.util.Objects;

public class Count {

    private final int value;

    public Count(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("count는 음수가 될 수 없습니다.");
        }
        this.value = value;
    }

    public Count subtract(Count other) {
        return new Count(this.value - other.value);
    }

    public boolean isLessThan(Count other) {
        return this.value < other.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Count count = (Count) obj;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
