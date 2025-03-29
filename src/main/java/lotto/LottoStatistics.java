package lotto;

import java.util.EnumMap;

public class LottoStatistics {
    private final int lottoPrice;
    private final EnumMap<LottoResult, Integer> statistics;

    private Integer totalPrize = null;

    private LottoStatistics(int lottoPrice, EnumMap<LottoResult, Integer> statistics) {
        this.lottoPrice = lottoPrice;
        this.statistics = statistics;
    }

    public static LottoStatistics getStatistics(int lottoPrice, EnumMap<LottoResult, Integer> statistics) {
        return new LottoStatistics(lottoPrice, statistics);
    }

    public int getCount(LottoResult lottoResult) {
        return statistics.getOrDefault(lottoResult, 0);
    }

    public String calculateYield() {
        int totalPrize = getTotalPrize();
        return String.format("%.2f", (double) totalPrize / lottoPrice);
    }

    private int getTotalPrize() {
        if (totalPrize == null) {
            totalPrize = statistics.entrySet().stream()
                    .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                    .sum();
        }
        return totalPrize;
    }
}
