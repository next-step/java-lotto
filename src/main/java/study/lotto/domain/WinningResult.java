package study.lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class WinningResult {
    private Map<LottoRank, Integer> winningResult;

    public WinningResult() {
        this.winningResult = initializeWinningPrize();
    }

    private Map<LottoRank, Integer> initializeWinningPrize() {
        Map<LottoRank, Integer> winningPrizeIntegerMap = new LinkedHashMap<>();
        for (LottoRank value : LottoRank.values()) {
            winningPrizeIntegerMap.put(value, 0);
        }

        return winningPrizeIntegerMap;
    }


    public void addPrize(int matchCount, boolean matchBonus) {
        Optional<LottoRank> winningPrize = LottoRank.of(matchCount, matchBonus);
        winningPrize.ifPresent(w -> winningResult.computeIfPresent(w, (key, count) -> count+1));
    }

    public Map<LottoRank, Integer> value() {
        return winningResult;
    }

    public BigDecimal totalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (LottoRank lottoRank : winningResult.keySet()) {
            totalPrize = totalPrize.add(lottoRank.prize().multiply(BigDecimal.valueOf(winningResult.get(lottoRank))));
        }
        return totalPrize;
    }
}
