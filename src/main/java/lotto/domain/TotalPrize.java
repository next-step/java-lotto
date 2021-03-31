package lotto.domain;

import java.util.Objects;

public class TotalPrize {
    private final int totalPrize;

    public TotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public int totalPrize() {
        return totalPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalPrize that = (TotalPrize) o;
        return totalPrize == that.totalPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrize);
    }
}
