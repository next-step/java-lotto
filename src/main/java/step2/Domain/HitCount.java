package step2.Domain;

import java.util.Objects;

public class HitCount {

    private long hitCount;

    public HitCount(long hitCount) {
        this.hitCount = hitCount;
    }

    public long getHit(){
        return hitCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitCount hitCount1 = (HitCount) o;
        return hitCount == hitCount1.hitCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount);
    }
}
