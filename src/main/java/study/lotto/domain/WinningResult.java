package study.lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRank, Integer> winningResult;
    private final TotalPrize totalPrize;

    private WinningResult(Map<LottoRank, Integer> winningResult, TotalPrize totalPrize) {
        this.winningResult = winningResult;
        this.totalPrize = totalPrize;
    }

    public static WinningResult of(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> newWinningResult = initializeMap();
        TotalPrize newTotalPrize = new TotalPrize(BigDecimal.ZERO);
        for (Lotto lotto : purchasedLottos.values()) {
            LottoRank winningPrize = winningPrize(lotto, winningLotto);
            addWinningCount(newWinningResult, winningPrize);
            newTotalPrize = newTotalPrize.add(winningPrize.prize());
        }
        return new WinningResult(newWinningResult,newTotalPrize);
    }

    private static Map<LottoRank, Integer> initializeMap() {
        Map<LottoRank, Integer> newWinningResultMap = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.prizeableRank()) {
            newWinningResultMap.put(lottoRank, 0);
        }
        return newWinningResultMap;
    }

    private static LottoRank winningPrize(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.matchWinningNumberCount(winningLotto.lotto());
        boolean matchBonus = lotto.isMatchBonus(winningLotto.bonusNumber());
        return LottoRank.of(matchCount, matchBonus);
    }

    private static void addWinningCount(Map<LottoRank, Integer> newWinningResult, LottoRank winningPrize) {
        newWinningResult.computeIfPresent(winningPrize, (lottoRank, integer) -> integer+1);
    }


    public Map<LottoRank, Integer> value() {
        return winningResult;
    }

    public BigDecimal totalPrize() {
        return totalPrize.value();
    }
}
