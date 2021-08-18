package lotto.step3.domain;

import java.util.List;


public class LottoStatistics {
    private List<Rank> lottoStatistics;
    private Rank rank;
    private int countOfWinning;

    public LottoStatistics(Rank rank, int countOfWinning) {
        this.rank = rank;
        this.countOfWinning = countOfWinning;
    }

    public LottoStatistics(List<Rank> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public List<Rank> getLottoStatistics() {
        return lottoStatistics;
    }

    public double calculateLottoStatistics(int money) {
        int sum = 0;
        for (Rank rank : lottoStatistics) {
            sum += rank.getWinningMoney();
        }
        double earningRate = sum / (double) money;
        return Math.floor(earningRate * 100) / 100.0;
    }

}
