package lotto;

import java.util.Map;

public class LottoPrizeInfo {
    private final Map<LottoWinnerClass, Integer> map;

    public LottoPrizeInfo(Map<LottoWinnerClass, Integer> map) {
        this.map = map;
    }

    public Integer getPrize(LottoWinnerClass winnerClass) {
        return map.get(winnerClass);
    }
}
