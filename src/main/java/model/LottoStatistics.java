package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private Map<Prize, Integer> counts = new HashMap<>();
    private double netIncome;

    public LottoStatistics(List<Prize> prizes, int totalPrice) {
        Map<Prize, Integer> counts = new HashMap<>();
        counts.put(Prize.PRIZE3, 0);
        counts.put(Prize.PRIZE4, 0);
        counts.put(Prize.PRIZE5, 0);
        counts.put(Prize.PRIZE6, 0);
        for (Prize prize : prizes) {
            counts.put(prize, counts.get(prize) + 1);
        }
        this.counts = counts;
        this.netIncome = calculateNetIncome(totalPrice, getTotalIncome(counts));
    }

    public int getCountByPrize(Prize prize) {
        return this.counts.get(prize);
    }


    public double getNetIncome() {
        return netIncome;
    }

    private int getTotalIncome(Map<Prize, Integer> counts) {
        return Arrays.stream(Prize.values())
                .map(it -> counts.get(it) * it.getPrice())
                .reduce(0, Integer::sum);
    }

    private double calculateNetIncome(int totalPrice, int totalIncome) {
        double netIncome = ((double) totalIncome / (double) totalPrice);
        return Double.parseDouble(String.format("%.2f", netIncome));
    }
}
