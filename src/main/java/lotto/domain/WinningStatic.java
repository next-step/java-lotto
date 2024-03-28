package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.domain.WinningType.*;

public class WinningStatic {
    private static final int WINNING_THRESHOLD = 3;
    private Map<WinningType, Integer> hitCountWinnerNumber;
    private long totalRevenue = 0;

    public WinningStatic(long totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public WinningStatic(Map<WinningType, Integer> hitCountWinnerNumber) {
        this.hitCountWinnerNumber = hitCountWinnerNumber;
    }

    public WinningStatic() {
        this.hitCountWinnerNumber = new LinkedHashMap<>();
        this.hitCountWinnerNumber.put(HIT_COUNT_3, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_4, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_5, 0);
        this.hitCountWinnerNumber.put(HIT_COUNT_6, 0);
    }


    public Map<WinningType, Integer> getHitCountWinnerNumber() {
        return hitCountWinnerNumber;
    }

    public void countHitNumber(Long hitCount) {
        if (hitCount < WINNING_THRESHOLD) return;
        Integer winnerNumber = hitCountWinnerNumber.get(WinningType.findByHitCount(hitCount));
        hitCountWinnerNumber.put(WinningType.findByHitCount(hitCount), winnerNumber + 1);
    }

    public long calculateTotalRevenue() {
        for (Map.Entry<WinningType, Integer> entry : hitCountWinnerNumber.entrySet()) {
            WinningType winningType = entry.getKey();
            Integer winnerNumber = entry.getValue();
            this.totalRevenue += winningType.getRevenue() * winnerNumber;
        }
        return totalRevenue;
    }

    public double returnRate(int expend) {
        return Double.valueOf(this.totalRevenue) / expend;
    }
}
