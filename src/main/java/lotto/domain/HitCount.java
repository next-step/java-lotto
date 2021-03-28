package lotto.domain;

import java.util.Objects;

public class HitCount {
    private final int hitCount;
    private final boolean isHitBonusNumber;

    public HitCount(int hitCount) {
        this(hitCount, false);
    }

    public HitCount(int hitCount, boolean isHitBonusNumber) {
        this.hitCount = hitCount;
        this.isHitBonusNumber = isHitBonusNumber;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isHitBonusNumber() {
        return isHitBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitCount hitCount1 = (HitCount) o;
        return hitCount == hitCount1.hitCount && isHitBonusNumber == hitCount1.isHitBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount, isHitBonusNumber);
    }

    @Override
    public String toString() {
        return "HitCount{" +
                "hitCount=" + hitCount +
                ", isHitBonusNumber=" + isHitBonusNumber +
                '}';
    }
}
