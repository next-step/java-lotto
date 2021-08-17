package lotto.domain;

import java.util.Objects;

public class Chance {

    private static final int ZERO = 0;
    private static final int LAST_ONE_CHANCE = 1;

    private final int value;

    public Chance(int value) {
        validateValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Chance subtract(Chance chance) {
        if (!this.isBiggerOrEqualThan(chance)) {
            throw new IllegalArgumentException("더 큰 수의 찬스를 뺄 수 없습니다.");
        }
        return new Chance(this.value - chance.value);
    }

    public boolean isLeft() {
        return value >= LAST_ONE_CHANCE;
    }

    public Chance useOnce() {
        validateChanceRemain();
        return new Chance(value - 1);
    }

    public boolean isBiggerOrEqualThan(Chance other) {
        return this.value >= other.value;
    }

    private void validateValue(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("찬스는 음수일 수 없습니다.");
        }
    }

    private void validateChanceRemain() {
        if (value < LAST_ONE_CHANCE) {
            throw new IllegalStateException("더이상 찬스를 사용할 수 없습니다.");
        }
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
}
