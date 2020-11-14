package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningRanks {
    private final List<WinningRank> winningRankList;

    public WinningRanks(List<WinningRank> winningRankList) {
        this.winningRankList = winningRankList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningRanks that = (WinningRanks) o;
        return Objects.equals(winningRankList, that.winningRankList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningRankList);
    }
}
