package lotto;

import java.util.Objects;

public class RankingRecord {
    private final Rank rank;
    private final int winners;

    public RankingRecord(Rank rank) {
        this(rank, 0);
    }

    public RankingRecord(Rank rank, int winners) {
        this.rank = rank;
        this.winners = winners;
    }

    public RankingRecord increaseWinner() {
        return new RankingRecord(rank, winners + 1);
    }

    public Rank rank() {
        return rank;
    }

    public int winners() {
        return winners;
    }

    public int amounts() {
        return rank.reward() * winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankingRecord that = (RankingRecord) o;
        return winners == that.winners && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, winners);
    }


}
