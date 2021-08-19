package lotto.step4.domain;

import java.util.Map;


public class LottoStatistics {
    private Map<Rank, Integer> lottoStatistics;


    public LottoStatistics(Map<Rank, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return lottoStatistics;
    }

    public double calculateLottoStatistics(int money) {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            sum += addWinningMoney(rank);
        }
        double earningRate = sum / (double) money;
        return Math.floor(earningRate * 100) / 100.0;
    }

    public long addWinningMoney(Rank rank) {
        if (lottoStatistics.get(rank) == null) {
            return 0;
        }
        int winningCount = lottoStatistics.getOrDefault(rank, 0);
        if (rank.equals(Rank.FIRST)) {
            return rank.getWinningMoney() / winningCount ;
        }
        return rank.getWinningMoney() * winningCount;
    }

}
