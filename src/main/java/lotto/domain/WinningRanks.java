package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningRanks {
    private final List<WinningRank> winningRanks;

    public WinningRanks(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningRanks that = (WinningRanks) o;
        return Objects.equals(winningRanks, that.winningRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningRanks);
    }

    public List<WinningRank> getWinningRanks() {
        return winningRanks;
    }
}
