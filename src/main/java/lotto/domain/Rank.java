package lotto.domain;

import java.util.Objects;

public class Rank {

    private final int rank;

    public Rank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank1 = (Rank) o;
        return rank == rank1.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank);
    }
}
