package lotto.domain;

import java.util.Objects;

public class Chance {

    private static final int LAST_ONE_CHANCE = 1;

    private final int value;

    public Chance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return value == chance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isLeft() {
        return value >= LAST_ONE_CHANCE;
    }

    public Chance useOnce() {
        validateValue();
        return new Chance(value - 1);
    }

    private void validateValue() {
        if( value < LAST_ONE_CHANCE) {
            throw new IllegalStateException("더이상 찬스를 사용할 수 없습니다.");
        }
    }
}
