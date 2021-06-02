package study.lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {
    private static final Map<LottoRank, Integer> winningResult = new LinkedHashMap<>();
    private TotalPrize totalPrize = new TotalPrize();

    public WinningResult() {
        for (LottoRank value : LottoRank.values()) {
            addWitoutMiss(winningResult, value);
        }
    }

    private static void addWitoutMiss(Map<LottoRank, Integer> winningPrizeIntegerMap, LottoRank lottoRank) {
        if (!lottoRank.equals(LottoRank.MISS)) {
            winningPrizeIntegerMap.put(lottoRank, 0);
        }
    }

    public void addPrize(int matchCount, boolean matchBonus) {
        LottoRank winningPrize = LottoRank.of(matchCount, matchBonus);
        if (!winningPrize.equals(LottoRank.MISS)) {
            winningResult.computeIfPresent(winningPrize, (lottoRank, integer) -> integer+1);
            totalPrize.add(winningPrize.prize());
        }
    }

    public Map<LottoRank, Integer> value() {
        return winningResult;
    }

    public BigDecimal totalPrize() {
        return totalPrize.value();
    }
}
