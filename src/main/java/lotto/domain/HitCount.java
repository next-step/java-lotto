package lotto.domain;

import java.util.Objects;

public class HitCount {
    private static final int MIN_COUNT = 0;

    private static final int MAX_COUNT = 6;

    private final int hitCount;

    public HitCount(final int hitCount) {
        validateRange(hitCount);
        this.hitCount = hitCount;
    }

    private void validateRange(final int hitCount) {
        if (hitCount < MIN_COUNT || hitCount > MAX_COUNT) {
            throw new IllegalArgumentException("맞춘 횟수는 0~6 사이 숫자이어야 합니다.");
        }
    }

    public int getValue() {
        return hitCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HitCount hitCount1 = (HitCount) o;
        return hitCount == hitCount1.hitCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount);
    }
}
