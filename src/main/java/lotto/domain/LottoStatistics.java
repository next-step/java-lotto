package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private Map<String, Integer> winCounts;
    private double winPercent;

    public LottoStatistics() {
        Map<String, Integer> winCounts = new HashMap<>();
        for(Rank rank : Rank.values()){
            winCounts.put(rank.name(), 0);
        }
        this.winCounts = winCounts;
        this.winPercent = 0;
    }

    public void updateWinCounts(Rank rank) {
        winCounts.computeIfPresent(rank.name(), (key, value) -> ++value);
    }

    public void updateWinPercent(BigDecimal consume) {
        BigDecimal income = new BigDecimal(calculateIncome());

        this.winPercent = income.divide(consume, 4, RoundingMode.FLOOR)
                .multiply(new BigDecimal(100))
                .doubleValue();
    }

    private int calculateIncome() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinMoney() * winCounts.get(rank.name()))
                .sum();
    }

    public Map<String, Integer> getWinCounts() {
        return winCounts;
    }

    public double getWinPercents() {
        return winPercent;
    }
}
