package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {
    private final LottoMoney lottoMoney;
    private final Map<WinningSheet, Long> winningStatistics;

    public LottoResult(LottoMoney lottoMoney, List<Integer> drawResults) {
        this.lottoMoney = lottoMoney;
        this.winningStatistics = makeWinningStatistics(drawResults);
    }

    public Map<WinningSheet, Long> getWinningStatistics() {
        return this.winningStatistics;
    }

    private Map<WinningSheet, Long> makeWinningStatistics(List<Integer> drawResults) {
        Map<WinningSheet, Long> winningStatistics = new LinkedHashMap<>();

        for (WinningSheet winningSheet : WinningSheet.values()) {
            long count = drawResults.stream()
                    .filter(drawResult -> winningSheet.getMatchCount() == drawResult)
                    .count();

            winningStatistics.put(winningSheet, count);
        }

        return winningStatistics;
    }

    public double calculateRateOfReturn() {
        double profit = winningStatistics.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> entry.getKey().getPrice())
                .reduce(Integer::sum)
                .orElse(0);

        double rateOfReturn = profit / lottoMoney.getPurchaseAmount();

        return Double.parseDouble(String.format("%.2f", rateOfReturn));
    }
}
