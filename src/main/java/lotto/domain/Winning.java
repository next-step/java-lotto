package lotto.domain;

import java.util.Objects;

public class Winning {

    private final Rank rank;
    private int count;

    Winning(final Rank rank) {
        this.rank = rank;
        this.count = 0;
    }

    String getRank() {
        return this.rank.name();
    }

    void addCount() {
        this.count++;
    }

    int getCount() {
        return this.count;
    }

    double getWinningAmount() {
        return rank.getWinningMoney() * count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning = (Winning) o;
        return count == winning.count &&
                rank == winning.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, count);
    }
}
