package lotto.step2.domain;

import java.text.DecimalFormat;
import java.util.Map;

public class LottoResult {
    private Map<WinningRank, Integer> lottoResult;

    public LottoResult(Map<WinningRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;

    }

    public Map<WinningRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public String calculateStatistics(int money) {
        long sum = 0;
        for (WinningRank rank : WinningRank.values()) {
            sum += addWinningMoney(rank);
        }
        double winning = sum / (double) money;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(winning);
    }

    public int addWinningMoney(WinningRank rank) {
        if (lottoResult.get(rank) == null) {
            return 0;
        }
        if (rank.equals(WinningRank.FIRST_PLACE)) {
            return rank.getWinnings();
        }
        int winningCount = lottoResult.getOrDefault(rank, 0);
        return rank.getWinnings() * winningCount;
    }
}
