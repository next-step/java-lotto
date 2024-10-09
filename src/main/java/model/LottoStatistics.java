package model;

import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private int cnt3;
    private int cnt4;
    private int cnt5;
    private int cnt6;
    private double netIncome;

    public LottoStatistics(Map<Integer, Integer> counts, int totalPrice) {
        this.cnt3 = counts.get(3);
        this.cnt4 = counts.get(4);
        this.cnt5 = counts.get(5);
        this.cnt6 = counts.get(6);
        this.netIncome = calculateNetIncome(totalPrice, getTotalIncome(counts));
    }

    public int getCnt3() {
        return cnt3;
    }

    public int getCnt4() {
        return cnt4;
    }

    public int getCnt5() {
        return cnt5;
    }

    public int getCnt6() {
        return cnt6;
    }

    public double getNetIncome() {
        return netIncome;
    }

    private int getTotalIncome(Map<Integer, Integer> counts) {
        List<Integer> includeMatched = List.of(3, 4, 5, 6);
        Integer sum = includeMatched.stream()
                .map(it -> counts.get(it) * Prize.getPrize(it).getPrice())
                .reduce(0, Integer::sum);
        return sum;
    }

    private double calculateNetIncome(int totalPrice, int totalIncome) {
        double netIncome = ((double) totalIncome / (double) totalPrice);
        return Double.parseDouble(String.format("%.2f", netIncome));
    }
}
