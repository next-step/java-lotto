package step2;

import java.util.Objects;

public class HitCount {

    private long hitCount;
    private boolean bonusBallHit;

    public HitCount(long hitCount) {
        this(hitCount,false);
    }

    public HitCount(long hitCount,boolean bonusBallHit) {
        this.hitCount = hitCount;
        this.bonusBallHit = bonusBallHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitCount hitCount1 = (HitCount) o;
        return hitCount == hitCount1.hitCount &&
                bonusBallHit == hitCount1.bonusBallHit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount, bonusBallHit);
    }
}
