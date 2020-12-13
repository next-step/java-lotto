package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private static final int ONE_LOTTO_PRICE = 1000;
    private final Map<LottoRank, Integer> lottoResults;

    public LottoResult(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        HashMap<LottoRank, Integer> results = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = LottoRank.getLottoRank(winningNumber.winningCount(lottoTicket));
            results.put(lottoRank, results.getOrDefault(lottoRank,0) + 1);
        }
        this.lottoResults = results;
    }

    public int getResult(LottoRank key) {
        return lottoResults.getOrDefault(key, 0);
    }

    public double rewardRatio() {
        Set<LottoRank> lottoRanks = lottoResults.keySet();
        long totalReward = getTotalReward(lottoRanks);
        long purchaseAmount = getPurchaseAmount(lottoRanks);
        return rateCalculation(totalReward, purchaseAmount);
    }

    protected static double rateCalculation(long totalReward, double purchaseAmount) {
        return Math.floor((totalReward / purchaseAmount)*100) / 100;
    }

    private long getPurchaseAmount(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                    .mapToLong(lottoResults::get)
                    .sum() * ONE_LOTTO_PRICE;
    }

    private long getTotalReward(Set<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                    .mapToLong(lottoRank -> lottoRank.reward() * lottoResults.get(lottoRank))
                    .sum();
    }
}
