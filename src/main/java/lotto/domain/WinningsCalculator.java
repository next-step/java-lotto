package lotto.domain;

import java.util.List;

public class WinningsCalculator {
    public static int calculateWinnings(List<LottoResult> lottoResults) {
        int totalPrize = 0;
        for (LottoResult result : lottoResults) {
            totalPrize += result.getReward();
        }
        return totalPrize;
    }
}
