package lotto.domain;

import java.util.*;

public class LottoStatics {

    private Map<Integer, Integer> matchingCounts;
    private Double grossRateOfEarnings;

    public Map<Integer, Integer> calculateMatchingCounts(LottoNumbers lottoNumbers,
                                                         LottoNumber winningNumber) {
        Map<Integer, Integer> sameNumberCount = lottoNumbers.calculateSameNumberCounts(winningNumber);
        List<Integer> keys = new ArrayList<>(sameNumberCount.keySet());
        for (int key : keys) {
            matchLottoRank(sameNumberCount, key);
        }
        putZeroRanks(sameNumberCount);
        matchingCounts = sameNumberCount;
        return matchingCounts;
    }

    private void putZeroRanks(Map<Integer, Integer> sameNumberCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            putZeroRank(sameNumberCount, lottoRank);
        }
    }

    private void putZeroRank(Map<Integer, Integer> sameNumberCount, LottoRank lottoRank) {
        int count = lottoRank.getMatchCount();
        if (count == 0) {
            return;
        }

        if (!sameNumberCount.containsKey(count)) {
            sameNumberCount.put(count, 0);
        }
    }

    private void matchLottoRank(Map<Integer, Integer> sameNumberCount, int key) {
        if (LottoRank.of(key).isMiss()) {
            sameNumberCount.remove(key);
        }
    }

    public Double calculateGrossRateOfEarnings(int sumOfPurchaseAmount) {
        double sumOfPrizeMoney = 0;
        for (int matchingCount : matchingCounts.keySet()) {
            int count = matchingCounts.get(matchingCount);
            sumOfPrizeMoney += LottoRank.of(matchingCount).calculatePrizeMoney(count);
        }
        grossRateOfEarnings = sumOfPrizeMoney / sumOfPurchaseAmount;
        return grossRateOfEarnings;
    }

    public Map<Integer, Integer> calculateMatchingPrices() {
        Map<Integer, Integer> matchingPrices = new HashMap<>();
        for (int key : matchingCounts.keySet()) {
            matchingPrices.put(key, LottoRank.of(key).getPrizeMoney());
        }
        return matchingPrices;
    }
}
