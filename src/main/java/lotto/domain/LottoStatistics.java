package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.LottoGame.TICKET_PRICE;

public class LottoStatistics {

    private Map<Rank, Integer> winCounts;
    private double winPercent;

    public LottoStatistics(Map<Rank, Integer> winCounts) {
        this.winCounts = winCounts;
        this.winPercent = calculateWinPercent(winCounts);
    }

    private double calculateWinPercent(Map<Rank, Integer> winCounts) {
        int ticketSize = winCounts.values().stream().mapToInt(Integer::intValue).sum();
        BigDecimal consume = new BigDecimal(ticketSize * TICKET_PRICE);
        BigDecimal income = new BigDecimal(calculateIncome(winCounts));

        return income.divide(consume, 4, RoundingMode.FLOOR)
                .multiply(new BigDecimal(100))
                .doubleValue();
    }

    private int calculateIncome(Map<Rank, Integer> winCounts) {
        return winCounts.keySet().stream()
                .mapToInt(rank -> rank.getWinMoney() * winCounts.get(rank))
                .sum();
    }

    public Map<Rank, Integer> getWinCounts() {
        return new HashMap<>(winCounts);
    }

    public double getWinPercents() {
        return winPercent;
    }
}
