package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class AutoLottoMatchCount {
    Map<Rank, WinningCount> lottoMatchCount;

    public AutoLottoMatchCount() {
        this.lottoMatchCount = new HashMap<>();
        initLottoMatchCount();
    }

    public Map<Rank, WinningCount> getLottoMatchCount() {
        return lottoMatchCount;
    }

    private void initLottoMatchCount() {
        this.lottoMatchCount.put(Rank.FIRST, new WinningCount());
        this.lottoMatchCount.put(Rank.SECOND, new WinningCount());
        this.lottoMatchCount.put(Rank.THIRD, new WinningCount());
        this.lottoMatchCount.put(Rank.FOURTH, new WinningCount());
        this.lottoMatchCount.put(Rank.FIFTH, new WinningCount());
        this.lottoMatchCount.put(Rank.MISS, new WinningCount());
    }

    public void lottoCountPlus(WinningCount winningCount) {
      lottoMatchCount.get(Rank.of(winningCount.getWinningCount(), winningCount.isBonus())).plus();
    }

    public int findLottoNumberCount(Rank rank){
        return this.lottoMatchCount.get(rank).getWinningCount();
    }
}
