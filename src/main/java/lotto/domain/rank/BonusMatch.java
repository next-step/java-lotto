package lotto.domain.rank;

import java.util.Objects;

public class BonusMatch {
    private final boolean value;

    public BonusMatch(boolean value) {
        this.value = value;
    }

    public boolean equals(boolean value) {
        return this.value == value;
    }

    public boolean value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusMatch that = (BonusMatch) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
