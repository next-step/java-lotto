package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.String.format;

public class LottoWinningStatistics {
    private static final String RESULT_FORMAT = "%s - %d개";
    public static final String PROFIT_RATE_FORMAT = "%.2f";
    private final Map<PrizeLevel, Integer> statistics;

    public LottoWinningStatistics(Map<PrizeLevel, Integer> statistics) {
        this.statistics = statistics;
    }

    public List<String> generateFormattedReport() {
       return statistics.entrySet().stream()
            .map(entry -> formatEntry(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }

    public double getProfitRate(int money) {
        int totalPrize = statistics.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();

        return parseDouble(format(PROFIT_RATE_FORMAT, (double) totalPrize / money));
    }

    private String formatEntry(PrizeLevel level, int count) {
        return format(RESULT_FORMAT, level.getMessage(), count);
    }
}
