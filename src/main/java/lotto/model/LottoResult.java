package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> win;
    private int totalWinningMoney;
    private double returnRate;

    public LottoResult() {
        this.totalWinningMoney = 0;
        this.returnRate = 0.0;
        this.win = new HashMap<>();
    }

    public void addRanks(List<LottoRank> lottoRank) {
        for (LottoRank rank : lottoRank) {
            win.putIfAbsent(rank, 0);
            win.put(rank, win.get(rank) + 1);
        }
    }

    public int calculateTotalWinningMoney() {
        for (Map.Entry<LottoRank, Integer> entry : win.entrySet()) {
            totalWinningMoney += entry.getKey().money() * entry.getValue();
        }
        return this.totalWinningMoney;
    }

    public Map<LottoRank, Integer> totalWinningStatistics() {
        return this.win;
    }

    public void calculateReturnRate(int totalPayMoney) {
        this.returnRate =
            Math.round((double) totalWinningMoney / (double) totalPayMoney * 100.0) / 100.0;
    }

    public double returnRate() {
        return this.returnRate;
    }
}