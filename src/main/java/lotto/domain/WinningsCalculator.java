package lotto.domain;

import java.util.List;

public class WinningsCalculator {
    public int calculateWinnings(List<LottoResult> lottoResults) {
        int totalPrize = 0;
        for (LottoResult result : lottoResults) {
            totalPrize += result.getReward();
        }
        return totalPrize;
    }

    public double calculateYield(int investment, List<LottoResult> results) {
        return (double) calculateWinnings(results) / investment;
    }
}
