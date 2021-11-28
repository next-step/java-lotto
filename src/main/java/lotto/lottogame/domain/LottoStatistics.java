package lotto.lottogame.domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class LottoStatistics {

    private static final String RATE_PATTERN = "0.##";

    private final Map<Rank, Integer> lottoStatistics;
    private final OrderPrice orderPrice;

    public LottoStatistics(Map<Rank, Integer> lottoStatistics, OrderPrice orderPrice) {
        this.lottoStatistics = lottoStatistics;
        this.orderPrice = orderPrice;
    }

    public double calculateRateOfProfit() {
        DecimalFormat format = new DecimalFormat(RATE_PATTERN);
        format.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(format.format(totalPrizeMoney() / orderPrice.getOrderPrice()));
    }

    private double totalPrizeMoney() {
        return lottoStatistics.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * lottoStatistics.get(rank))
                .sum();
    }

    public Map<Rank, Integer> getLottoStatistics() {
        return lottoStatistics;
    }

}
