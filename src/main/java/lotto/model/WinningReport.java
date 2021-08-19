package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningReport {

    private final List<Rank> statistics;
    private double profitRate;

    public WinningReport(List<Rank> ranks) {
        this.statistics = ranks;
        this.profitRate = calculateRate();
    }

    public double getProfitRate() {
        return profitRate;
    }

    public int getRankCount(Rank rank) {
        return Math.toIntExact(
                statistics.stream()
                        .filter(it -> it == rank)
                        .count()
        );
    }

    private double calculateRate() {
        double expectedProfitRate = toDouble(countTotalWinningBonus()) / (toDouble(countTicket()) * LottoTicketOffice.PRICE);

        return Math.floor(expectedProfitRate * 100) / 100;
    }

    private long countTotalWinningBonus() {
        return statistics.stream()
                .mapToLong(Rank::getWinningBonus)
                .sum();
    }

    private long countTicket() {
        return (long) statistics.size();
    }

    private double toDouble(long value) {
        return Long.valueOf(value).doubleValue();
    }

}
