package lotto.domain;

import java.util.Objects;

public class LottoResult {
    private final Rank rank;
    private final int numberOfTimes;

    public LottoResult(Rank rank, int numberOfTimes) {
        this.rank = rank;
        this.numberOfTimes = numberOfTimes;
    }

    public int sumResult() {
        return rank.getWinningMoney() * numberOfTimes;
    }

    public Rank getRank() {
        return rank;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return numberOfTimes == that.numberOfTimes && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, numberOfTimes);
    }

    @Override
    public String toString() {
        return "rank=" + rank +
                ", numberOfTimes=" + numberOfTimes;
    }
}
