package study.lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final int totalPrice;
    private final LottoList lottoList;
    private final Map<LottoRank, Integer> statistics;

    private int totalEarning = 0;
    private float earningRate = 0;

    private Statistics(int totalPrice, LottoList lottoList) {
        this.totalPrice = totalPrice;
        this.lottoList = lottoList;

        statistics = new HashMap<>();

        for(LottoRank lottoRank : LottoRank.class.getEnumConstants()) {
            statistics.put(lottoRank, 0);
        }
    }

    public static Statistics createStatistics(int totalPrice, LottoList lottoList, WinningLotto winningLotto) {
        Statistics statistics = new Statistics(totalPrice, lottoList);

        statistics.calculateStatistics(winningLotto);
        statistics.calculateTotalEarning();
        statistics.calculateEarningRate();

        return statistics;
    }

    private void calculateStatistics(WinningLotto winningLotto) {
        lottoList.getLottoList()
                .forEach(lotto -> {
                    LottoRank lottoRank = lotto.getPrize(winningLotto);
                    statistics.put(lottoRank, statistics.get(lottoRank)+1);
                });
    }

    private void calculateEarningRate() {
        earningRate = totalEarning / (float)totalPrice;
    }

    private void calculateTotalEarning() {
        totalEarning = statistics.keySet().stream().map(prize -> prize.getPrize() * statistics.get(prize)).mapToInt(Integer::intValue).sum();
    }

    public int getTotalEarning() {
        return totalEarning;
    }

    public float getEarningRate() {
        return earningRate;
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}
