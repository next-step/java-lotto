package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class AutoLottoMatchCount {
    Map<Integer, WinningCount> lottoMatchCount;

    public AutoLottoMatchCount() {
        this.lottoMatchCount = new HashMap<>();
        initLottoMatchCount();
    }

    public Map<Integer, WinningCount> getLottoMatchCount() {
        return lottoMatchCount;
    }

    private void initLottoMatchCount() {
        this.lottoMatchCount.put(3, new WinningCount());
        this.lottoMatchCount.put(4, new WinningCount());
        this.lottoMatchCount.put(5, new WinningCount());
        this.lottoMatchCount.put(6, new WinningCount());
    }

    public void lottoCountPlus(Integer matchCount) {
        if (matchCount > 2) {
            lottoMatchCount.get(matchCount).plus();
        }
    }

    public int findLottoNumberCount(Integer number){
        return this.lottoMatchCount.get(number).getWinningCount();
    }
}
