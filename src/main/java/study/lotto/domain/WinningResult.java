package study.lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class WinningResult {
    private Map<WinningPrize, Integer> winningResult;

    public WinningResult() {
        this.winningResult = initializeWinningPrize();
    }

    private Map<WinningPrize, Integer> initializeWinningPrize() {
        Map<WinningPrize, Integer> winningPrizeIntegerMap = new LinkedHashMap<>();
        for (WinningPrize value : WinningPrize.values()) {
            winningPrizeIntegerMap.put(value, 0);
        }
        return winningPrizeIntegerMap;
    }


    public void addPrize(int matchCount) {
        Optional<WinningPrize> winningPrize = WinningPrize.of(matchCount);
        winningPrize.ifPresent(w -> winningResult.computeIfPresent(w, (key, count) -> count+1));
    }

    public Map<WinningPrize, Integer> value() {
        return winningResult;
    }

    public BigDecimal totalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (WinningPrize winningPrize : winningResult.keySet()) {
            totalPrize = totalPrize.add(winningPrize.prize().multiply(BigDecimal.valueOf(winningResult.get(winningPrize))));
        }
        return totalPrize;
    }
}
