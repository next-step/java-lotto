package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.constant.Constant.*;

public class WinningStatic {
    private static final int WINNING_THRESHOLD = 3;
    private LinkedHashMap<Long, Integer> hitCountWinnerNumber;
    private long totalRevenue = 0;

    public WinningStatic(long totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public WinningStatic(LinkedHashMap<Long, Integer> hitCountWinnerNumber) {
        this.hitCountWinnerNumber = hitCountWinnerNumber;
    }

    public WinningStatic() {
        this.hitCountWinnerNumber = new LinkedHashMap<>();
        this.hitCountWinnerNumber.put(HIT_COUNT_3, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_4, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_5, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_6, 0);
    }

    public void countHitNumber(Long hitCount) {
        if (hitCount < WINNING_THRESHOLD) return;
        Integer winnerNumber = hitCountWinnerNumber.get(hitCount);
        hitCountWinnerNumber.put(hitCount, winnerNumber + 1);
    }

    public long calculateTotalRevenue() {
        for (Map.Entry<Long, Integer> entry : hitCountWinnerNumber.entrySet()) {
            Long hitCount = entry.getKey();
            Integer winnerNumber = entry.getValue();
            Long revenue = WinningRule.findRevenue(hitCount);
            this.totalRevenue += winnerNumber * revenue;
        }
        return totalRevenue;
    }

    public double returnRate(int expend) {
        return Double.valueOf(this.totalRevenue) / expend;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, Integer> entry : hitCountWinnerNumber.entrySet()) {
            Long hitCount = entry.getKey();
            Integer winnerNumber = entry.getValue();
            Long revenue = WinningRule.findRevenue(hitCount);
            result.append(hitCount + "개 일치 (")
                    .append(revenue + "원) - ")
                    .append(winnerNumber + "개\n");
        }

        return result.toString();
    }
}
