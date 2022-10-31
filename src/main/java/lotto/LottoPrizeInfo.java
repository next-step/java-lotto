package lotto;

import java.util.Map;

public class LottoPrizeInfo {
    private final Map<LottoResult, Integer> map;

    public LottoPrizeInfo(Map<LottoResult, Integer> map) {
        this.map = map;
    }

    public Integer getPrize(LottoResult winnerClass) {
        return map.getOrDefault(winnerClass, 0);
    }
}
