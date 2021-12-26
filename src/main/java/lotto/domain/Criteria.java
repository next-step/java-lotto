package lotto.domain;

import java.util.Objects;

public class Criteria {
    private static int MIN = 0;
    private static int MAX = 6;

    private final int value;

    public Criteria(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public Criteria matchedCriteria() {
        return new Criteria(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Criteria)) return false;
        Criteria criteria = (Criteria) o;
        return value == criteria.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
