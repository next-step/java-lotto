package lotto.service;

import lotto.model.BoughtLotto;
import lotto.model.WinningLotto;
import lotto.model.WinningRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningAnalyzer {
    private static final int[] prize = {0, 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};

    private WinningAnalyzer() {
    }

    public static Map<Integer, WinningRecord> calculateWinningStatistics(WinningLotto winningLotto, List<BoughtLotto> boughtLottos) {
        Map<Integer, WinningRecord> winningStatistics = createWinningStatistics();

        for (BoughtLotto boughtLotto : boughtLottos) {
            int rank = winningLotto.determineRank(boughtLotto);

            WinningRecord winningRecord = winningStatistics.get(rank);
            winningRecord.increaseWinningCount();
        }

        return winningStatistics;
    }

    private static Map<Integer, WinningRecord> createWinningStatistics() {
        Map<Integer, WinningRecord> winningStatistics = new HashMap<>();

        for (int rank = 0; rank <= 5; rank++) {
            winningStatistics.put(rank, new WinningRecord(rank, prize[rank], 0));
        }

        return winningStatistics;
    }

    public static float calculateReturnRate(int buyAmount, Map<Integer, WinningRecord> winningStatistics) {
        int totalPrize = 0;

        for (int rank = 1; rank <= 5; rank++) {
            WinningRecord winningRecord = winningStatistics.get(rank);
            totalPrize += winningRecord.calculateTotalPrize();
        }

        return (float) totalPrize / buyAmount;
    }

}
