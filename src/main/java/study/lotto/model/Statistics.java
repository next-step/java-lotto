package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Statistics {
    private final Lottos lottos;

    private Map<LottoRank, Integer> statistics;

    public Statistics(Lottos lottos) {
        this.lottos = lottos;
    }

    public void calculateStatistics(WinningLottoInfo winningLottoInfo) {
        statistics = lottos.countingByLottoRank(winningLottoInfo);
    }

    public BigDecimal calculateEarningRate(int totalPrice) {
        BigDecimal totalEarning = new BigDecimal(calculateTotalEarning());

        return totalEarning.divide(new BigDecimal(totalPrice), 10, RoundingMode.HALF_EVEN);
    }

    private int calculateTotalEarning() {
        return statistics.keySet()
                .stream()
                .map(lottoRank -> lottoRank.getPrize() * statistics.get(lottoRank))
                .mapToInt(Integer::intValue).sum();
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}
