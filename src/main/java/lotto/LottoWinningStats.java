package lotto;

import java.util.List;
import java.util.Map;

import lotto.enums.Ranks;
import lotto.numbers.LottoBundle;

public class LottoWinningStats {
    public static final int PRICE = 1000;
    private final Map<Ranks, Integer> rankingMap;

    public LottoWinningStats(LottoBundle lottoBundle, List<Integer> winningNumbers, int bonusNumber) {
        this.rankingMap = lottoBundle.getRanks(winningNumbers, bonusNumber);
    }

    public Map<Ranks, Integer> getRanks() {
        return this.rankingMap;
    }

    public double getYield(int purchaseAmount) {
        int totalWinningAmounts = rankingMap.entrySet().stream()
                                            .mapToInt(entry -> entry.getKey().getRewards().intValue() * entry.getValue()).sum();

        if (rankingMap.isEmpty() || totalWinningAmounts == 0) {
            return 0;
        }
        return (double) totalWinningAmounts / purchaseAmount;
    }
}
