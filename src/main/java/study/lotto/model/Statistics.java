package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Lottos lottos;
    private final Map<LottoRank, Integer> statistics = new HashMap<>();

    public Statistics(Lottos lottos) {
        this.lottos = lottos;

        for(LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
    }

    public void calculateStatistics(WinningLotto winningLotto) {
        lottos.getLottoList()
                .forEach(lotto -> {
                    LottoRank lottoRank = lotto.getPrize(winningLotto);
                    statistics.put(lottoRank, statistics.get(lottoRank)+1);
                });
    }

    public BigDecimal calculateEarningRate(int totalPrice) {
        BigDecimal totalEarning = new BigDecimal(calculateTotalEarning());

        return totalEarning.divide(new BigDecimal(totalPrice), 10, RoundingMode.HALF_EVEN);
    }

    private int calculateTotalEarning() {
        return statistics.keySet()
                .stream()
                .map(prize -> prize.getPrize() * statistics.get(prize))
                .mapToInt(Integer::intValue).sum();
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}
