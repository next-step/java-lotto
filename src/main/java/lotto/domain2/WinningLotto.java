package lotto.domain2;

import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final Rank rank;

    WinningLotto(final Lotto lotto, final Rank rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    boolean is(final Rank rank) {
        return this.rank == rank;
    }

    int getWinningMoney() {
        return this.rank.getMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) &&
                rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, rank);
    }
}
