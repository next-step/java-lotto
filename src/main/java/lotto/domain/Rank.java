package lotto.domain;

import java.util.Objects;

public class Rank {

    private final int rank;
    private static final int RANK_MINIMUM = 1;
    private static final String RANK_BOUND_EXCEPTION = String.format("Rank는 %d 이상이어야 합니다.", RANK_MINIMUM);

    public Rank(final int rank) {
        if (rank < RANK_MINIMUM) {
            throw new IllegalArgumentException(RANK_BOUND_EXCEPTION);
        }
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
