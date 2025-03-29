package lotto.domain.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public static LottoResult of(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        purchasedLottos.forEach(lotto -> lottoResult.addLottoResult(lotto, winningLotto));
        return lottoResult;
    }

    public double calculateReturnRate() {
        int sumOfPurchaseAmount = lottoResult.values().stream().mapToInt(Integer::intValue).sum() * LottoSeller.PRICE;
        return (double) calculateTotalPrize() / sumOfPurchaseAmount;
    }

    public Map<LottoRank, Integer> generateStatistics() {
        Map<LottoRank, Integer> statisticsMap = new LinkedHashMap<>();

        for (LottoRank rank : LottoRank.RANK_WITH_PRIZE) {
            int count = lottoResult.getOrDefault(rank, 0);
            statisticsMap.put(rank, count);
        }

        return statisticsMap;
    }

    private void addLottoResult(Lotto purchasedLotto, WinningLotto winningLotto) {
        LottoRank rank = winningLotto.calculateRank(purchasedLotto);
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    private long calculateTotalPrize() {
        long sumOfPrize = 0;
        for (LottoRank rank : LottoRank.RANK_WITH_PRIZE) {
            sumOfPrize += (long) lottoResult.getOrDefault(rank, 0) * rank.getPrize();
        }
        return sumOfPrize;
    }
}
