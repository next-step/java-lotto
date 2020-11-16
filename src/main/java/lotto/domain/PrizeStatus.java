package lotto.domain;

import java.util.Objects;

public class PrizeStatus {

    private long prizeNumberCount;


    public PrizeStatus(long prizeNumberCount) {
        this.prizeNumberCount = prizeNumberCount;
    }

    public long getPrizeNumberCount() {
        return prizeNumberCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeStatus that = (PrizeStatus) o;
        return prizeNumberCount == that.prizeNumberCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeNumberCount);
    }
}
