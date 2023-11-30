package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> countsByLottoRank;
    private int totalWinningMoney;
    private double returnRate;

    public LottoResult() {
        this.totalWinningMoney = 0;
        this.returnRate = 0.0;
        this.countsByLottoRank = new HashMap<>();
    }

    public void addRanks(List<LottoRank> lottoRank) {
        lottoRank.forEach(rank -> {
            countsByLottoRank.putIfAbsent(rank, 0);
            countsByLottoRank.put(rank, countsByLottoRank.get(rank) + 1);
        });
    }

    public int calculateTotalWinningMoney() {
        countsByLottoRank.forEach((key, value) -> totalWinningMoney += key.money() * value);
        return this.totalWinningMoney;
    }

    public Map<LottoRank, Integer> totalWinningStatistics() {
        return this.countsByLottoRank;
    }

    public void calculateReturnRate(int totalPayMoney) {
        this.returnRate =
            Math.round((double) totalWinningMoney / (double) totalPayMoney * 100.0) / 100.0;
    }

    public double returnRate() {
        return this.returnRate;
    }
}