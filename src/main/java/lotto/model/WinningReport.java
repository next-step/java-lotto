package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningReport {

    private final Map<Rank, Integer> statistics;
    private double profitRate;

    public WinningReport(List<Rank> ranks) {
        this.statistics = transformToMap(ranks);
        this.profitRate = calculateRate();
    }

    private double calculateRate() {
        long ticketCount = statistics.values().stream().mapToLong(Long::valueOf).sum();
        long ticketWinningCount = statistics.keySet().stream()
                .filter(k -> statistics.get(k) != 0)
                .mapToLong(k -> statistics.get(k) * (k.getWinningBonus() / LottoTicketOffice.PRICE))
                .sum();

        double expectedProfitRate = toDouble(ticketWinningCount) / toDouble(ticketCount);

        return Math.floor(expectedProfitRate * 100) / 100;
    }

    private double toDouble(long value) {
        return Long.valueOf(value).doubleValue();
    }

    private Map<Rank, Integer> transformToMap(List<Rank> ranks) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
