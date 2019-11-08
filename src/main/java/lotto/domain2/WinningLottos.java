package lotto.domain2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningLottos {
    private List<WinningLotto> winningLottos;

    public WinningLottos() {
        this.winningLottos = new ArrayList<>();
    }

    void addOnlyWinning(final Lotto lotto, final Rank rank) {
        if (rank != Rank.LOSE) {
            this.winningLottos.add(new WinningLotto(lotto, rank));
        }
    }

    public int getCountOf(final Rank rank) {
        return (int) winningLottos.stream()
                .filter(winningLotto -> winningLotto.is(rank))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottos that = (WinningLottos) o;
        return Objects.equals(winningLottos, that.winningLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottos);
    }
}
