package study.lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final int totalPrice;
    private final LottoList lottoList;
    private final Map<Prize, Integer> statistics;

    private int totalEarning = 0;
    private float earningRate = 0;

    private Statistics(int totalPrice, LottoList lottoList) {
        this.totalPrice = totalPrice;
        this.lottoList = lottoList;

        statistics = new HashMap<>();

        for(Prize prize : Prize.class.getEnumConstants()) {
            statistics.put(prize, 0);
        }
    }

    public static Statistics createStatistics(int totalPrice, LottoList lottoList, Lotto winningLotto) {
        Statistics statistics = new Statistics(totalPrice, lottoList);

        statistics.calculateStatistics(winningLotto);
        statistics.calculateTotalEarning();
        statistics.calculateEarningRate();

        return statistics;
    }

    private void calculateStatistics(Lotto winningLotto) {
        lottoList.getLottoList()
                .forEach(lotto -> {
                    Prize prize = lotto.getPrize(winningLotto);
                    statistics.put(prize, statistics.get(prize)+1);
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
}
