package lotto.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new HashMap<>();

    public static LottoResult of(List<Lotto> purchasedLottos, Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        purchasedLottos.forEach(lotto -> lottoResult.addLottoResult(lotto, winningLotto));
        return lottoResult;
    }

    public double calculateReturnRate() {
        int sumOfPurchaseAmount = lottoResult.values().stream().mapToInt(Integer::intValue).sum() * LottoSeller.PRICE;
        return (double) calculateTotalPrize() / sumOfPurchaseAmount;
    }

    public String generateStatistics() {
        StringBuilder sb = new StringBuilder();

        for (LottoRank rank : LottoRank.RANK_WITH_PRIZE) {
            int count = lottoResult.getOrDefault(rank, 0);
            sb.append(formatLottoRankResult(rank, count));
        }

        return sb.toString();
    }

    private void addLottoResult(Lotto purchasedLotto, Lotto winningLotto) {
        LottoRank rank = purchasedLotto.getRank(winningLotto);
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    private long calculateTotalPrize() {
        long sumOfPrize = 0;
        for (LottoRank rank : LottoRank.RANK_WITH_PRIZE) {
            sumOfPrize += (long) lottoResult.getOrDefault(rank, 0) * rank.getPrize();
        }
        return sumOfPrize;
    }

    private String formatLottoRankResult(LottoRank rank, int count) {
        return String.format("%d개 일치 (%d원)- %d개\n", rank.getNumOfMatch(), rank.getPrize(), count);
    }
}
