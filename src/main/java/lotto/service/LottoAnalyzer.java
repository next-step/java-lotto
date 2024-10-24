package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {
    private final static int[] prize = {0, 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};

    private final Map<Integer, WinningInfo> winningStatics;

    public LottoAnalyzer() {
        this.winningStatics = createWinningStatics();
    }

    public Map<Integer, WinningInfo> calculateWinningStatics(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumber(winningNumbers, bonusNumber);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            int rank = LottoRank.getRankByMatchCount(matchCount, matchBonus);

            WinningInfo winningInfo = winningStatics.get(rank);
            winningInfo.increaseWinningCount();
        }

        return winningStatics;
    }

    private Map<Integer, WinningInfo> createWinningStatics() {
        Map<Integer, WinningInfo> winningStatics = new HashMap<>();

        for (int rank = 0; rank <= 5; rank++) {
            winningStatics.put(rank, new WinningInfo(rank, prize[rank], 0));
        }

        return winningStatics;
    }

    public float calculateReturnRate(int buyAmount) {
        int totalPrize = 0;

        for (int rank = 1; rank <= 5; rank++) {
            WinningInfo info = winningStatics.get(rank);
            totalPrize += info.calculateTotalPrize();
        }

        return (float) totalPrize / buyAmount;
    }
}
