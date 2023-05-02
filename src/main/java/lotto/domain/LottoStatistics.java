package lotto.domain;

import java.util.*;

public class LottoStatistics {

    private Map<LottoRank, Integer> matchingCounts;
    private Double grossRateOfEarnings;

    public Map<LottoRank, Integer> calculateMatchingCounts(LottoTickets lottoTickets,
                                                           WinningTicket winningTicket) {
        Map<LottoRank, Integer> sameNumberCount = winningTicket.countMatching(lottoTickets);
        List<LottoRank> keys = new ArrayList<>(sameNumberCount.keySet());
        for (LottoRank key : keys) {
            matchLottoRank(sameNumberCount, key);
        }
        putZeroRanks(sameNumberCount);
        matchingCounts = sameNumberCount;
        return matchingCounts;
    }

    private void matchLottoRank(Map<LottoRank, Integer> sameNumberCount, LottoRank lottoRank) {
        if (lottoRank.isMiss()) {
            sameNumberCount.remove(lottoRank);
        }
    }

    private void putZeroRanks(Map<LottoRank, Integer> sameNumberCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            putZeroRank(sameNumberCount, lottoRank);
        }
    }

    private void putZeroRank(Map<LottoRank, Integer> sameNumberCount, LottoRank lottoRank) {
        if (lottoRank == LottoRank.FAIL) {
            return;
        }

        if (!sameNumberCount.containsKey(lottoRank)) {
            sameNumberCount.put(lottoRank, 0);
        }
    }

    public Double calculateGrossRateOfEarnings(int sumOfPurchaseAmount) {
        double sumOfPrizeMoney = 0;
        for (LottoRank lottoRank : matchingCounts.keySet()) {
            int count = matchingCounts.get(lottoRank);
            sumOfPrizeMoney += lottoRank.calculatePrizeMoney(count);
        }
        grossRateOfEarnings = sumOfPrizeMoney / sumOfPurchaseAmount;
        return grossRateOfEarnings;
    }
}
