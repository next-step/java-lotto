package lotto.domain.rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoRevenueCalculator {

    private Map<LottoRank, Integer> lottoRankCount =  new LinkedHashMap<>(Map.of(
            LottoRank.FIRST, 0,
            LottoRank.SECOND, 0,
            LottoRank.THIRD, 0,
            LottoRank.FOURTH, 0,
            LottoRank.FIFTH, 0
    ));

    private int totalSize;
    private int totalMoney;

    public LottoRevenueCalculator(List<LottoRank> lottoRanks) {
        addMoneyAndCount(lottoRanks);
        this.totalSize = lottoRanks.size();
    }

    public Map<LottoRank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public String getRevenueRate() {
        double revenueRate = Double.valueOf(totalMoney) / Double.valueOf(totalSize * 1000);
        return String.format("%.2f", revenueRate);
    }

    private void addMoneyAndCount(List<LottoRank> lottoRankList) {
        int winningMoney = 0;
        for (LottoRank lottoRank : lottoRankList) {
            saveRankCount(lottoRank);
            winningMoney += lottoRank.getWinningMoney();
        }
        this.totalMoney = winningMoney;
    }

    private void saveRankCount(LottoRank rank) {
        if (LottoRank.MISS != rank) {
            lottoRankCount.put(rank, lottoRankCount.get(rank) + 1);
        }
    }

}
